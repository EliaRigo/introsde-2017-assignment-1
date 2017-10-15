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
			switch (args[0]) {
			case "printall": {
				init();
				printAll();
			}
				break;
			case "get-activity": {
				XPathController xp = new XPathController(database);
				System.out.println(xp.getActivityPreferenceByPeopleId(Integer.parseInt(args[1])));
			}
				break;
			case "get-activity-date": {
				init();
				printActivityDate(args[1], args[2]);
			}
				break;
			case "marshalling": {
				MarshallingJAXB.doMarshalling();
			}
				break;
			case "unmarshalling": {
				MarshallingJAXB.doUnMarshalling();
			}
				break;
			case "json": {
				MarshallingJAXB.doJSON();
			}
				break;
			default: {
				System.out.println("Option not found");
			}
			}
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

	public static void printActivityDate(String chr, String date) {
		List<Person> list = people.getData();
		switch (chr) {
		case "<": {
			for (Person person : list) {
				if (person.getaPreference().getStartDate().compareTo(date) < 0) {
					System.out.println(person.toString());
				}
			}
		}
			break;
		case ">": {
			for (Person person : list) {
				if (person.getaPreference().getStartDate().compareTo(date) > 0) {
					System.out.println(person.toString());
				}
			}
		}
			break;
		case "=": {
			for (Person person : list) {
				if (person.getaPreference().getStartDate().compareTo(date) == 0) {
					System.out.println(person.toString());
				}
			}
		}
			break;
		default:
			System.out.println("Operand not found");
		}
	}
}
