package com.smarty.resource.facebook.service.dto.response.impl;

import com.smarty.resource.facebook.service.dto.engagment.ReactionDTO;

import java.io.Serializable;

public class ReactionResponseDTO extends SuccesResponseDTO implements Serializable
{

    private String nextPage;
    /**
     * 
     */
    private static final long serialVersionUID = -1398239961134505294L;

    public ReactionResponseDTO(Integer statusCode, ReactionDTO reaction) {
	super(statusCode, reaction.getReactions());
	nextPage = reaction.getNextPage();
    }

    public String getNextPage()
    {
	return nextPage;
    }

    public void setNextPage(String nextPage)
    {
	this.nextPage = nextPage;
    }
}
