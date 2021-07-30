package br.com.temvaga.repository;

import br.com.temvaga.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface VagaRepository extends JpaRepository<Vaga, Integer> {
    ArrayList<Vaga> findAll();

    Optional<Vaga> findAllByEstacionamento(Integer pk_id_estacionamento);

    Optional<Vaga> findById(Integer id);
}
