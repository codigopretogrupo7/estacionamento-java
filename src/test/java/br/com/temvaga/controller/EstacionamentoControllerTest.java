package br.com.temvaga.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.service.EstacionamentoService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;
import io.restassured.http.ContentType;
import org.springframework.test.web.servlet.MockMvc;





@WebMvcTest
public class EstacionamentoControllerTest {

    @Autowired

    private MockMvc mockMvc;

    @MockBean
    private EstacionamentoService estacionamentoService;




    @Test
    public void deveRetornarSucesso_QuandoBurcarEstacionamentoPorID() throws Exception{
        Estacionamento est = new Estacionamento(1);
        Mockito.when(estacionamentoService.ListaEstacionamentoPorId(1)).thenReturn(ResponseEntity.ok(est));
        this.mockMvc.perform(
                        get("/api/estacionamentos/list/id")
                                .queryParam("id","1")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));



    }

    @Test
    public void  deveRetornarBadRequest_QuandoBuscarEstacionamen(){
        when(this.estacionamentoService.ListaEstacionamentoPorId(520))
                .thenReturn(null);
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/Estacionamento/{id}", 520)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    }





