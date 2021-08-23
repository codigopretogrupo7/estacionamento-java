package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.service.EstacionamentoService;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;





@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WithMockUser(username = "root")

@WebMvcTest(EstacionamentoController.class)
public class EstacionamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstacionamentoService estacionamentoService;




    @Test
    public void deveRetornarSucesso_QuandoBurcarEstacionamentoPorID() throws Exception{
        Estacionamento est = new Estacionamento(2);
        Mockito.when(estacionamentoService.ListaEstacionamentoPorId(2)).thenReturn(new ResponseEntity<Estacionamento>(est,HttpStatus.OK));
        this.mockMvc.perform(
                        get("/api/estacionamentos/list/id")
                                .queryParam("id","1")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }
    @Test
    public void  deveRetornarNotFound_QuandoBuscarEstacionamen() throws Exception{
        Mockito.when(estacionamentoService.ListaEstacionamentoPorId(1)).thenReturn(new ResponseEntity<Estacionamento>(HttpStatus.NOT_FOUND));
        this.mockMvc.perform(
                        get("/api/estacionamentos/list/id")
                                .queryParam("id","1")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void  deveRetornarListaDeEstacionameto_QuandoBuscarEstacionamen() throws Exception{
        Mockito.when(estacionamentoService.ListaTodosEstacionamentos()).thenReturn(new ResponseEntity<ArrayList<Estacionamento>>(HttpStatus.OK));
        this.mockMvc.perform(
                        get("/api/estacionamentos/list")
                                .queryParam("id","1")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    }





