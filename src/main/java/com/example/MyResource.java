package com.example;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET
    @Path("/otherstuff")
    public String getOtherStuff(@QueryParam("name") String name, 
    		@QueryParam("address") String address,
    		@DefaultValue("UNSET") @HeaderParam("x-simon-header") String simonHeader) {
    	return "other stuff, name is " + name
    			+ " and address is " + address
    			+ " header is " + simonHeader;
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
    
}
