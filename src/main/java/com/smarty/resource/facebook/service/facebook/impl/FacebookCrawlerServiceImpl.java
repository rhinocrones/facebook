package com.smarty.resource.facebook.service.facebook.impl;

import com.restfb.*;
import com.restfb.types.Post;
import com.smarty.resource.facebook.properties.FacebookProperties;
import com.smarty.resource.facebook.service.dto.comment.FacebookCommentsDTO;
import com.smarty.resource.facebook.service.dto.like.FacebookLikesDTO;
import com.smarty.resource.facebook.service.dto.request.PostsRequestDTO;
import com.smarty.resource.facebook.service.dto.request.ReactionsRequestDTO;
import com.smarty.resource.facebook.service.dto.response.impl.Response;
import com.smarty.resource.facebook.service.facebook.FacebookCrawlerService;
import com.smarty.resource.facebook.service.rest.RESTService;
import com.smarty.resource.facebook.utils.constants.FacebookConstants;
import com.smarty.resource.facebook.utils.converter.FacebookCrawlerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FacebookCrawlerServiceImpl implements FacebookCrawlerService
{
    @Autowired
    private FacebookCrawlerConverter facebookCrawlerConverter;

    @Autowired
    private FacebookProperties facebookProperties;

    @Autowired
    private RESTService restService;

    @Override
    public List<Post> getPosts(PostsRequestDTO postsRequestDTO)
    {
	Connection<Post> posts;
	if (postsRequestDTO.getEarliestPostingDate() != -1)
	{
	    posts = getClient(postsRequestDTO.getAppId(), postsRequestDTO.getAppSecret())
			    .fetchConnection(postsRequestDTO.getPageId() + FacebookConstants.FEED, Post.class,
					    Parameter.with(FacebookConstants.SINCE, new Date(postsRequestDTO.getEarliestPostingDate())),
					    Parameter.with(FacebookConstants.FIELDS, getPostFields(postsRequestDTO.isDetailed())),
					    Parameter.with(FacebookConstants.LOCALE, FacebookConstants.EN_US),
					    Parameter.with(FacebookConstants.LIMIT, postsRequestDTO.getReturnLimit()));
	} else
	{
	    posts = getClient(postsRequestDTO.getAppId(), postsRequestDTO.getAppSecret())
			    .fetchConnection(postsRequestDTO.getPageId() + FacebookConstants.FEED, Post.class,
					    Parameter.with(FacebookConstants.FIELDS, getPostFields(postsRequestDTO.isDetailed())),
					    Parameter.with(FacebookConstants.LOCALE, FacebookConstants.EN_US),
					    Parameter.with(FacebookConstants.LIMIT, postsRequestDTO.getReturnLimit()));
	}
	return facebookCrawlerConverter.getPosts(posts);
    }

    @Override
    public Response getReactions(ReactionsRequestDTO reactionsRequestDTO)
    {
	long startTime = System.currentTimeMillis();
	String url = generateURL(reactionsRequestDTO);
	Response dto;
	if (reactionsRequestDTO.getReactionType().equalsIgnoreCase(FacebookConstants.LIKES))
	{
	    dto = facebookCrawlerConverter.getReactions(restService.getForObject(url, FacebookLikesDTO.class));
	} else
	{
	    dto = facebookCrawlerConverter.getReactions(restService.getForObject(url, FacebookCommentsDTO.class));
	}
	long endTime = System.currentTimeMillis();
	dto.setTook(endTime - startTime);
	return dto;
    }

    private FacebookClient getClient(String appId, String appSecret)
    {
	FacebookClient facebookClient = new DefaultFacebookClient(Version.VERSION_2_11);
	FacebookClient.AccessToken accessToken = facebookClient.obtainAppAccessToken(appId, appSecret);
	facebookClient = new DefaultFacebookClient(accessToken.getAccessToken(), Version.VERSION_2_11);
	return facebookClient;
    }

    private String getPostFields(boolean detailed)
    {
	List<String> fields = new ArrayList<>(facebookProperties.getPostFieldsParameters());
	if (detailed)
	{
	    fields.addAll(facebookProperties.getPostDetailedStats());
	} else
	{
	    fields.addAll(facebookProperties.getPostCountOnlyStats());
	}
	return getPostFieldsString(fields);
    }

    private String getPostFieldsString(List<String> fields)
    {
	return fields.toString().replace(FacebookConstants.SQUARE_BRACES_LEFT, FacebookConstants.EMPTY)
			.replace(FacebookConstants.SQUARE_BRACES_RIGHT, FacebookConstants.EMPTY)
			.replace(FacebookConstants.POINTER_SPACE, FacebookConstants.POINTER);
    }

    private String generateURL(ReactionsRequestDTO reactionsRequestDTO)
    {
	String url;
	if (reactionsRequestDTO.getNextPageURL() != null)
	{
	    url = reactionsRequestDTO.getNextPageURL();
	} else
	{
	    url = FacebookConstants.GRAPH_FB_URL + reactionsRequestDTO.getPostId() + FacebookConstants.SLASH + reactionsRequestDTO.getReactionType()
			    + FacebookConstants.FB_LIMIT + reactionsRequestDTO.getReturnLimit();
	    if (reactionsRequestDTO.getReactionType().equalsIgnoreCase(FacebookConstants.COMMENTS))
	    {
		if (!reactionsRequestDTO.isTopLevelOnly())
		{
		    url += FacebookConstants.FILTER_STREAM;
		}
		url += FacebookConstants.PARAMETERS;
	    }
	    url += FacebookConstants.ACCES_TOKEN + reactionsRequestDTO.getAppId() + FacebookConstants.COLUMN + reactionsRequestDTO.getAppSecret();
	}
	return url;
    }
}