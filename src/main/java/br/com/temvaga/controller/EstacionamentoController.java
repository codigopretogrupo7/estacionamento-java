package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;

import br.com.temvaga.service.EstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;


@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @GetMapping("/list")
    public ResponseEntity<ArrayList<Estacionamento>> listTodosEstacionamentos() {
        return estacionamentoService.ListaTodosEstacionamentos();
    }

    @GetMapping(value = "/list/id")
    public ResponseEntity<Estacionamento> listEstacionamentoPorId(@RequestParam(name = "id") Integer id) {
        return estacionamentoService.ListaEstacionamentoPorId(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Estacionamento> addEstacionamento(@RequestBody Estacionamento estacionamento) {
        return estacionamentoService.AdicionaEstacionamento(estacionamento);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Estacionamento> updateEstacionamento(
            @RequestParam(name = "id") Integer id, @RequestBody Estacionamento estacionamento){
        return estacionamentoService.AtualizarEstacionamento(id,estacionamento);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Estacionamento> deleteEstacionamento(@RequestParam(name = "id") Integer id) {
        return estacionamentoService.DeletarEstacionamento(id);
    }
}



