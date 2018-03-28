package com.smarty.resource.facebook.service.dto.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smarty.resource.facebook.service.dto.common.CommonReactionDTO;
import com.smarty.resource.facebook.service.dto.engagment.ReactionDTO;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacebookCommentsDTO extends CommonReactionDTO implements Serializable, ReactionDTO
{

    /**
     * 
     */
    private static final long serialVersionUID = -4879418287663027340L;

    private List<Comment> data;

    public void setData(List<Comment> data)
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
