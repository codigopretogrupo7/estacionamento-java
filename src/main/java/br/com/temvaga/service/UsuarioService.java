package br.com.temvaga.service;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Usuario;
import br.com.temvaga.repository.EstacionamentoRepository;
import br.com.temvaga.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    EstacionamentoService estacionamentoService;

    public ResponseEntity<Usuario> usuarioById(Integer id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Usuario> usuarioByNameUser(String nome) {
        Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findByNome(nome));
        if(usuario.isPresent()){
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ArrayList<Usuario>> listaTodosUsuarios (){
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        if( usuarios.isEmpty() ){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<ArrayList<Usuario>>(usuarios,HttpStatus.OK);
        }
    }

    public ResponseEntity<Usuario> AdicionaUsuario(Usuario usuario) {
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(usuario,HttpStatus.CREATED);
    }

    public ResponseEntity<Usuario> AtualizarUsuario(Integer id, Usuario usuario){
        Optional<Usuario> usuarioVelho = usuarioRepository.findById(id);
        if(usuarioVelho.isPresent()){
            Usuario usuarioEditado = usuarioVelho.get();

            usuarioEditado.setTelefone(usuario.getTelefone());
            usuarioEditado.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
            usuarioRepository.save(usuarioEditado);
            return new ResponseEntity<Usuario>(usuarioEditado,HttpStatus.OK);
        }else {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Usuario> deletarUsuario( Integer id ){

        Optional<Usuario> usuario = usuarioRepository.findById(id);
        Usuario usuarioCriado = usuario.get();

        ArrayList<Estacionamento> estacionamentos = estacionamentoService.EstacionamentoPorUsuario(usuarioCriado);

        if(usuario.isPresent()){
            for( int i = 0 ; i < estacionamentos.toArray().length ; i++ ){
                if(estacionamentos.toArray().length > 0){
                    estacionamentoService.DeletarEstacionamento(estacionamentos.get(i).getId());
                }
            }
            usuarioRepository.delete(usuarioCriado);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
