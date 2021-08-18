package br.com.temvaga.controller;

import br.com.temvaga.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;//testa as classes dentro do controler

    @Mock
    private UsuarioService usuarioServiceMock;


    @Test
    void test(){}

}