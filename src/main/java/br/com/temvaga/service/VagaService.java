package br.com.temvaga.service;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Vaga;
import br.com.temvaga.repository.EstacionamentoRepository;
import br.com.temvaga.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VagaService {

    @Autowired
    EstacionamentoRepository estacionamentoRepository;
    @Autowired
    VagaRepository vagaRepository;

    public ArrayList<Vaga> listavagas(@RequestParam int numeroEstacionamento ) {

        Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(numeroEstacionamento);
        Estacionamento estacionamentoCriado = estacionamento.get();

        ArrayList<Vaga> vagas = vagaRepository.findAllByEstacionamento(estacionamentoCriado);

        return vagas ;
    }

}
