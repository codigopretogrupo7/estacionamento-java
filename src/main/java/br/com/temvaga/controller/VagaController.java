package br.com.temvaga.controller;

import br.com.temvaga.model.Vaga;
import br.com.temvaga.model.Veiculo;
import br.com.temvaga.service.VagaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    VagaService vagaService;

    @GetMapping("/list")
    public ResponseEntity<ArrayList<Vaga>> listAll(){
        return vagaService.todasAsVagas();
    }

    @GetMapping(value="/listvaga")
    public ResponseEntity<ArrayList<Vaga>> listaVagas(@RequestParam(name="id") Integer id ) {
        return vagaService.listaVagas(id);
    }

    @PostMapping(value="/insertveiculo")
    public ResponseEntity<Vaga> insereVagas(@RequestBody Veiculo veiculo,
                                            @RequestParam(name="id") Integer id,
                                            @RequestParam(name="situacao") String situacao){
        return vagaService.InsereCarroNaVaga( id,veiculo, situacao );
    }

    @PostMapping(value="/checkout")
    public ResponseEntity<Vaga> checkout(@RequestParam(name="id") Integer id){
        return vagaService.Checkout(id);
    }




}
