package br.com.temvaga.controller;

import br.com.temvaga.model.Vaga;
import br.com.temvaga.repository.VagaRepository;
import br.com.temvaga.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;


@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    VagaRepository vagaRepository;

    @Autowired
    VagaService vagaService;

    @RequestMapping("/list")
    public ArrayList<Vaga> listAll(){
        return vagaRepository.findAll();
    }

    @RequestMapping(value="/listvaga", method = RequestMethod.GET)
    public ArrayList<Vaga> listaVagas(@RequestParam Integer id ){
        return vagaService.listavagas(id);
    }
}
