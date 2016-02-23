package org.learn.rs.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.learn.rs.messenger.model.ErrorMessage;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<NullPointerException> {

	@Override
	public Response toResponse(NullPointerException exception) {
		ErrorMessage errorMessage = new ErrorMessage();

		errorMessage.setMessage("here message gone");
		errorMessage.setStatus(101);

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}
