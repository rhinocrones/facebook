package com.smarty.resource.facebook.utils.converter.impl;

import com.restfb.Connection;
import com.restfb.types.Post;
import com.smarty.resource.facebook.service.dto.engagment.ReactionDTO;
import com.smarty.resource.facebook.service.dto.response.factory.FactoryConstants;
import com.smarty.resource.facebook.service.dto.response.factory.ResponseDTOFactory;
import com.smarty.resource.facebook.service.dto.response.impl.Response;
import com.smarty.resource.facebook.utils.converter.FacebookCrawlerConverter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacebookCrawlerConverterImpl implements FacebookCrawlerConverter
{
    @Override
    public List<Post> getPosts(Connection<Post> posts)
    {
	return posts.getData();
    }

    @Override
    public Response getReactions(ReactionDTO reactionDTO)
    {
	return ResponseDTOFactory.getResponse(FactoryConstants.SOCIAL, reactionDTO);
    }
}