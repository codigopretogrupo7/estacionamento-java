package br.com.temvaga.repository;

import br.com.temvaga.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    ArrayList<Usuario> findAll();
    Usuario findByNome(String nome);
    Optional<Usuario> findById(Integer id);
}
