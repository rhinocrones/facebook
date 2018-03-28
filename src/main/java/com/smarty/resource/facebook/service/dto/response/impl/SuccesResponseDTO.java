package com.smarty.resource.facebook.service.dto.response.impl;

import java.io.Serializable;

public class SuccesResponseDTO extends Response implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 5274083796792973675L;

    private Object data;
    
    public SuccesResponseDTO(Integer statusCode, Object data) {
	super(statusCode);
	this.data = data;
    }

    public Object getData()
    {
	return data;
    }

    public void setData(Object data)
    {
	this.data = data;
    }
}
