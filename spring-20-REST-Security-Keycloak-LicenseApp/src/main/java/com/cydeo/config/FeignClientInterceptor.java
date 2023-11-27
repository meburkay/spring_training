package com.cydeo.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
//We have two apps one is organization and the other is licence. When we create a licence there is no problem but when we retrieve a licence that created we have one problem. In the licence there are fields belongs to the organization. And to fill that fields we must go to a method at the organizations app. And when we do that we need a token to retrieve that information but we do not have one. To solve this issue we create this class. This class's main purpose is to take the token that used at the organizations side and transfer it to the licence part. By this way we can use the same token that we used at the organizations side with the licence part.
@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_TYPE = "Bearer ";

    @Override
    public void apply(RequestTemplate requestTemplate) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SimpleKeycloakAccount details = (SimpleKeycloakAccount) authentication.getDetails();
        requestTemplate.header(AUTHORIZATION_HEADER, TOKEN_TYPE + details.getKeycloakSecurityContext().getTokenString());

    }

}