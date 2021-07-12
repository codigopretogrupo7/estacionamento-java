package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;

import br.com.temvaga.repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController  {

    @Autowired
    EstacionamentoRepository repo;


    @RequestMapping("listar")
    public ArrayList<Estacionamento> findAll() {
        return repo.findAll();
    }
}
