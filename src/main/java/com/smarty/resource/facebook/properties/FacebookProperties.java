package com.smarty.resource.facebook.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties
public class FacebookProperties
{

    private List<String> postFieldsParameters;

    private List<String> postDetailedStats;

    private List<String> postCountOnlyStats;

    public List<String> getPostFieldsParameters()
    {
	return postFieldsParameters;
    }

    public void setPostFieldsParameters(List<String> postFieldsParameters)
    {
	this.postFieldsParameters = postFieldsParameters;
    }

    public List<String> getPostDetailedStats()
    {
	return postDetailedStats;
    }

    public void setPostDetailedStats(List<String> postDetailedStats)
    {
	this.postDetailedStats = postDetailedStats;
    }

    public List<String> getPostCountOnlyStats()
    {
	return postCountOnlyStats;
    }

    public void setPostCountOnlyStats(List<String> postCountOnlyStats)
    {
	this.postCountOnlyStats = postCountOnlyStats;
    }
}