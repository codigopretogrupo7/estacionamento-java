package br.com.temvaga.controller;

import br.com.temvaga.service.EstacionamentoService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;
'1q'


import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;


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
    public void deveRetornarSucesso_QuandoBuscarVagaPorId(){
        when(this.estacionamentoService.ListaEstacionamentoPorId(1));
        Mockito.Return
    }





}