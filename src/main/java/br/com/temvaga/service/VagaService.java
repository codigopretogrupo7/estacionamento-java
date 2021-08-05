package br.com.temvaga.service;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Vaga;
import br.com.temvaga.model.Veiculo;
import br.com.temvaga.repository.EstacionamentoRepository;
import br.com.temvaga.repository.VagaRepository;
import br.com.temvaga.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

import br.com.temvaga.enuns.Status;

@Service
public class VagaService {

    Calendar calendario = Calendar.getInstance();

    @Autowired
    EstacionamentoRepository estacionamentoRepository;
    @Autowired
    VagaRepository vagaRepository;
    @Autowired
    VeiculoRepository veiculoRepository;

    public ResponseEntity<ArrayList<Vaga>> todasAsVagas(){
        ArrayList<Vaga> vagas = (ArrayList<Vaga>) vagaRepository.findAll();
        if( vagas.isEmpty() ){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<ArrayList<Vaga>>(vagas, HttpStatus.OK);
        }
    }

    public ResponseEntity<ArrayList<Vaga>> listaVagas(Integer numeroEstacionamento ) {
        Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(numeroEstacionamento);

        if( estacionamento.isPresent() ){
            ArrayList<Vaga> vagas = vagaRepository.findAllByEstacionamento(estacionamento.get());
            return new ResponseEntity<ArrayList<Vaga>>(vagas,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Vaga> InsereCarroNaVaga(Integer id, Veiculo carro,String situacao){
        Optional<Veiculo> veiculo = veiculoRepository.findById(carro.getId());
        Optional<Vaga> vaga = vagaRepository.findById(id);

        if( veiculo.isPresent() ){
            Vaga vagaCriada = vaga.get();
            vagaCriada.setVeiculo(veiculo.get());
            vagaCriada.setDtEntrada(calendario.getTime());
            vagaCriada.setSituacao(situacao);

            vagaRepository.save(vagaCriada);
            return new ResponseEntity<Vaga>(vagaCriada,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Vaga> Checkout(Integer id){
        Optional<Vaga> vaga = vagaRepository.findById(id);

        if( vaga.isPresent() ){
            Vaga vagaCriada = vaga.get();
            vagaCriada.setVeiculo(null);
            vagaCriada.setDtEntrada(null);
            vagaCriada.setSituacao("vazia");

            vagaRepository.save(vagaCriada);
            return new ResponseEntity<Vaga>(vagaCriada,HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
