package com.example.auth.service;

import com.nimbusds.oauth2.sdk.TokenResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

//Todo: mightWant to not have this class handle this idk
@Service
public class OAuthClient {

    private final RestTemplate restTemplate;
    private final String endPoint = "http://localhost:8080/oauth/token";

    public OAuthClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TokenResponse validateToken(String token) throws Exception {
        MultiValueMap<String, String> params = setParams(token);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);

        ResponseEntity<TokenResponse> response = restTemplate.exchange(endPoint, HttpMethod.POST, requestEntity, TokenResponse.class);

        TokenResponse tokenResponse = response.getBody();
        if (tokenResponse.indicatesSuccess()) {
            return tokenResponse;
        } else {
            throw new Exception("Token is invalid: " + tokenResponse.toErrorResponse().getErrorObject().toString());
        }

    }

    //Todo: need to implement this
    public void revokeToken(String token) throws Exception {
        MultiValueMap<String, String> params = setParams(token);
    }

    private  MultiValueMap<String, String> setParams(String token) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("grant_type", "authorization_code");
        params.add("code", token);
        params.add("redirect_uri", "http://localhost:8080/oauth/redirect");
        params.add("client_id", "example");
        params.add("client_secret", "example");

        return params;
    }
}
