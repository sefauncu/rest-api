package _03.standardEntityProvider;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

@Path("/provider")
public class ProviderResource {

	@GET
	@Path("/streamingOutput")
	@Produces(MediaType.TEXT_PLAIN)
	
	public StreamingOutput streamingOutput() {
//		StreamingOutput sOutput = new StreamingOutput() {
//			@Override
//			public void write(OutputStream os) throws IOException, WebApplicationException {
//				String message = "streamingOutput isCalled.";
//				os.write(message.getBytes());
//			}
//		};
//		return sOutput;
		
		// Java8 lambda
		String message = "streamingOutput isCalled.";
		StreamingOutput sOutput = (OutputStream os) -> os.write(message.getBytes());
		return sOutput;
	}

	@GET
	@Path("/byteArray")
	@Produces(MediaType.TEXT_PLAIN)
	// http://localhost:8080/RESTEasyWeek03/root-path/provider/byteArray
	public byte[] byteArray() {
		String message = "byteArray is called";
		return message.getBytes();
	}
	
	@GET
	//@Produces(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/stringXMLResponse")
	public String stringXMLResponse() {
		String message = "<customer><name>Levent Erguder</name></customer>";
		return message;
	}
	
	
	@GET
	@Path("/file")
	@Produces(MediaType.TEXT_PLAIN)
	public File getFile() throws URISyntaxException {
		URI uri = getClass().getClassLoader().getResource("file.txt").toURI();
		File file = new File(uri);
		return file;
	}
}
