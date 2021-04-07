package com.rtc.manager.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

/**
 * @author ChenHang
 */
@ApiIgnore
@RestController
@RequestMapping("google")
public class GoogleController {
    static final String CLIENT_ID = "382352353489-7p9pish167nkn4tmft6k5i0pipooh28l.apps.googleusercontent.com";

    @GetMapping("googleUserInfo")
    public String test() {
        return "google";
    }

    public static void main(String[] args) {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                new NetHttpTransport(), new GsonFactory())
                .setAudience(Collections.singletonList(CLIENT_ID)).build();
        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify("asd");
            idToken.getPayload();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
