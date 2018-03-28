package com.smarty.resource.facebook.service.dto.post;

import com.restfb.types.Post;

import java.io.Serializable;
import java.util.List;

public class FacebookPostsDTO implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -6041066780854208387L;

    private List<Post> posts;

    public FacebookPostsDTO(List<Post> posts) {
	this.posts = posts;
    }

    public List<Post> getPosts()
    {
	return posts;
    }

    public void setPosts(List<Post> posts)
    {
	this.posts = posts;
    }
}
