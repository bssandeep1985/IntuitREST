package com.dao;

import java.util.HashMap;
import java.util.Map;

import com.entity.Customer;
import com.example.MyDBPKNotFoundException;

public class CustomerDAO {
	private static Map<Integer, Customer> data = new HashMap<>();
	static {
		data.put(1, new Customer("Fred", "Over here"));
		data.put(2, new Customer("Jim", "Over there"));
		data.put(3, new Customer("Sheila", "Over the rainbow"));
	}

	public static Customer findByPrimaryKey(int pk) throws MyDBPKNotFoundException {
		System.out.println("in CustomerDAO.findByPrimaryKey...");
		Customer rv = data.get(pk);
		if (rv == null) {
			throw new MyDBPKNotFoundException(pk);
		}
		return rv;
	}
}
