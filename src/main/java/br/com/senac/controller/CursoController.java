package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.service.CategoriaService;
import br.com.senac.service.CursoService;

@Controller
public class CursoController {

	@Autowired
	private CursoService cursoService;	
	
	@Autowired
	private CategoriaService categoriaService;	
	
	@GetMapping("/listarCurso")
	public ModelAndView listaCursos() {
		ModelAndView mv = new ModelAndView("curso/paginaCursos");
		mv.addObject("cursos", cursoService.listaCursos());
		return mv;
		
	}
}
