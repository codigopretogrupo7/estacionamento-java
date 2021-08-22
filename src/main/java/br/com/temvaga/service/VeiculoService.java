package br.com.temvaga.service;

import br.com.temvaga.model.Usuario;
import br.com.temvaga.model.Veiculo;
import br.com.temvaga.repository.UsuarioRepository;
import br.com.temvaga.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<ArrayList<Veiculo>> listaTodosVeiculos(){
        ArrayList<Veiculo> veiculos = (ArrayList<Veiculo>) veiculoRepository.findAll();
        if( veiculos.isEmpty() ){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<ArrayList<Veiculo>>(veiculos, HttpStatus.OK);
        }
    }

    public ResponseEntity<Veiculo> VeiculoPorId( Integer id ){
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if( veiculo.isPresent() ){
            return new ResponseEntity<Veiculo>(veiculo.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Veiculo> AdicionaVeiculo(Veiculo veiculo){
        veiculoRepository.save(veiculo);

        return new ResponseEntity<Veiculo>(veiculo,HttpStatus.CREATED);
    }

    public ResponseEntity<Veiculo> DeletarVeiculo(Integer id){
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if( veiculo.isPresent() ){
            veiculoRepository.delete(veiculo.get());
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Veiculo> AtualizarVeiculo(Integer id, Veiculo veiculo){
        Optional<Veiculo> veiculoVelho = veiculoRepository.findById(id);

        if(veiculoVelho.isPresent()){
            Veiculo veiculoEditado = veiculoVelho.get();

            veiculoEditado.setCor(veiculo.getCor());
            veiculoEditado.setModelo(veiculo.getModelo());
            veiculoEditado.setPlaca(veiculo.getPlaca());
            veiculoRepository.save(veiculoEditado);
            return new ResponseEntity<Veiculo>(veiculoEditado,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ArrayList<Veiculo>> VeiculosPorUsuario(Integer id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            ArrayList<Veiculo> listaDeVeiculos = veiculoRepository.findAllByUsuario(usuario.get());
            return new ResponseEntity<ArrayList<Veiculo>>(listaDeVeiculos, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
