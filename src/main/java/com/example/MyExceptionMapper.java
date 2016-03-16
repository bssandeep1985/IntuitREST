package com.example;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyExceptionMapper implements ExceptionMapper<MyDBPKNotFoundException> {

	@Override
	public Response toResponse(MyDBPKNotFoundException arg0) {
		return Response.status(Response.Status.NOT_FOUND)
				.entity("Exception in Datatbase, PK " + arg0.getPk() + " not found, exception is "
						+ arg0.getMessage())
				.build();
	}
}
