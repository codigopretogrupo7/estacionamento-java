package br.com.temvaga.repository;

import br.com.temvaga.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    ArrayList<Usuario> findAll();

}
