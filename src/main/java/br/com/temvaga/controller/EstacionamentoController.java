package br.com.temvaga.controller;

import br.com.temvaga.model.Database;
import br.com.temvaga.model.EstacionamentoModel;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {

    @PostMapping("/insert")
    public void insertEstacionamento(){

    }

    @RequestMapping("/delete")
    public int deleteEstacionamento(int a, int b){
        return a + b;
    }

    @RequestMapping("/edit")
    public String editEstacionamento(){
        return "Retornar um objeto estacionamento";
    }


    @RequestMapping("/list")
    public ArrayList<EstacionamentoModel> listarEstacionamento(){
        Database db = new Database();
        ArrayList<EstacionamentoModel> persistedEstacionamento = db.getEstacionamentos();
        return  persistedEstacionamento;
    }


}
