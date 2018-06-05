package _05.json.jackson;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

@Path("/person-json")
public class PersonResourceJSON {

	@GET
	@Path("/person")
	// http://localhost:8080/RESTEasyWeek03/root-path/person-json/person
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson() {
		Person person = new Person(1, "levent", "erguder");
		return person;
	}

	@GET
	@Path("/personList")
	// http://localhost:8080/RESTEasyWeek03/root-path/person-json/personList
	@Produces(MediaType.APPLICATION_JSON)
	@Wrapped(element = "list", namespace = "http://foo.org", prefix = "foo")
	public List<Person> getPersonList() {
		Person person0 = new Person(0, "test0", "test surname0");
		Person person1 = new Person(1, "test1", "test surname1");
		Person person2 = new Person(2, "test2", "test surname2");

		return Arrays.asList(person0, person1, person2);
	}

	@GET
	@Path("/personArray")
	@Produces(MediaType.APPLICATION_JSON)
	public Person[] getPersonArray() {
		Person person0 = new Person(0, "test0", "test surname0");
		Person person1 = new Person(1, "test1", "test surname1");
		Person person2 = new Person(2, "test2", "test surname2");

		Person[] persons = new Person[] { person1, person0, person2 };
		return persons;
	}

}

// JAXB -> Java Architecture for XML Binding
// Marshalling -> java objelerinin -> xml e donusme islemi
// Unmarshalling -> xml iceriginin java objelerine donusmesi