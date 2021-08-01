package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;

import br.com.temvaga.model.Vaga;
import br.com.temvaga.repository.EstacionamentoRepository;
import br.com.temvaga.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {

    @Autowired
    EstacionamentoRepository estacionamentoRepository;
    @Autowired
    VagaRepository vagaRepository;


    @RequestMapping("/list")
    public ArrayList<Estacionamento> findAll() {
        return (ArrayList<Estacionamento>) estacionamentoRepository.findAll();
    }

    @RequestMapping(value = "/list/id", method = RequestMethod.GET)
    public Estacionamento listById(@RequestParam Integer id) {
        Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(id);
        return estacionamento.get();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void AddEstacionamento(@RequestBody Estacionamento estacionamento) {

        estacionamentoRepository.save(estacionamento);

        int numeroDeVagas = estacionamento.getNumVagas();
        int idEstacionamento = estacionamento.getId();

        Optional<Estacionamento> estacionamentoProcurado = estacionamentoRepository.findById(idEstacionamento);
        Estacionamento estacionamentoCriado = estacionamentoProcurado.get();

        for (int i = 1; i <= numeroDeVagas; i++) {
            Vaga vaga = new Vaga();
            vaga.setEstacionamento(estacionamentoCriado);
            vaga.setNumeroVaga(Integer.toString(i));
            vagaRepository.save(vaga);
        }
        ;
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Estacionamento> deleteEstacionamento(@RequestParam(name = "id") Integer id) {

        Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(id);
        Estacionamento estacionamentoCriado = estacionamento.get();
        ArrayList<Vaga> vaga = vagaRepository.findAllByEstacionamento(estacionamentoCriado);

        if (estacionamento.isPresent()) {
            for( int i = 0 ; i < vaga.toArray().length ; i++ ){
                if(vaga.toArray().length > 0){
                    vagaRepository.delete(vaga.get(i));
                }
            }
            estacionamentoRepository.delete(estacionamentoCriado);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



