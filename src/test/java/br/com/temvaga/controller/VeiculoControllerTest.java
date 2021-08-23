package br.com.temvaga.controller;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Vaga;
import br.com.temvaga.model.Veiculo;
import br.com.temvaga.service.VagaService;
import br.com.temvaga.service.VeiculoService;
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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;





@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WithMockUser(username = "cristala")

@WebMvcTest(VeiculoController.class)
public class VeiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VeiculoService veiculoService;


    @Test
    public void deveRetornarSucesso_QuandoBurcarEstacionamentoPorID() throws Exception{
        Veiculo vei = new Veiculo();
        Mockito.when(veiculoService.VeiculoPorId(7)).thenReturn(new ResponseEntity<Veiculo>(vei,HttpStatus.OK));
        this.mockMvc.perform(
                        get("/api/veiculos/list/id")
                                .queryParam("id","7")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }
    @Test

    public void  deveRetornarListaDeEstacionameto_QuandoBuscarVeiculo() throws Exception{
        Mockito.when(veiculoService.listaTodosVeiculos()).thenReturn(new ResponseEntity<ArrayList<Veiculo>>(HttpStatus.OK));
        this.mockMvc.perform(
                        get("/api/veiculos/list")
                                .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk());
    }
}