package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// XmlRootElement defines the root element of the XML tree to which this class will be serialized
// --> <person> ... </person> 
@XmlRootElement(name = "person")	
// XmlType can optionally define the order in which the fields of person are written
@XmlType(propOrder = { "firstname", "lastname", "birthdate", "aPreference" })
// XmlAccessorType indicates what to use to create the mapping: either FIELDS, PROPERTIES (i.e., getters/setters), PUBLIC_MEMBER or NONE (which means, you should indicate manually)
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
	private String firstname;		
	private String lastname;
	private String birthdate;
	// XmlElement indicates the element to use for this field. Only used if the name in XML will be different than that in the class
	@XmlElement(name="activitypreference")
	private ActivityPreference aPreference;	
	// XmlAttribute indicates that this field will be serialized as an attribute
	@XmlAttribute(name="id")
	private Long personId;
	
	public Person() {
		this.personId = (long) -1.0;
		this.firstname = "";
		this.lastname = "";
		this.birthdate = "";
		this.aPreference = new ActivityPreference();
	}
	
	public Person(Long personId, String firstname, String lastname, String birthdate, Long activityPreferenceId, String name, String description, String place, String startDate) {
		this.personId = personId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.aPreference = new ActivityPreference(activityPreferenceId, name, description, place, startDate);
	}
	
	// Follow getter and setter for every attribute of this class
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public ActivityPreference getaPreference() {
		return aPreference;
	}
	public void setaPreference(ActivityPreference aPreference) {
		this.aPreference = aPreference;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		String tmp = "";
		tmp += String.format("+--- Person Id: %d\n", this.personId);
		tmp += String.format("|    +-- Firstname: %s\n", this.firstname);
		tmp += String.format("|    +-- Lastname: %s\n", this.lastname);
		tmp += String.format("|    +-- Birthdate: %s\n", this.birthdate);
		tmp += this.aPreference.toString();
		
		return tmp;
	}
	
}
