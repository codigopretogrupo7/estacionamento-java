package br.com.temvaga.controller;


import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Usuario;
import br.com.temvaga.service.UsuarioService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;





@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WithMockUser(username = "root")

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;




    @Test
    public void deveRetornarSucesso_QuandoBurcaUsuárioPorNome() throws Exception{
        Usuario user = new Usuario();
        Mockito.when(usuarioService.usuarioByNameUser("username")).thenReturn(new ResponseEntity<Usuario>(user, HttpStatus.OK));
        this.mockMvc.perform(
                        get("/api/usuarios/list/name")
                                .queryParam("username","Cristala")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        }
    @Test
    public void deveRetornarBadRequest_QuandoBurcaUsuário() throws Exception{
        Mockito.when(usuarioService.usuarioByNameUser("")).thenReturn(new ResponseEntity<Usuario>( HttpStatus.BAD_REQUEST));
        this.mockMvc.perform(
                        get("/api/usuarios/list/name")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveRetornarNotFound_QuandoBurcaUsuárioPorNome() throws Exception{
        Mockito.when(usuarioService.usuarioByNameUser("teste")).thenReturn(new ResponseEntity<Usuario>( HttpStatus.NOT_FOUND));
        this.mockMvc.perform(
                        get("/api/usuarios/list/name")
                                .queryParam("username","teste")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }




}





