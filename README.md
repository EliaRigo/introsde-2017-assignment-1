## INTROSDE  Assignment 01: Reading/Writing objects to and from XML and JSON

**Identification**: your full name and email address.

**Project**: description of the project (2 paragraphs). 1 paragraph about the code, 1 paragraph about the tasks the code does.

**Execution**: execution procedure of this Assignment (How to run it). We will follow this description to compile and evaluate your result.

**Additional Notes**: Additional observations if necessary.

## Identification

**Elia Rigo**

**190487**

**elia.rigo@studenti.unitn.it**

## Code
**introsde-2017-assignment-1**

The **src** folder contains all the Java classes necessary to perform the task request of the assignment.
In particular:
* The **dao** package contains the PeopleStore class necessary to perform the operation of marshaling, unmarshalling and JSONification.
* The **model** package contains all the model class of our service (Person.java and ActivityPerson.java)
* The **default** package contains the "logical" classes: ActivityProfileReader.java, MarshallingJAXB.java and XPATHController.java.

The **out** folder contains an example of generated output by the task of the assignment (new_people.xml and new_people.json)

In the **root** folder there is:
* People.xml:  the database of our project
* Perople.xsd: request in the first task of our assignment
* build.xml: and ivy.xml that contains the ant-script part
* out.txt: a console output example of the command ```execute.evaluation``` of the ant-script
* README.md: this file

## Tasks

The **ActivityProfileReader** contains a switch with the 6 tasks of the assignment.
It is possible to launch one of this task simply passing the following first arguments:
* ```printall``` : this function display all the people in the file people.xml
* ```get-activity```: this function accepts the person id as a second argument and prints the ActivityPreference of the person with that id
* ```get-activity-date```: this function accepts a date (as second argument) and an operator (=, > , <) as third argument; and prints people which preferred activity ```start_date fulfill``` fullfill that condition
* ```marshalling```: this function operates the marshaling into out/new_people.xml
* ```unmarshalling```: this function operates the unmarshalling from PeopleStore instantiated from a specific file: out/new_people.xml
* ```json```: this function: generate a json from the people in PeopleStore

## Execution

The code can be executed in a terminal with the following command:
* move in the root directory project with ```cd /<ROOT_PROJECT_DIR>/```
* launch the ant-script with ```ant execute.evaluation```

Now in the console it should be possible to see all the output of the assignment.

It is also possible to launch single commands of the ```ant execute.evaluation``` with:
* ```execute.printall```: to display all the people in the file people.xml
* ```execute.get-activity```: to display the ActivityPreference of the person with ID 5
* ```execute.get-activity-date```: to display the people with a startdate greather than 2017-10-13
* ```execute.marshalling```: to operate the marshaling into out/new_people.xml
* ```execute.unmarshalling```: to operate the unmarshalling from PeopleStore instantiated from a specific file: out/new_people.xml
* ```execute.json```: to generate a json from the people in PeopleStore

## Additional Notes

All the XML files, JSON files and Java files used the Standard TIMESTAMP notation:

E.g. 2017-10-13T11:50:00.0 instead of 017-13-10T11:50:00.0
