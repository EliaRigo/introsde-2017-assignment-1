import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Person;
import dao.PeopleStore;

public class HealthProfileReader { 
	
	public static PeopleStore people = new PeopleStore();

	public static void main(String[] args) {
		try {
			init();
			printAll();
		} catch (FileNotFoundException | JAXBException e) {
			e.printStackTrace();
		}
    }
	
	public static void init() throws JAXBException, FileNotFoundException {
		JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
        Unmarshaller um = jc.createUnmarshaller();
        people = (PeopleStore) um.unmarshal(new FileReader("people.xml"));
	}
	
	public static void printAll() {
		System.out.println("Entro1");
        List<Person> list = people.getData();
        for (Person person : list) {
        	System.out.println("Entro");
        	System.out.println(person.toString());
        }
	}
}
