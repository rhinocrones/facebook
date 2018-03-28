package com.smarty.resource.facebook.service.dto.like;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restfb.types.webhook.base.From;
import com.smarty.resource.facebook.service.dto.common.CommonReactionDTO;
import com.smarty.resource.facebook.service.dto.engagment.ReactionDTO;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacebookLikesDTO extends CommonReactionDTO implements Serializable, ReactionDTO
{

    /**
     * 
     */
    private static final long serialVersionUID = -857833451254923656L;

    private List<From> data;

    public void setData(List<From> data)
    {
	this.data = data;
    }

    @Override
    public String getNextPage()
    {
	return getPaging().getNext();
    }

    @Override
    public Object getReactions()
    {
	return data;
    }
}
