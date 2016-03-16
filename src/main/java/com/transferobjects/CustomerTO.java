package com.transferobjects;

import javax.xml.bind.annotation.XmlRootElement;

import com.entity.Customer;

@XmlRootElement
public class CustomerTO {
	public String name;
	public String address;
	
	public CustomerTO() {} // FOR JAX-B
	
	public CustomerTO(Customer self) {
		this.name = self.getName();
		this.address = self.getAddress();
	}

	public Customer getAsCustomer() {
		return new Customer(name, address);
	}
	
	public void applyToCustomer(Customer c) {
		if (name != null) c.setName(name);
		if (address != null) c.setAddress(address);
	}
}
