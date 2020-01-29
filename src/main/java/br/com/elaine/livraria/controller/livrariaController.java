package br.com.elaine.livraria.controller;

import br.com.elaine.livraria.model.livrariaModel;
import br.com.elaine.livraria.service.livrariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class livrariaController {

    @Autowired // Está ligando automaticamente uam dependencia a outra.
    private livrariaService service;

    @GetMapping
    public String mostrarHome(){
        return "index";
    }

    @PostMapping("/cadastrar")
    public String cadastrarLivro(livrariaModel livro){
        service.cadastrarLivro(livro);
        return "index";
    }

    @GetMapping("/livros")
    public ModelAndView listarLivro() {
        ModelAndView pagina = new ModelAndView("listarLivros");
        Iterable<livrariaModel> livros = service.listarLivro();
        pagina.addObject("livros", livros);
        return pagina;
    }

    @GetMapping("/buscar")
    public String retornarLivro(){
        return "buscarPorId";
    }

    @GetMapping("livro")
    public String listaLivros(@RequestParam("id") int id, Model model) {
        livrariaModel livro = service.listarLivro(id);
        if (livro != null) {
            model.addAttribute("livro", livro);
        }
        return "listarLivro";
    }

    @GetMapping("livro/{id}")
    public String listaLivrosPorPagina(@PathVariable("id") int id, Model model) {
        livrariaModel livro = service.listarLivro(id);
        if (livro != null) {
            model.addAttribute("livro", livro);
        }
        return "listarLivro";
    }
}

