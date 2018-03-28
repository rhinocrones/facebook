package com.smarty.resource.facebook.service.dto.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restfb.types.webhook.base.From;
import com.smarty.resource.facebook.utils.constants.FacebookConstants;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentComment implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -2316800204472676588L;

    private String id;

    private long created_time;

    private From from;

    private String message;

    public String getId()
    {
	return id;
    }

    public void setId(String id)
    {
	this.id = id;
    }

    public long getCreated_time()
    {
	return created_time;
    }

    public void setCreated_time(long created_time)
    {
	this.created_time = created_time * FacebookConstants.THOUSAND;
    }

    public From getFrom()
    {
	return from;
    }

    public void setFrom(From from)
    {
	this.from = from;
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
