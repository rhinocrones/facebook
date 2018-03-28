package com.smarty.resource.facebook.service.dto.response.impl;

import java.io.Serializable;

public class ErrorResponseDTO extends Response implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 6490692155091382966L;

    private String message;

    public ErrorResponseDTO(Integer statusCode, Object message) {
	super(statusCode);
	this.message = (String) message;
    }
    
    public String getMessage()
    {
	return message;
    }

    public void setMessage(String message)
    {
	this.message = message;
    }
}
