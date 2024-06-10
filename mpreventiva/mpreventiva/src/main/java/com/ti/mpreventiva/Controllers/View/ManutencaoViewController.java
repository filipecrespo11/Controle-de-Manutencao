package com.ti.mpreventiva.Controllers.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ti.mpreventiva.Services.ComputadorService;
import com.ti.mpreventiva.Services.ManutencaoService;
import com.ti.mpreventiva.Services.TecnicoService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/mp")
public class ManutencaoViewController {

	@Autowired
	private ManutencaoService manutencaoService;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ComputadorService computadorService;

	@GetMapping("/listas")
	public String getAllPreventivas(Model model) {
		model.addAttribute("manutencaos", manutencaoService.listarManutencoesFront());
		return "listagemmanutencao"; // Retorna o caminho correto do arquivo HTML
	}
}
