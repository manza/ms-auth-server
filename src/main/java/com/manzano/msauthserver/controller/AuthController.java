package com.manzano.msauthserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Rest Controller responsible for exposing method for client apps get information about User's token
 */
@RestController
@RequestMapping("/")
public class AuthController {

    public Principal getCurrentLoggedInUser(Principal user) {
        return user;
    }
}
