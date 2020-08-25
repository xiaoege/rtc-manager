package com.rtc.manager.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Chen Hang
 * @create 2020-08-24
 */
public class MyToken extends UsernamePasswordAuthenticationToken {


    public MyToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public MyToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
