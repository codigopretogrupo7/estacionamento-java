package br.com.temvaga.controller;

import br.com.temvaga.model.Usuario;
import br.com.temvaga.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository repo;

    @RequestMapping("/list")
    public ArrayList<Usuario> findAll(){
        return repo.findAll();
    }

}
