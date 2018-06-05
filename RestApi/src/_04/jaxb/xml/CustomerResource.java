package _04.jaxb.xml;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customer-jaxb-xml")
public class CustomerResource {

	@GET
	@Path("/customer")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("levent");

		Address address = new Address();
		address.setCity("istanbul");
		address.setZip("34000");

		customer.setAddress(address);

		return customer;
	}
}
