package service.register;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import _03.standardEntityProvider.ProviderResource;
import _04.jaxb.xml.CustomerResource;
import _04.jaxb.xml.PersonResource;
import _05.json.jackson.CustomerResourceJSON;
import _05.json.jackson.PersonResourceJSON;
import _06.json.jettison.ProductResourceJettison;

@ApplicationPath("/root-path") // OK
public class RegisterApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public RegisterApplication() {
		singletons.add(new ProviderResource());
		singletons.add(new PersonResource());
		singletons.add(new CustomerResource());
		singletons.add(new PersonResourceJSON());
		singletons.add(new CustomerResourceJSON());
		singletons.add(new ProductResourceJettison());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
