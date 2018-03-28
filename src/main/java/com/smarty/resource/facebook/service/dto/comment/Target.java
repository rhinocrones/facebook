package com.smarty.resource.facebook.service.dto.comment;

import java.io.Serializable;

public class Target implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -7322813200987169811L;

    private String id;
    
    private String url;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
