package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Usuario;

import br.com.temvaga.service.EstacionamentoService;
import br.com.temvaga.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @ApiOperation(value = "Listar um usuario cadastrado pelo seu id")
    @GetMapping(value = "/list/id")
    public ResponseEntity<Usuario> UsuariobyId (@RequestParam(name = "id") Integer id){
        return usuarioService.usuarioById(id);
    }

    @ApiOperation(value = "Lista usuario por nome")
    @GetMapping(value = "/list/name")
    public ResponseEntity<Usuario> usuarioByName(@RequestParam(name = "username") String nome){
        return usuarioService.usuarioByNameUser(nome);
    }

    @ApiOperation(value = "Listar todos os usuarios cadastrados")
    @GetMapping(value = "/list")
    public ResponseEntity<ArrayList<Usuario>> findAll(){
        return usuarioService.listaTodosUsuarios();
    }

    @ApiOperation(value = "Adicionar um novo usuario")
    @PostMapping(value = "/add")
    public ResponseEntity<Usuario> AddUsuario(@RequestBody Usuario usuario){
        return usuarioService.AdicionaUsuario(usuario);
    }

    @ApiOperation(value = "Atualizar um usuario", notes="envie todo o body de usuario")
    @PutMapping(value = "/update")
    public ResponseEntity<Usuario> updateUsuario(@RequestParam(name="id") Integer id, @RequestBody Usuario usuario){
        return usuarioService.AtualizarUsuario(id,usuario);
    }

    @ApiOperation(
            value = "Deletar um usuario pelo seu id",
            notes = "Deleta um usuario bem como veiculos e estacionamentos cadastrados em seu id"
    )
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Usuario> deleteUsuario(@RequestParam(name = "id") Integer id){
        return usuarioService.deletarUsuario(id);
    }

}
