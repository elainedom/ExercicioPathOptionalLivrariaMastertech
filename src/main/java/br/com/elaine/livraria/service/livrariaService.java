package br.com.elaine.livraria.service;

import br.com.elaine.livraria.model.livrariaModel;
import br.com.elaine.livraria.repository.livrariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class livrariaService {
    @Autowired
    private livrariaRepository repository;

    public livrariaModel cadastrarLivro(livrariaModel livro){
        return repository.save(livro);
    }

    public Iterable<livrariaModel> listarLivro() {
        Iterable<livrariaModel> livraria = repository.findAll();
        return livraria;
    }


    public Iterable<livrariaModel> listarLivros(){
        return repository.findAll();
    }

    public livrariaModel listarLivro(int id){
        Optional<livrariaModel> livro = repository.findById(id);
        return livro.get();
    }
}
