import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import model.ActivityPreference;
import model.Person;
import dao.PeopleStore;

public class MarshallingJAXB {
	// Create a new PeopleStore
	public static PeopleStore people = new PeopleStore();
	// Declare the output File
	public static File outFile = new File("out/new_people.xml");

	/**
	 * This function will add three people to the PeopleStore set
	 */
	public static void addPeople() {
		ActivityPreference aP1 = new ActivityPreference(121L, "Cycling", "Cycling in the beatiful Trentino landscape",
				"Trentino-A.A.", "2017-10-14T12:00:00.0");
		ActivityPreference aP2 = new ActivityPreference(122L, "Boxe", "Perform Boxe with my coach", "Sanbabila Gym",
				"2017-10-20T17:45:00.0");
		ActivityPreference aP3 = new ActivityPreference(123L, "Curling", "Curling with my friends",
				"Palaghiaccio Trento", "2017-10-29T21:00:00.0");

		Person p1 = new Person(21L, "Gianni", "Longo", "1999-08-21", aP1);
		Person p2 = new Person(22L, "Marco", "Pinozzo", "1991-03-04", aP2);
		Person p3 = new Person(23L, "Giuseppe", "Siano", "1995-04-15", aP3);

		people.getData().add(p1);
		people.getData().add(p2);
		people.getData().add(p3);
	}

	/**
	 * This function will perform the marshalling creating a new XML File
	 * in the path %ROOT_PROJECT/new_people.xml% 
	 * @throws JAXBException
	 */
	public static void doMarshalling() throws JAXBException {
		// Fill the peopleStore set
		addPeople();
		// The JAXBContext instance is initialized
		JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
		// Create Marshaller
		Marshaller m = jc.createMarshaller();
		// Set to perform a formatted output
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		System.out.println("Marshalling into a XML file(out/new_people.xml)..... ");
		// Marshalling into a file
		m.marshal(people, outFile);
		// Printing the output
		System.out.println("############################");
		System.out.println("out/new_people.xml: ");
		System.out.println();
		// Marshalling into the System standard output
		m.marshal(people, System.out);
		System.out.println("############################");
	}

	/**
	 * This function will perform the unmarshalling from
	 * a xml File
	 * @throws Exception
	 */
	public static void doUnMarshalling() throws Exception {
		System.out.println();
		System.out.println("############################");
		System.out.println("Output from out/new_people.xml XML File: ");
		// The JAXBContext instance is initialized
		JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
		// Create Unmarshaller
		Unmarshaller um = jc.createUnmarshaller();
		// Fill the PeopleStore set with the unmarshal of the specified file (out/new_people.xml)
		PeopleStore people = (PeopleStore) um.unmarshal(new FileReader(outFile));
		// Get and print data
		List<Person> list = people.getData();
		for (Person person : list) {
			System.out.println(person.toString());
		}
	}
	
	/**
	 * This function will write a JSON file with the new people added
	 * by the function addPeople
	 * @throws Exception
	 */
	public static void doJSON() throws Exception {
		addPeople();
		// Initialize the Jackson Object Mapper 
		ObjectMapper mapper = new ObjectMapper();
		// Initialize the Jackson Module to process JAXB annotations
        JaxbAnnotationModule module = new JaxbAnnotationModule();
		// Follow necessary configurations
        mapper.registerModule(module);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        
        // Get result from mapper and write it to a new JSON file
        System.out.println("############################");
        System.out.println("Write into out/new_people.json JSON File");
        String result = mapper.writeValueAsString(people);
        mapper.writeValue(new File("out/new_people.json"), people);
        System.out.println("############################");
        System.out.println("out/new_people.json: ");
        // Print the result also into the System standard output
        System.out.println(result);
        System.out.println("############################");
	}
}
