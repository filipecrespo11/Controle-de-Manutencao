package com.ti.mpreventiva.Controllers.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autentication")
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}