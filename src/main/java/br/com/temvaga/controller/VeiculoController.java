package br.com.temvaga.controller;

import br.com.temvaga.model.Veiculo;
import br.com.temvaga.repository.VeiculoRepository;
import br.com.temvaga.service.VeiculoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;


@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @ApiOperation(value = "Listar Todos os veiculos Cadastrados")
    @GetMapping("/list") public ResponseEntity<ArrayList<Veiculo>> findAll() {
        return veiculoService.listaTodosVeiculos();
    }

    @ApiOperation(value = "Listar informaçoes sobe veiculo cadastrado pelo seu id")
    @GetMapping("/list/id") public ResponseEntity<Veiculo> findAll(@RequestParam(name="id") Integer id) {
        return veiculoService.VeiculoPorId(id);
    }

    @ApiOperation(value = "Adicionar um novo veiculo")
    @PostMapping(value = "/add")
    public ResponseEntity<Veiculo> Add(@RequestBody Veiculo veiculo){
        return veiculoService.AdicionaVeiculo(veiculo);
    }

    @ApiOperation(value = "Atualizar um veiculo pelo seu id")
    @PutMapping(value="/update")
    public ResponseEntity<Veiculo> updateVeiculo(@RequestBody Veiculo veiculo,@RequestParam(name="id") Integer id){
        return veiculoService.AtualizarVeiculo( id, veiculo );
    }

    @ApiOperation(value = "Deletar um veiculo pelo seu id")
    @DeleteMapping(value="/delete")
    public ResponseEntity<Veiculo> del(@RequestParam(name="id") Integer id){
        return  veiculoService.DeletarVeiculo(id);
    }
}
