package br.com.elaine.livraria.repository;

import br.com.elaine.livraria.model.livrariaModel;
import org.springframework.data.repository.CrudRepository;

public interface livrariaRepository extends CrudRepository<livrariaModel, Integer> {

}
