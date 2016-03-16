package com.example;

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
}
