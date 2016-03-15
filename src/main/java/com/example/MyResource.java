package com.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
// @Singleton
public class MyResource {
	@HeaderParam("x-simon")
	String simonHeader;
	@HeaderParam("x-fred")
	String fredHeader;
	{
		System.out.println("Instantiating MyResource...");
	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it! simon header is " + simonHeader + " fredHeader is " + fredHeader;
	}

	@GET
	@Path("/otherstuff")
	public String getOtherStuff(@QueryParam("name") String name, @QueryParam("address") String address
	// , @DefaultValue("UNSET") @HeaderParam("x-simon-header") String
	// simonHeader
	) {
		return "other stuff, name is " + name + " and address is " + address + " simon header is " + simonHeader
				+ " fredHeader is " + fredHeader;
	}

	@DELETE
	@Path("/otherstuff")
	public String deleteOtherStuff() {
		return "DELETED other stuff";
	}

	// resource e.g. .../customers/<pk>
	@GET
	@Path("/customers/ID-{id: \\d+}")
	public String getOneCustomer(@PathParam("id") String theId) {
		return "This is customer " + theId;
	}

	@GET
	@Path("/headers")
	public String getAllHeaders(@Context HttpHeaders headers) {
		String name = headers.getHeaderString("x-name");
		return "name is " + name;
	}

	@GET
	@Path("/path/{path: [a-zA-Z0-9/-]*}")
	public String getFancyPath(@PathParam("path") String path, @Context UriInfo uriInfo) {

		return "path is: " + path + " absolute is: " + uriInfo.getAbsolutePath();
	}

	@Path("/response")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getResponse() {
		ResponseBuilder rb = Response.ok();

		if (Math.random() > 0.5) {
			rb.entity("Simple response, it worked...");
			rb.header("x-something", "something interesting as a value");
		} else {
			rb.entity("Broken! ouch");
			rb.status(Response.Status.NOT_FOUND);
			rb.header("x-reason", "you asked a silly question");
		}

		return rb.build();
	}

	@Path("/response")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response getHttpResponse() {
		ResponseBuilder rb = Response.ok();

		if (Math.random() > 0.5) {
			rb.entity("<HTML><BODY><p>HTML response, it worked...</P></BODY></HTML>");
			rb.header("x-something", "something interesting as a value");
		} else {
			rb.entity("Broken HTML! ouch");
			rb.type(MediaType.TEXT_PLAIN);
			rb.status(Response.Status.NOT_FOUND);
			rb.header("x-reason", "you asked a silly question");
		}

		return rb.build();
	}
	
	@Path("/mydatas/{id: \\d+}")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getOneMyData(@PathParam("id") int id) {
		ResponseBuilder rb = Response.ok();
		
		MyData md = new MyData("Fred", 99);
		rb.entity(md);
		
		return rb.build();
	}
	
	@Path("/mydatas")
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response createOneMyData(MyData md) {
		ResponseBuilder rb = Response.ok();
		
		System.out.println("Received a MyData: " + md);
		
		md.count += 1;
		md.name = "Mx. " + md.name;
		rb.entity(md);
		rb.header("location", "1234");
		
		return rb.build();
	}
}
