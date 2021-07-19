package br.com.temvaga.repository;

import br.com.temvaga.model.Estacionamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EstacionamentoRepository extends CrudRepository<Estacionamento, Integer> {

    List<Estacionamento> findAll();
}
