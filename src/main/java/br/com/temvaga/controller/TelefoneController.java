package br.com.temvaga.controller;

import br.com.temvaga.model.Telefone;
import br.com.temvaga.repository.TelefoneRepository;
import br.com.temvaga.service.TelefoneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/telefones")
@AllArgsConstructor
public class TelefoneController {
    @Autowired
    private  TelefoneRepository repo;
    private final TelefoneService repoService;

    public TelefoneController(TelefoneService repoService) {
    this.repoService = repoService;
}


    @RequestMapping("/list")
    public ArrayList<Telefone> findAll(){
        return  (ArrayList<Telefone>) repo.findAll();
    }

    @RequestMapping(value = "/list/id", method = RequestMethod.GET)
    public Telefone listById(@RequestParam Integer id){
    Optional<Telefone> telefone = repo.findById(id);
    return telefone.get();
}

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void AddTelefone(@RequestBody Telefone telefone){
        repo.save(telefone);
    }


    //Utilizando a service

    @DeleteMapping(path = "/{id}")
    public  ResponseEntity<Void> del(@PathVariable Integer id){
    repoService.delete(id);
    return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}
