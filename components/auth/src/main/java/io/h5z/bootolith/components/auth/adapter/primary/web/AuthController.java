package io.h5z.bootolith.components.auth.adapter.primary.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    
    @GetMapping("/components/auth/login")
    public String login() {
        return "components/auth/login";
    }

}
