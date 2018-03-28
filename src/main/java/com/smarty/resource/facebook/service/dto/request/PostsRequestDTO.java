package com.smarty.resource.facebook.service.dto.request;

import com.smarty.resource.facebook.utils.constants.FacebookConstants;
import com.smarty.resource.facebook.validator.Validate;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@Validate
public class PostsRequestDTO implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 755453328497267762L;

    @ApiModelProperty(notes = FacebookConstants.API_POST_MODEL_PAGE_ID, required = true)
    private String pageId;

    @ApiModelProperty(notes = FacebookConstants.API_POST_MODEL_DATE, required = true)
    private long earliestPostingDate;

    @ApiModelProperty(notes = FacebookConstants.API_POST_MODEL_APP_ID, required = true)
    private String appId;

    @ApiModelProperty(notes = FacebookConstants.API_POST_MODEL_APP_SECRET, required = true)
    private String appSecret;

    @ApiModelProperty(notes = FacebookConstants.API_POST_MODEL_DETAILED)
    private boolean detailed;

    @ApiModelProperty(notes = FacebookConstants.API_POST_MODEL_RETURN, required = true)
    private int returnLimit;

    public String getPageId()
    {
	return pageId;
    }

    public void setPageId(String pageId)
    {
	this.pageId = pageId;
    }

    public long getEarliestPostingDate()
    {
	return earliestPostingDate;
    }

    public void setEarliestPostingDate(long earliestPostingDate)
    {
	this.earliestPostingDate = earliestPostingDate;
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

    public boolean isDetailed()
    {
	return detailed;
    }

    public void setDetailed(boolean detailed)
    {
	this.detailed = detailed;
    }

    public int getReturnLimit()
    {
	return returnLimit;
    }

    public void setReturnLimit(int returnLimit)
    {
	this.returnLimit = returnLimit;
    }
}
