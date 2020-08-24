package com.rtc.manager.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author Chen Hang
 * @create 2020-08-24
 */
public class MyProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Object principal = authentication.getPrincipal();
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
