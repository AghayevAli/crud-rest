package exception;

import persistence.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
    @Override
    public Response toResponse(DataNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), "404", "https://10fastfingers.com/typing-test/english");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
}