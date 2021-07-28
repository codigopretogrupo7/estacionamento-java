package br.com.temvaga.service;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Usuario;
import br.com.temvaga.model.Vaga;
import br.com.temvaga.repository.EstacionamentoRepository;
import br.com.temvaga.repository.UsuarioRepository;
import br.com.temvaga.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstacionamentoService {

    private final EstacionamentoRepository estacionamentoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;
    VagaRepository vagaRepository;

    public EstacionamentoService(EstacionamentoRepository estacionamentoRepository,
                                 UsuarioRepository usuarioRepository, VagaRepository vagaRepository) {
    this.estacionamentoRepository = estacionamentoRepository;
        this.usuarioRepository = usuarioRepository;
        this.vagaRepository = vagaRepository;
    }

    public ArrayList<Estacionamento> findAll(){
    return  (ArrayList<Estacionamento>) estacionamentoRepository.findAll();
}


    public void save(@RequestBody Estacionamento estacionamento){

        int idUsuario = estacionamento.getIdUsuario();

        Optional<Usuario> user = usuarioRepository.findById(idUsuario);
        Usuario novoUsuario = user.get();
        estacionamento.setUsuario(novoUsuario);

        estacionamentoRepository.save(estacionamento);

        int numeroDeVagas = estacionamento.getNumVagas();
        int idEstacionamento = estacionamento.getId();

        Optional<Estacionamento> estacionamentoProcurado = estacionamentoRepository.findById(idEstacionamento);

        Estacionamento estacionamentoCriado = estacionamentoProcurado.get();

        for ( int i = 1 ; i <= numeroDeVagas ; i++ ){
            Vaga vs = new Vaga();
            vs.setNumeroVaga(Integer.toString(i));
            vs.setEstacionamento(estacionamentoCriado);
            vagaRepository.save(vs);
        };


    }

}
