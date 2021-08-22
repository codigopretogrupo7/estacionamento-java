package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;

import br.com.temvaga.service.EstacionamentoService;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonKey;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;


@RestController
@RequestMapping("/api/estacionamentos")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @ApiOperation(
            value = "Listar todos os estacionamentos cadastrados",
            notes = "Esta operação retorna a lista com todos estacionamentos cadastrados"
    )
    @GetMapping(value = "/list")
    public ResponseEntity<ArrayList<Estacionamento>> listTodosEstacionamentos() {
        return estacionamentoService.ListaTodosEstacionamentos();
    }

    @ApiOperation(value = "Listar um estacionamento cadastrado pelo seu id")
    @GetMapping(value = "/list/id")
    public ResponseEntity<Estacionamento> listEstacionamentoPorId(@RequestParam(name = "id") Integer id) {
        return estacionamentoService.ListaEstacionamentoPorId(id);
    }

    @ApiOperation(
            value = "Cadastra um novo estacionamento",
            notes="Cadastra um novo estacionamento e tambem ja faz o insert de todas as vagas informadadas no numero de vagas")
    @PostMapping(value = "/add")
    public ResponseEntity<Estacionamento> addEstacionamento(@RequestBody Estacionamento estacionamento ) throws IOException {
        return estacionamentoService.AdicionaEstacionamento(estacionamento);
    }

    @ApiOperation(
            value = "Atualizar um estacionamento",
            notes = "Esta operação atualiza um estacionamento informando seu id"
    )
    @PutMapping(value = "/update")
    public ResponseEntity<Estacionamento> updateEstacionamento(
            @RequestParam(name = "id") Integer id, @RequestBody Estacionamento estacionamento){
        return estacionamentoService.AtualizarEstacionamento(id,estacionamento);
    }

    @ApiOperation(
            value = "Deletar um estacionamento por id",
            notes= "Deleta o estacionamento bem como as vagas relacionadas ao mesmo"
    )
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Estacionamento> deleteEstacionamento(@RequestParam(name = "id") Integer id) {
        return estacionamentoService.DeletarEstacionamento(id);
    }

    @ApiOperation(value = "Login de estacionamento")
    @PostMapping(value = "/login")
    public ResponseEntity<Estacionamento> loginEstacionamento(@RequestBody Estacionamento estacionamento ){
        return estacionamentoService.BuscarPorEmail(estacionamento.getEmailEstacionamento(), estacionamento.getSenhaEstacionamento());
    }


}



