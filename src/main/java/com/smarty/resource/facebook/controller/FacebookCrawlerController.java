package com.smarty.resource.facebook.controller;

import com.restfb.types.Post;
import com.smarty.resource.facebook.service.dto.request.PostsRequestDTO;
import com.smarty.resource.facebook.service.facebook.FacebookCrawlerService;
import com.smarty.resource.facebook.utils.constants.FacebookConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@Api(value = FacebookConstants.API, description = FacebookConstants.API_DESCRIPTION)
public class FacebookCrawlerController
{

    @Autowired
    private FacebookCrawlerService facebookCrawlerService;

    @PostMapping(value = FacebookConstants.API_POST_MAPPING, produces = FacebookConstants.API_POST_PRODUCE)
    @ApiOperation(value = FacebookConstants.API_POST_OPERATION)

    @ApiResponses(value = { @ApiResponse(code = 200, message = FacebookConstants.API_OK),
		    @ApiResponse(code = 404, message = FacebookConstants.API_FORBIDEN),
		    @ApiResponse(code = 400, message = FacebookConstants.API_BAD_REQUEST),
		    @ApiResponse(code = 500, message = FacebookConstants.API_INTERNAL_SERVER_ERROR) })
    public List<Post> getPost(@Valid @RequestBody PostsRequestDTO postsRequestDTO)
    {
	return facebookCrawlerService.getPosts(postsRequestDTO);
    }

    //TODO need to be refactored to new changes
/*    @PostMapping("/fb/reactions")
    public Response getReactions(@Valid @RequestBody ReactionsRequestDTO reactionRequestDTO)
    {
	return facebookCrawlerService.getReactions(reactionRequestDTO);
    }*/
}