package com.example;

public class MyDBPKNotFoundException extends Exception {
	private int pk;
	
	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public MyDBPKNotFoundException(int pk) {
		super();
		this.pk = pk;
		// TODO Auto-generated constructor stub
	}

	public MyDBPKNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MyDBPKNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyDBPKNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyDBPKNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
