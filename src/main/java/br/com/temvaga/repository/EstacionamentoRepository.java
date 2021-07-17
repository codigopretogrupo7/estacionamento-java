package br.com.temvaga.repository;

import br.com.temvaga.model.Estacionamento;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EstacionamentoRepository extends CrudRepository<Estacionamento, Long> {

    ArrayList<Estacionamento> findAll();
}
