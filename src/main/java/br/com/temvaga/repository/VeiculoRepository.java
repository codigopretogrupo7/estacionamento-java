package br.com.temvaga.repository;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Usuario;
import br.com.temvaga.model.Veiculo;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {
    ArrayList<Veiculo> findAllByUsuario(Usuario fk_usuario);
}
