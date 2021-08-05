package br.com.temvaga.repository;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface VagaRepository extends JpaRepository<Vaga, Integer> {
    ArrayList<Vaga> findAll();

    ArrayList<Vaga> findAllByEstacionamento(Estacionamento fk_estacionamento);

    Optional<Vaga> findById(Integer id);
}
