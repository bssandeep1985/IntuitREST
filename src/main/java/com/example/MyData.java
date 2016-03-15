package com.example;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyData {
	public String name;
	public Integer count;
	public MyOtherData mod = new MyOtherData();
	
	public MyData() {} // <-- REQUIRED FOR JAX-B

	public MyData(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	@Override
	public String toString() {
		return "MyData [name=" + name + ", count=" + count + "]";
	}
}
