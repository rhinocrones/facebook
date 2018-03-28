package com.smarty.resource.facebook.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class BeansConfiguration
{

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder)
    {
	return restTemplateBuilder.build();
    }

    @Bean
    public Docket productApi()
    {
	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.smarty.resource.facebook.controller"))
			.paths(regex("/fb.*")).build().useDefaultResponseMessages(false).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo()
    {
	return new ApiInfo("Smarty Facebook REST API", "Smarty REST API for facebook posts and post engagements crawling.", "0.0.1",
			"https://niuz.co/contact", new Contact("NIUZ", "https://niuz.co", "info@niuz.co"), "Terms and Conditions and Privacy Policy",
			"https://niuz.co/contact", Collections.emptyList());
    }
}