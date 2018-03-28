package com.smarty.resource.facebook.service.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonReactionDTO implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1993918915199646176L;

    private Paging paging;

    public Paging getPaging()
    {
	if (paging == null)
	{
	    paging = new Paging();
	}
	return paging;
    }

    public void setPaging(Paging paging)
    {
	this.paging = paging;
    }
}
