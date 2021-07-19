package br.com.temvaga.controller;

import br.com.temvaga.model.Telefone;
import br.com.temvaga.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {
    @Autowired
    TelefoneRepository repo;

    @RequestMapping("/list")
    public ArrayList<Telefone> findAll(){
        return  (ArrayList<Telefone>) repo.findAll();
    }


    //public ArrayList<Product> listAllProducts(){ return (ArrayList<Product>) repoProd.findAll(); }
}
