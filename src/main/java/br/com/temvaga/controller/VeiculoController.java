package br.com.temvaga.controller;

import br.com.temvaga.model.Veiculo;
import br.com.temvaga.repository.VeiculoRepository;
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
    VeiculoRepository veiculoRepository;

    @RequestMapping("/list") public ArrayList<Veiculo> findAll() {
    return (ArrayList<Veiculo>) veiculoRepository.findAll();
}

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void Add(@RequestBody Veiculo veiculo){
    veiculoRepository.save(veiculo);
}

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> del(@PathVariable Integer id){
    Optional<Veiculo> delete = veiculoRepository.findById(id);
    return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
