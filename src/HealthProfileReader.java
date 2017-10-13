import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Person;
import dao.PeopleStore;

/**
 * @author EliaRigo
 *
 */
public class HealthProfileReader {
	
	public static File database = new File("people.xml");
	public static PeopleStore people = new PeopleStore();

	public static void main(String[] args) {
		try {
			init();
			printAll();
			XPathController xp = new XPathController(database);
			System.out.println(xp.getActivityPreferenceByPeopleId(5));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public static void init() throws JAXBException, FileNotFoundException {
		JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
        Unmarshaller um = jc.createUnmarshaller();
        people = (PeopleStore) um.unmarshal(new FileReader(database));
	}
	
	public static void printAll() {
        List<Person> list = people.getData();
        for (Person person : list) {
        	System.out.println(person.toString());
        }
	}
}
