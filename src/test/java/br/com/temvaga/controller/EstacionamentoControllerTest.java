package br.com.temvaga.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.service.EstacionamentoService;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.http.ContentType;



@WebMvcTest
public class EstacionamentoControllerTest {

    @Autowired
    public EstacionamentoController estacionamentoController;

    @MockBean
    private EstacionamentoService estacionamentoService;

    @BeforeEach
    // colocar para ele rodar antes dos testes para controlar o contexto e não carregar todas as informações do projeto
    public void setup() {
        standaloneSetup(this.estacionamentoController);
    }



    @Test
    public void  deveRetornarBadRequest_QuandoBuscarEstacionamen(){
        when(this.estacionamentoService.ListaEstacionamentoPorId(1))
                .thenReturn(null);
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/Estacionamento/{id}", 5)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    }





