package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;

import br.com.temvaga.service.EstacionamentoService;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonKey;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;


@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @GetMapping(value = "/list")
    public ResponseEntity<ArrayList<Estacionamento>> listTodosEstacionamentos() {
        return estacionamentoService.ListaTodosEstacionamentos();
    }

    @GetMapping(value = "/list/id")
    public ResponseEntity<Estacionamento> listEstacionamentoPorId(@RequestParam(name = "id") Integer id) {
        return estacionamentoService.ListaEstacionamentoPorId(id);
    }
//,
//                                                            @RequestParam("File") MultipartFile arquivo) throws IOException
    @PostMapping(value = "/add")
    public ResponseEntity<Estacionamento> addEstacionamento(@RequestBody Estacionamento estacionamento ) throws IOException {
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



