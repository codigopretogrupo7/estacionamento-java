package br.com.temvaga.controller;

import br.com.temvaga.model.Telefone;
import br.com.temvaga.model.Usuario;
import br.com.temvaga.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository repo;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/usuario")
    public ResponseEntity<Usuario> UsuariobyId (@RequestParam(name = "id") Integer id){
        Optional<Usuario> usuario = repo.findById(id);
        if(usuario.isPresent()){
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @RequestMapping("/list")
    public ArrayList<Usuario> findAll(){
        return repo.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void AddUsuario(@RequestBody Usuario usuario){
        usuario.setSennha(bCryptPasswordEncoder.encode(usuario.getSennha()));
        repo.save(usuario);
    }

}
