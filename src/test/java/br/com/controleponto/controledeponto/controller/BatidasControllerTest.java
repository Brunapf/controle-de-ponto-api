package br.com.controleponto.controledeponto.controller;

import br.com.controleponto.controledeponto.request.BatidaRequest;
import br.com.controleponto.controledeponto.service.BatidaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatidasControllerTest {

    @InjectMocks
    BatidasController batidasController;

    @Mock
    private BatidaService batidaService;

    @Test
    public void testBuscarAll() throws Exception {
        ResponseEntity<Object> resposta = batidasController.findAll();
        assertEquals(HttpStatus.OK,resposta.getStatusCode());
    }

    @Test
    public void testInserirBatida() throws Exception {
        BatidaRequest request = new BatidaRequest();
        request.setDataHora(LocalDateTime.of(2021,8,9,20,12));
        when(batidaService.salvar(request)).thenReturn(new ResponseEntity<>(HttpStatus.CREATED));
        ResponseEntity<Object> resposta = batidasController.saveBatida(request);
        assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
    }
}