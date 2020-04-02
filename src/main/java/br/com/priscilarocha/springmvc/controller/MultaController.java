package br.com.priscilarocha.springmvc.controller;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.priscilarocha.springmvc.model.Multas;


@Controller
@RequestMapping("/")
public class MultaController {
	
	private static final List<Multas> BD = new ArrayList<>(Arrays.asList(
			
			new Multas (1L, "Grave", new BigDecimal(249.99)),
			new Multas (2L, "Média",new BigDecimal(149.99)),
			new Multas (3L, "Leve", new BigDecimal(99.99))));
	
	@GetMapping
	public ModelAndView lista (Multas multa) {
		
		ModelAndView modelo = new ModelAndView("/multas.html");
		
		 List<Multas> lista = BD.stream()
	                .collect(Collectors.toList());//
	        
	        modelo.addObject("multas", lista);
		
		return modelo;
	}
}