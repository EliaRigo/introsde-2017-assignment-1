import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

/**
 * @author EliaRigo
 *
 */
public class XPathController {
	
	/**
	 * The representation of the XML file
	 */
	Document db;
	/**
	 * The XPath evaluator
	 */
	XPath xpath;

	/**
	 * Constructor of XPathController class
	 * @param database Database file
	 */
	public XPathController(File database) {
		// Initialize XML parser factory
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true);
	    try {
	    	// Initialize XML parser
	    	DocumentBuilder builder = domFactory.newDocumentBuilder();
	    	// Parsing document
			db = builder.parse(database);			
		    // Initialize XPath factory
		    XPathFactory factory = XPathFactory.newInstance();
		    // Initialize XPath evaluator
		    xpath = factory.newXPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get ActivityPreference of a specific person with id
	 * @param id Id of the Person
	 * @return Formatted string with ActivityPreference data
	 * @throws XPathExpressionException
	 */
	public String getActivityPreferenceByPeopleId(int id) throws XPathExpressionException {
		String tmp = "";
		tmp += String.format("Activity preference of person with id: %d\n", id);
		tmp += String.format("Name: %s\n", this.getActivityName(id));
		tmp += String.format("Description: %s\n", this.getActivityDescription(id));
		tmp += String.format("Place: %s\n", this.getActivityPlace(id));
		tmp += String.format("Start Date: %s", this.getActivityStartDate(id));
		
		return tmp;
	}
	
	/**
	 * Get the value of ActivityPreferenceData specified by Person id and type
	 * @param id Id of the Person
	 * @param type XML tag of the data searched
	 * @return String value of data searched
	 * @throws XPathExpressionException
	 */
	private String getActivityPreferenceData(int id, String type) throws XPathExpressionException {
		// XPath query
		XPathExpression expr = xpath.compile("/people/person[@id=" + id + "]/activitypreference/" + type);
	    // XPath evaluation
		return (String) expr.evaluate(db, XPathConstants.STRING);    
	}
	
	/**
	 * Get String value of Activity Preference - Name
	 * @return String value of Activity Preference - Name
	 * @throws XPathExpressionException
	 */
	private String getActivityName(int id) throws XPathExpressionException {
		return getActivityPreferenceData(id, "name");
	}
	
	/**
	 * Get String value of Activity Preference - Description
	 * @return String value of Activity Preference - Description
	 * @throws XPathExpressionException
	 */
	private String getActivityDescription(int id) throws XPathExpressionException {
		return getActivityPreferenceData(id, "description");
	}
	
	/**
	 * Get String value of Activity Preference - Place
	 * @return String value of Activity Preference - Place
	 * @throws XPathExpressionException
	 */
	private String getActivityPlace(int id) throws XPathExpressionException {
		return getActivityPreferenceData(id, "place");
	}
	
	/**
	 * Get String value of Activity Preference - Start Date
	 * @return String value of Activity Preference - Start Date
	 * @throws XPathExpressionException
	 */
	private String getActivityStartDate(int id) throws XPathExpressionException {
		return getActivityPreferenceData(id, "startdate");
	}
}
