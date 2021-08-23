package br.com.temvaga.controller;

import br.com.temvaga.model.Vaga;
import br.com.temvaga.service.VagaService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;





@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WithMockUser(username = "root")

@WebMvcTest(VagaController.class)
public class VagaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VagaService vagaService;




    @Test
    public void deveRetornarSucesso_VagasLivres() throws Exception{
        Vaga vag = new Vaga(1);
        Mockito.when(vagaService.vagaslivres(1)).thenReturn(new ResponseEntity<Integer>(HttpStatus.OK));
        this.mockMvc.perform(
                        get("/api/vagaslivres/id")
                                .queryParam("id","1")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deveRetornarNotFound_VagasLivres() throws Exception{
        Mockito.when(vagaService.vagaslivres(1)).thenReturn(new ResponseEntity<Integer>(HttpStatus.NOT_FOUND));
        this.mockMvc.perform(
                        get("/api/vagaslivres")
                                .queryParam("id","1")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }




}





