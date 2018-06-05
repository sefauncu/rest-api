package _04.jaxb.xml;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

@Path("/person-jaxb-xml")
public class PersonResource {

	@GET
	@Path("/person")
	// http://localhost:8080/RESTEasyWeek03/root-path/person-jaxb-xml/person
	@Produces(MediaType.APPLICATION_XML)
	public Person getPerson() {
		Person person = new Person(1, "levent", "erguder");
		return person;
	}
	
	@GET
	@Path("/getPersonWithJaxbContext")
	@Produces(MediaType.APPLICATION_XML)
	public String getPersonWithJaxbContext() throws JAXBException {
		Person person = new Person(1, "levent", "erguder");
		JAXBContext context = JAXBContext.newInstance(Person.class);
		StringWriter writer = new StringWriter();
		context.createMarshaller().marshal(person, writer);
		return writer.toString();
	}

	@GET
	@Path("/personList")
	@Produces(MediaType.APPLICATION_XML)
	@Wrapped(element = "list", namespace = "http://foo.org", prefix = "foo")
	public List<Person> getPersonList() {
		Person person0 = new Person(0, "test0", "test surname0");
		Person person1 = new Person(1, "test1", "test surname1");
		Person person2 = new Person(2, "test2", "test surname2");

		return Arrays.asList(person0, person1, person2);
	}

	@GET
	@Path("/personArray")
	@Produces(MediaType.APPLICATION_XML)
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