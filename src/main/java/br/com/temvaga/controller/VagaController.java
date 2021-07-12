package br.com.temvaga.controller;

import br.com.temvaga.model.Vaga;
import br.com.temvaga.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;


@RestController
@RequestMapping("vagas")
public class VagaController {

    @Autowired
    VagaRepository vagaRepository;

    @RequestMapping("/list")
    public ArrayList<Vaga> listAll(){
        return vagaRepository.findAll();
    }
}
