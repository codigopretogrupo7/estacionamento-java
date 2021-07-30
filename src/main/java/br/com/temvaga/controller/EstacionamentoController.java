package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;

import br.com.temvaga.model.Telefone;
import br.com.temvaga.repository.EstacionamentoRepository;
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


    @RequestMapping("/list")
    public ArrayList<Estacionamento> findAll() {
        return (ArrayList<Estacionamento>) repo.findAll();
    }

    @RequestMapping(value = "/list/id", method = RequestMethod.GET)
    public Estacionamento listById(@RequestParam Integer id){
    Optional<Estacionamento> estacionamento = repo.findById(id);
    return estacionamento.get(); }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void Add(@RequestBody Estacionamento estacionamento){
        repo.save(estacionamento);
}

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> del(@PathVariable Integer id){
        Optional<Estacionamento> estacinamentoDelete = repo.findById(id);
    return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
}


}



