package com.smarty.resource.facebook.service.dto.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -7476660765938114029L;

    private String title;

    private String description;

    private String type;

    private String url;
    
    private Media media;
    
    private Target target;

    public String getTitle()
    {
	return title;
    }

    public void setTitle(String title)
    {
	this.title = title;
    }

    public String getDescription()
    {
	return description;
    }

    public void setDescription(String description)
    {
	this.description = description;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public String getUrl()
    {
	return url;
    }

    public void setUrl(String url)
    {
	this.url = url;
    }

    public Media getMedia()
    {
        return media;
    }

    public void setMedia(Media media)
    {
        this.media = media;
    }

    public Target getTarget()
    {
        return target;
    }

    public void setTarget(Target target)
    {
        this.target = target;
    }
}
