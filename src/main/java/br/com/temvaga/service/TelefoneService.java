package br.com.temvaga.service;

import br.com.temvaga.model.Telefone;
import br.com.temvaga.repository.TelefoneRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneService {
    private final TelefoneRepository telefoneRepository;

    public TelefoneService(TelefoneRepository telefoneRepository) {
    this.telefoneRepository = telefoneRepository;
}

    public List<Telefone> listAll(){
        return (List<Telefone>) telefoneRepository.findAll();
    }

    public void delete(Integer id){
        telefoneRepository.deleteById(id);
    }

}
