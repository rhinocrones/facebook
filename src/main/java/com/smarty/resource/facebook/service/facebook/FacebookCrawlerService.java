package com.smarty.resource.facebook.service.facebook;

import com.restfb.types.Post;
import com.smarty.resource.facebook.service.dto.request.PostsRequestDTO;
import com.smarty.resource.facebook.service.dto.request.ReactionsRequestDTO;
import com.smarty.resource.facebook.service.dto.response.impl.Response;

import java.util.List;

public interface FacebookCrawlerService
{
    List<Post> getPosts(PostsRequestDTO postsRequestDTO);

    Response getReactions(ReactionsRequestDTO reactionsRequestDTO);

}