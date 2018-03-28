package com.smarty.resource.facebook.service.dto.request;

import com.smarty.resource.facebook.validator.Validate;

import java.io.Serializable;

@Validate
public class ReactionsRequestDTO implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -7531582582523330238L;

    private String postId;
    private int returnLimit;
    private String appId;
    private String appSecret;
    private String nextPageURL;
    private String reactionType;
    private boolean topLevelOnly;

    public String getPostId()
    {
        return postId;
    }

    public void setPostId(String postId)
    {
        this.postId = postId;
    }

    public int getReturnLimit()
    {
        return returnLimit;
    }

    public void setReturnLimit(int returnLimit)
    {
        this.returnLimit = returnLimit;
    }

    public String getAppId()
    {
        return appId;
    }

    public void setAppId(String appId)
    {
        this.appId = appId;
    }

    public String getAppSecret()
    {
        return appSecret;
    }

    public void setAppSecret(String appSecret)
    {
        this.appSecret = appSecret;
    }

    public String getNextPageURL()
    {
        return nextPageURL;
    }

    public void setNextPageURL(String nextPageURL)
    {
        this.nextPageURL = nextPageURL;
    }

    public String getReactionType()
    {
        return reactionType;
    }

    public void setReactionType(String reactionType)
    {
        this.reactionType = reactionType;
    }

    public boolean isTopLevelOnly()
    {
        return topLevelOnly;
    }

    public void setTopLevelOnly(boolean topLevelOnly)
    {
        this.topLevelOnly = topLevelOnly;
    }
}
