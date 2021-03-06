package br.com.temvaga.service;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Usuario;
import br.com.temvaga.model.Vaga;
import br.com.temvaga.repository.EstacionamentoRepository;
import br.com.temvaga.repository.UsuarioRepository;
import br.com.temvaga.repository.VagaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstacionamentoService {


    @Autowired
    private EstacionamentoRepository estacionamentoRepository;
    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;


    public ResponseEntity<ArrayList<Estacionamento>> ListaTodosEstacionamentos(){
        ArrayList<Estacionamento> estacionamentos = (ArrayList<Estacionamento>) estacionamentoRepository.findAll();
        if( estacionamentos.isEmpty() ){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<ArrayList<Estacionamento>>(estacionamentos, HttpStatus.OK);
        }
    }

    public ResponseEntity<Estacionamento> ListaEstacionamentoPorId( Integer id ){
        Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(id);
        if( estacionamento.isPresent() ){
            return new ResponseEntity<Estacionamento>(estacionamento.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Estacionamento> AdicionaEstacionamento(Estacionamento estacionamento) {
        estacionamento.setSenhaEstacionamento((bCryptPasswordEncoder.encode(estacionamento.getSenhaEstacionamento())));
        estacionamentoRepository.save(estacionamento);

        int numeroDeVagas = estacionamento.getNumVagas();
        int idEstacionamento = estacionamento.getId();

        Optional<Estacionamento> estacionamentoProcurado = estacionamentoRepository.findById(idEstacionamento);
        Estacionamento estacionamentoCriado = estacionamentoProcurado.get();

        for (int i = 1; i <= numeroDeVagas; i++) {
            Vaga vaga = new Vaga();
            vaga.setEstacionamento(estacionamentoCriado);
            vaga.setNumeroVaga(Integer.toString(i));
            vaga.setSituacao("vazia");
            vagaRepository.save(vaga);
        }
        return new ResponseEntity<Estacionamento>(estacionamento,HttpStatus.CREATED);
    }

    public ResponseEntity<Estacionamento> DeletarEstacionamento( Integer id ){

        Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(id);
        Estacionamento estacionamentoCriado = estacionamento.get();
        ArrayList<Vaga> vaga = vagaRepository.findAllByEstacionamento(estacionamentoCriado);

        if (estacionamento.isPresent()) {
            for( int i = 0 ; i < vaga.toArray().length ; i++ ){
                if(vaga.toArray().length > 0){
                    vagaRepository.delete(vaga.get(i));
                }
            }
            estacionamentoRepository.delete(estacionamentoCriado);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Estacionamento> AtualizarEstacionamento (
            Integer id,
            Estacionamento estacionamento){

        Optional<Estacionamento> velhoEstacionamento = estacionamentoRepository.findById(id);
        if(velhoEstacionamento.isPresent()) {

            Estacionamento velhoEstacionamentoEditado = velhoEstacionamento.get();

            velhoEstacionamentoEditado.setNomeEstacionamento(estacionamento.getNomeEstacionamento());
            velhoEstacionamentoEditado.setDescricao(estacionamento.getDescricao());
            velhoEstacionamentoEditado.setFoto(estacionamento.getFoto());
            velhoEstacionamentoEditado.setEstado(estacionamento.getEstado());
            velhoEstacionamentoEditado.setCidade(estacionamento.getCidade());
            velhoEstacionamentoEditado.setBairro(estacionamento.getBairro());
            velhoEstacionamentoEditado.setLogadouro(estacionamento.getLogadouro());
            velhoEstacionamentoEditado.setNumero(estacionamento.getNumero());
            velhoEstacionamentoEditado.setLat(estacionamento.getLat());
            velhoEstacionamentoEditado.setLng(estacionamento.getLng());
            velhoEstacionamentoEditado.setNumVagas(estacionamento.getNumVagas());
            velhoEstacionamentoEditado.setVlHora(estacionamento.getVlHora());
            velhoEstacionamentoEditado.setVlDiaria(estacionamento.getVlDiaria());
            velhoEstacionamentoEditado.setVlAdicional(estacionamento.getVlAdicional());
            velhoEstacionamentoEditado.setFrame(estacionamento.getFrame());
            velhoEstacionamentoEditado.setHrAbertura(estacionamento.getHrAbertura());
            velhoEstacionamentoEditado.setHrFechamento(estacionamento.getHrFechamento());
            velhoEstacionamentoEditado.setEmailEstacionamento(estacionamento.getEmailEstacionamento());
            velhoEstacionamentoEditado.setSenhaEstacionamento(estacionamento.getSenhaEstacionamento());
            velhoEstacionamentoEditado.setCEP(estacionamento.getCEP());
            velhoEstacionamentoEditado.setTelefone(estacionamento.getTelefone());

            estacionamentoRepository.save(velhoEstacionamentoEditado);
            return new ResponseEntity<Estacionamento>(velhoEstacionamentoEditado, HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ArrayList<Estacionamento>  EstacionamentoPorUsuario(Usuario usuario){
        return estacionamentoRepository.findAllByUsuario(usuario);
    }

    public ResponseEntity<Estacionamento> BuscarPorEmail(String email, String senha){
        Optional<Estacionamento> estacionamento = estacionamentoRepository.findByEmailEstacionamento(email);
        if(estacionamento.isPresent()){
            Estacionamento estacionamentoCriado = estacionamento.get();
            if(bCryptPasswordEncoder.matches(senha,estacionamentoCriado.getSenhaEstacionamento())){
                return new ResponseEntity<Estacionamento>(estacionamentoCriado, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
