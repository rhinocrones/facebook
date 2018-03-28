package com.smarty.resource.facebook.service.dto.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment extends ParentComment implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -6623698623659477166L;

    private int comment_count;

    private int like_count;
    
    private Attachment attachment;

    private ParentComment parent;

    public int getComment_count()
    {
        return comment_count;
    }

    public void setComment_count(int comment_count)
    {
        this.comment_count = comment_count;
    }

    public int getLike_count()
    {
        return like_count;
    }

    public void setLike_count(int like_count)
    {
        this.like_count = like_count;
    }

    public Attachment getAttachment()
    {
        return attachment;
    }

    public void setAttachment(Attachment attachment)
    {
        this.attachment = attachment;
    }

    public ParentComment getParent()
    {
        return parent;
    }

    public void setParent(ParentComment parent)
    {
        this.parent = parent;
    }
}
