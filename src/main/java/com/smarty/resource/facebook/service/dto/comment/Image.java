package com.smarty.resource.facebook.service.dto.comment;

import java.io.Serializable;

public class Image implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 5976821343840056024L;

    private long height;
    
    private String src;
    
    private long width;

    public long getHeight()
    {
        return height;
    }

    public void setHeight(long height)
    {
        this.height = height;
    }

    public String getSrc()
    {
        return src;
    }

    public void setSrc(String src)
    {
        this.src = src;
    }

    public long getWidth()
    {
        return width;
    }

    public void setWidth(long width)
    {
        this.width = width;
    }
}
