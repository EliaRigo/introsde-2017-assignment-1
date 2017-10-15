package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="activitypreference")
@XmlType(propOrder = { "name", "description", "place", "startdate" })
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivityPreference {
	private String name;
	private String description;
	private String place;
	private String startdate;
	// XmlAttribute indicates that this field will be serialized as an attribute
	@XmlAttribute(name="id")
	private Long activityPreferenceId;
	
	public ActivityPreference() {
		
	}
	
	public ActivityPreference(Long activityPreferenceId, String name, String description, String place, String startDate) {
		this.activityPreferenceId = activityPreferenceId;
		this.name = name;
		this.description = description;
		this.place = place;
		this.startdate = startDate;
	}
	
	// Follow getter and setter for every attribute of this class
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getStartDate() {
		return startdate;
	}
	public void setStartDate(String startDate) {
		this.startdate = startDate;
	}
	public Long getActivityPreferenceId() {
		return activityPreferenceId;
	}
	public void setActivityPreferenceId(Long activityPreferenceId) {
		this.activityPreferenceId = activityPreferenceId;
	}
	
	@Override
	public String toString() {
		String tmp = "";
		tmp += String.format("|    +--- Activity Preference Id: %d\n", this.activityPreferenceId);
		tmp += String.format("|    |--- Name: %s\n", this.name);
		tmp += String.format("|    |--- Description: %s\n", this.description);
		tmp += String.format("|    |--- Place: %s\n", this.place);
		tmp += String.format("|    |--- Start Date: %s", this.startdate);
		
		return tmp;
	}

}
