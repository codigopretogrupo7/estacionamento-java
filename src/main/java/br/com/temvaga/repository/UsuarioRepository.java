package br.com.temvaga.repository;

import br.com.temvaga.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    ArrayList<Usuario> findAll();

}
