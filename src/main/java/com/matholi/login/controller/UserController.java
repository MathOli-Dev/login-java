package com.matholi.login.controller;

import com.matholi.login.dto.UserResponse;
import com.matholi.login.security.AuthenticatedUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    /** Rota protegida: só responde com um JWT válido. */
    @GetMapping("/api/me")
    public UserResponse me(@AuthenticationPrincipal AuthenticatedUser user) {
        return new UserResponse(user.id(), user.email());
    }
}
