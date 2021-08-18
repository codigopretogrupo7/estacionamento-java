package br.com.temvaga.controller;

import br.com.temvaga.repository.EstacionamentoRepository;
import br.com.temvaga.service.EstacionamentoService;
import jdk.jfr.Category;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;
import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;

@RunWith(SpringRunner.class)
@WebMvcTest(EstacionamentoController.class)
class EstacionamentoControllerTest {

    @Autowired
    private EstacionamentoController estacionamentoController;

    @MockBean
    private EstacionamentoService estacionamentoService;

    @BeforeEach
    // colocar para ele rodar antes dos testes para controlar o contexto e não carregar todas as informações do projeto
    public void setup() {
        standaloneSetup(this.estacionamentoController);
    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarVagaPorID(){
        when(this.estacionamentoService.ListaEstacionamentoPorId( ))
    }





}