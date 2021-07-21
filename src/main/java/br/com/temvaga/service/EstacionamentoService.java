package br.com.temvaga.service;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Telefone;
import br.com.temvaga.repository.EstacionamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Service
public class EstacionamentoService {

    private final EstacionamentoRepository estacionamentoRepository;

    public EstacionamentoService(EstacionamentoRepository estacionamentoRepository) {
    this.estacionamentoRepository = estacionamentoRepository;
}

    public ArrayList<Estacionamento> findAll(){
    return  (ArrayList<Estacionamento>) estacionamentoRepository.findAll();
}


    public void save(@RequestBody Estacionamento estacionamento){
    estacionamentoRepository.save(estacionamento);
}

}
