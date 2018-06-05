package _06.json.jettison;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/product-jettison-json")
public class ProductResourceJettison {

	@GET
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	//http://localhost:8080/RESTEasyWeek03/root-path/product-jettison-json/product
	public Product getProduct() {
		Product product = new Product();
		product.setId(1);
		product.setName("K-360");
		product.setBrand("Logitech");
		product.setPrice(99.99);
		product.setCategory("Keyboard");
		return product;
	}
}
