package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;

import br.com.temvaga.model.Usuario;
import br.com.temvaga.model.Vaga;
import br.com.temvaga.repository.EstacionamentoRepository;
import br.com.temvaga.repository.UsuarioRepository;
import br.com.temvaga.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController  {

    @Autowired
    EstacionamentoRepository repo;
    @Autowired
    VagaRepository vagaRepository;


    @RequestMapping("/list")
    public ArrayList<Estacionamento> findAll() {
        return (ArrayList<Estacionamento>) repo.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void AddEstacionamento(@RequestBody Estacionamento estacionamento){

         repo.save(estacionamento);

         int numeroDeVagas = estacionamento.getNumVagas();
         int idEstacionamento = estacionamento.getId();

         Optional<Estacionamento> estacionamentoProcurado = repo.findById(idEstacionamento);
         Estacionamento estacionamentoCriado = estacionamentoProcurado.get();

         for ( int i = 1 ; i <= numeroDeVagas ; i++ ){
             Vaga vaga = new Vaga();
             vaga.setEstacionamento(estacionamentoCriado);
             vaga.setNumeroVaga(Integer.toString(i));
             vagaRepository.save(vaga);
         };
    }

//    @DeleteMapping(path = "/{id}")
//    public ResponseEntity<Void> del(@PathVariable Integer id){
//        Optional<Estacionamento> estacinamentoDelete = repo.findById(id);
//    return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @DeleteMapping (value = "/delete")
    public ResponseEntity<Estacionamento> deleteEstacionamento(@RequestParam(name = "id") Integer id){
        Optional<Estacionamento> estacionamento = repo.findById(id);
        Optional<Vaga> vaga = vagaRepository.findAllByEstacionamento(id);

        if(estacionamento.isPresent()){
            repo.delete(estacionamento.get());
            vagaRepository.delete(vaga.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "/list/id", method = RequestMethod.GET)
    public Estacionamento listById(@RequestParam Integer id){
        Optional<Estacionamento> estacionamento = repo.findById(id);
        return estacionamento.get(); }





}



