package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;

import com.example.MyData;

public class SimpleClient {

	public static void main(String[] args) {
		Client cl = ClientBuilder.newClient();
		cl.register(MoxyJsonFeature.class);
		WebTarget base = cl.target("http://localhost:8080/simple-service-webapp/webapi");
		WebTarget name = base.path("customers/2/name");
		
		Invocation.Builder ib = name.request(MediaType.TEXT_PLAIN);
		Response resp = ib.get();
		
		String responseName = resp.readEntity(String.class);
		int status = resp.getStatus();
		MultivaluedMap<String, String> map = resp.getStringHeaders();
		
		map.forEach((k,v) -> {
			System.out.println("Header: " + k);
			v.forEach(s->System.out.println(" - " + s));
		});
		System.out.println("Status is  " + status);
		System.out.println("Name is : " + responseName);
		
		System.out.println("------------------------------------------------------");
		MyData md = new MyData("Albert", 6);
		WebTarget postBase = base.path("myresource/mydatas");
		ib = postBase.request();
		ib.accept(MediaType.APPLICATION_XML);
		Response xmlResp = ib.buildPost(Entity.xml(md)).invoke();
		
		md = xmlResp.readEntity(MyData.class);
		System.out.println("Returned " + md);
		
	}

}
