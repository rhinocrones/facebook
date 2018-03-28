package com.smarty.resource.facebook.service.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Paging implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1291057510044047598L;

    private String next;

    public String getNext()
    {
	return next;
    }

    public void setNext(String next)
    {
	this.next = next;
    }
}
