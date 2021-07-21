package br.com.temvaga.repository;

import br.com.temvaga.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    ArrayList<Vaga> findAll();

}
