package br.com.senac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.servico.exception.CategoriaService;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listaCategorias")
	public ModelAndView listaCategorias() {
		ModelAndView mv=new ModelAndView("/paginaCategorias");
		mv.addObject("categorias", categoriaService.listaCategoria());
		return mv;
	}
	
}
