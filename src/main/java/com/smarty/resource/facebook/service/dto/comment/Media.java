package com.smarty.resource.facebook.service.dto.comment;

import java.io.Serializable;

public class Media implements Serializable 
{

    /**
     * 
     */
    private static final long serialVersionUID = -7561299979429081136L;

    private Image image;

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }
}
