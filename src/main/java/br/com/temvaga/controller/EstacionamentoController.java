package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;

import br.com.temvaga.model.Telefone;
import br.com.temvaga.repository.EstacionamentoRepository;
import br.com.temvaga.service.EstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController  {

    @Autowired
    EstacionamentoService estacionamentoService;


    @RequestMapping("/list")
    public List<Estacionamento> findAll() {
        return estacionamentoService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void AddTelefone(@RequestBody Estacionamento estacionamento){
    estacionamentoService.save(estacionamento);
}
}



