package com.userInfo.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThirdPartyService {
	private final RestTemplate restTemplate = new RestTemplate();

    public String callThirdPartyApi() {
        String thirdPartyApiUrl = "https://restcountries.com/v3.1/all";
        return restTemplate.getForObject(thirdPartyApiUrl, String.class);
    }
}
