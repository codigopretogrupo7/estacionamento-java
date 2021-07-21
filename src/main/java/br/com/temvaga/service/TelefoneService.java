package br.com.temvaga.service;

import br.com.temvaga.model.Telefone;
import br.com.temvaga.repository.TelefoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneService {

public TelefoneService(TelefoneRepository telefoneRepository) {
    this.telefoneRepository = telefoneRepository;
}

private final TelefoneRepository telefoneRepository;

    public List<Telefone> listAll(){
        return (List<Telefone>) telefoneRepository.findAll();
    }

    public void delete(Integer id){
        telefoneRepository.deleteById(id);
    }


}
