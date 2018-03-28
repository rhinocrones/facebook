package com.smarty.resource.facebook.service.rest.impl;

import com.smarty.resource.facebook.service.rest.RESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RESTServiceImpl implements RESTService
{
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public <T> T getForObject(String url, Class<T> responseType)
    {
	return restTemplate.getForObject(url, responseType);
    }
}