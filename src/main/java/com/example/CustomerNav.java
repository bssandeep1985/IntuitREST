package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entity.Customer;

public class CustomerNav {
	private Customer self;
	
	public CustomerNav(Customer self) {
		this.self = self;
	}
	
	@GET
	@Path("/name")
	@Produces(MediaType.TEXT_PLAIN)
	public Response doGetName() {
		System.out.println("in CustomerNav.doGetName");
		return Response.ok(self.getName()).build();
	}
	
}
