package com.smarty.resource.facebook.service.rest;

import org.springframework.http.ResponseEntity;

public interface RESTService
{
    <T> T getForObject(String url, Class<T> responseType);
}