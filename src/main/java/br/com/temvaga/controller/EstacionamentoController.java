package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;

import br.com.temvaga.model.Telefone;
import br.com.temvaga.repository.EstacionamentoRepository;
import br.com.temvaga.service.EstacionamentoService;
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
    EstacionamentoService estacionamentoService;

    @Autowired
    EstacionamentoRepository repo;



    @RequestMapping("/list")
    public ArrayList<Estacionamento> findAll() {
        return (ArrayList<Estacionamento>) repo.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void AddTelefone(@RequestBody Estacionamento estacionamento){

        repo.save(estacionamento);
}

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> del(@PathVariable Integer id){
        Optional<Estacionamento> estacinamentoDelete = repo.findById(id);
    return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
}


}



