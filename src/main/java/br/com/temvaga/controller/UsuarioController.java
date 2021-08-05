package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Usuario;

import br.com.temvaga.service.EstacionamentoService;
import br.com.temvaga.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(value = "/list/id")
    public ResponseEntity<Usuario> UsuariobyId (@RequestParam(name = "id") Integer id){
        return usuarioService.usuarioById(id);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<ArrayList<Usuario>> findAll(){
        return usuarioService.listaTodosUsuarios();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Usuario> AddUsuario(@RequestBody Usuario usuario){
        return usuarioService.AdicionaUsuario(usuario);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Usuario> updateUsuario(@RequestParam(name="id") Integer id, @RequestBody Usuario usuario){
        return usuarioService.AtualizarUsuario(id,usuario);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Usuario> deleteUsuario(@RequestParam(name = "id") Integer id){
        return usuarioService.deletarUsuario(id);
    }

}
