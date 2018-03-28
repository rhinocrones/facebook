package com.smarty.resource.facebook.utils.converter;

import com.restfb.Connection;
import com.restfb.types.Post;
import com.smarty.resource.facebook.service.dto.engagment.ReactionDTO;
import com.smarty.resource.facebook.service.dto.response.impl.Response;

import java.util.List;

public interface FacebookCrawlerConverter
{

    List<Post> getPosts(Connection<Post> posts);

    Response getReactions(ReactionDTO reactionDTO);
}