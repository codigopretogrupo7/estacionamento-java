package br.com.temvaga.repository;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Usuario;
import br.com.temvaga.model.Vaga;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public interface EstacionamentoRepository extends CrudRepository<Estacionamento, Integer> {

    List<Estacionamento> findAll();
    ArrayList<Estacionamento> findAllByUsuario(Usuario fk_id_usuario);
}
