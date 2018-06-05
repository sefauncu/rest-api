package _05.json.jackson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

	@XmlElement(name="personId")
	// default olarak getter mtodu uzerinde olmali.
				// XmlAccessType.FIELD olarak belirttik
	private int id;
	//@XmlElement
	private String name;
	//@XmlElement
	private String surname;

public Person() {
	super();
	/*
	 * com.sun.xml.bind.v2.runtime.IllegalAnnotationsException: 1 counts of
	 * IllegalAnnotationExceptions _04.jaxb.xml.Person does not have a no-arg
	 * default constructor. this problem is related to the following location:
	 * at _04.jaxb.xml.Person
	 */
	}

	public Person(int id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
