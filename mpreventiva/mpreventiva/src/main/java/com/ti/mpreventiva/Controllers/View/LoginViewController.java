package com.ti.mpreventiva.Controllers.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginViewController {
	
	@GetMapping("/logg")
	public String EfetuarLogin() {
		return "login"; // Retorna o caminho correto do arquivo HTML
	}

}
