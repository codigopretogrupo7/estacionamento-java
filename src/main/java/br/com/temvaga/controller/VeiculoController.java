package br.com.temvaga.controller;

import br.com.temvaga.model.Veiculo;
import br.com.temvaga.repository.VeiculoRepository;
import br.com.temvaga.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @GetMapping("/list") public ResponseEntity<ArrayList<Veiculo>> findAll() {
        return veiculoService.listaTodosVeiculos();
    }

    @GetMapping("/list/id") public ResponseEntity<Veiculo> findAll(@RequestParam(name="id") Integer id) {
        return veiculoService.VeiculoPorId(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Veiculo> Add(@RequestBody Veiculo veiculo){
        return veiculoService.AdicionaVeiculo(veiculo);
    }




    @PutMapping(value="/update")
    public ResponseEntity<Veiculo> updateVeiculo(@RequestBody Veiculo veiculo,@RequestParam(name="id") Integer id){
        return veiculoService.AtualizarVeiculo( id, veiculo );
    }

    @DeleteMapping(value="/delete")
    public ResponseEntity<Veiculo> del(@RequestParam(name="id") Integer id){
        return  veiculoService.DeletarVeiculo(id);
    }
}
