package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.dao.CustomerDAO;
import com.entity.Customer;

@Path("/customers")
public class CustomersRootResource {
	@Path("/{id: \\d+}")
	// NO HTTP METHOD ANNOTATION!!!! Does NOT complete the request
	public CustomerNav findByPk(@PathParam("id") int pk) throws MyDBPKNotFoundException {
		System.out.println("in findByPk " + pk);
		// look up in database
		Customer c = CustomerDAO.findByPrimaryKey(pk);
		return new CustomerNav(c);
	}
	
	// MUST NOT HAVE another method that handles the same path/path-root as a navigation method!!!!
//	@Path("/{id: \\d+}")
//	@GET
//	public String doBroken() {
//		
//	}
}
