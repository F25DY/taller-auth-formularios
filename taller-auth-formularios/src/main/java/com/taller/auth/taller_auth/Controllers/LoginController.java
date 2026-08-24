package com.taller.auth.taller_auth.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class LoginController {

    @GetMapping("/login")
    public String login () {

        return "login";

    }
    
    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
    
}
