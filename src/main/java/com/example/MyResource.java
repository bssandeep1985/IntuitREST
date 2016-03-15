package com.example;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
//@Singleton
public class MyResource {
	@HeaderParam("x-simon") String simonHeader;
	@HeaderParam("x-fred") String fredHeader;
	{
		System.out.println("Instantiating MyResource...");
	}
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it! simon header is " + simonHeader
        		+ " fredHeader is " + fredHeader;
    }
    
    @GET
    @Path("/otherstuff")
    public String getOtherStuff(@QueryParam("name") String name, 
    		@QueryParam("address") String address
//    		, @DefaultValue("UNSET") @HeaderParam("x-simon-header") String simonHeader
    		) {
    	return "other stuff, name is " + name
    			+ " and address is " + address 
    			+ " simon header is " + simonHeader
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
    public String getFancyPath(@PathParam("path") String path,
    		@Context UriInfo uriInfo) {
    	
    	return "path is: " + path
    			+ " absolute is: " + uriInfo.getAbsolutePath();
    }
}
