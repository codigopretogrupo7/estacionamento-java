package br.com.temvaga.controller;

import br.com.temvaga.repository.EstacionamentoRepository;
import br.com.temvaga.service.EstacionamentoService;
import jdk.jfr.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(EstacionamentoController.class)
class EstacionamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstacionamentoService estacionamentoService;



}