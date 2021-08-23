package br.com.temvaga.controller;

import br.com.temvaga.model.Vaga;
import br.com.temvaga.model.Veiculo;
import br.com.temvaga.service.VagaService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/vagas")
public class VagaController {

    @Autowired
    VagaService vagaService;

    @ApiOperation(value = "Listar Todas as vagas de todos os estacionamentos")
    @GetMapping("/list")
    public ResponseEntity<ArrayList<Vaga>> listAll(){
        return vagaService.todasAsVagas();
    }

    @ApiOperation(value="Lista uma vaga por id")
    @GetMapping("/listid")
    public ResponseEntity<Vaga> listaVaga(@RequestParam(name="id") Integer id){
        return vagaService.vagaPorId(id);
    }

    @ApiOperation(value = "Listar vagas de um estacionamento especifico pelo seu id")
    @GetMapping(value="/listvaga")
    public ResponseEntity<ArrayList<Vaga>> listaVagas(@RequestParam(name="id") Integer id ) {
        return vagaService.listaVagas(id);
    }

    @ApiOperation(
            value = "Insere um novo veiculo na vaga",
            notes = "Insere um novo veiculo e atende duas requisiçoes, uma para Ocupado e outra para Reservada"
    )
    @PostMapping(value="/insertveiculo")
    public ResponseEntity<Vaga> insereVagas(@RequestBody Veiculo veiculo,
                                            @RequestParam(name="id") Integer id){
        return vagaService.InsereCarroNaVaga( id,veiculo );
    }

    @PostMapping(value="/reservavaga")
    public ResponseEntity<Vaga> reservaVagas(@RequestBody Veiculo veiculo,
                                            @RequestParam(name="id") Integer id){
        return vagaService.ReservarVaga( id,veiculo );
    }

    @GetMapping(value="/vagaslivres")
    public ResponseEntity<Integer> vagaslivres(@RequestParam(name="id") Integer id) {
        return vagaService.vagaslivres(id);
    }


        @ApiOperation(value = "Retira o veiculo da vaga")
    @PostMapping(value="/checkout")
    public ResponseEntity<Vaga> checkout(@RequestParam(name="id") Integer id){
        return vagaService.Checkout(id);
    }
}
