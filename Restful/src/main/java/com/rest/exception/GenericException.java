package com.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public abstract class GenericException  <E extends Throwable>  implements ExceptionMapper<E> {

    protected abstract Response handleResponse(E e);

    @Override
    public Response toResponse(E e) {
        return handleResponse(e);
    }
}
