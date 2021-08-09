package br.com.controleponto.controledeponto.service;

import br.com.controleponto.controledeponto.entity.BatidaEntity;
import br.com.controleponto.controledeponto.repository.BatidaRepository;
import br.com.controleponto.controledeponto.request.BatidaRequest;
import br.com.controleponto.controledeponto.response.BatidaResponse;
import br.com.controleponto.controledeponto.service.impl.BatidaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatidaServiceImplTest {

    @InjectMocks
    private BatidaServiceImpl service;

    @Mock
    private BatidaRepository repository;

    LocalDateTime date = LocalDateTime.now();
    LocalDateTime diaSemana = LocalDateTime.of(2021,8,9,12,23);

    @Test
    public void testBuscarTodos() throws Exception {
        List<BatidaEntity> listResponse = new ArrayList<>();
        BatidaEntity entity = new BatidaEntity();
        entity.setId(1);
        entity.setEntrada1(date);
        listResponse.add(entity);
        when(repository.findAll()).thenReturn(listResponse);

        List<BatidaResponse> compare = new ArrayList<>();
        BatidaResponse batida2 = new BatidaResponse(entity);
        compare.add(batida2);

        assertEquals(compare,service.buscarTodos());
    }

    @Test
    public void testSalvarCreated() throws Exception {
        BatidaRequest request = new BatidaRequest();
        request.setDataHora(diaSemana);
        ResponseEntity<Object> resposta = service.salvar(request);
        assertEquals(HttpStatus.CREATED,resposta.getStatusCode());
    }

    @Test
    public void testSalvarErroFinalSemana() throws Exception {
        // Data de um final de semana
        BatidaRequest request = new BatidaRequest();
        request.setDataHora(LocalDateTime.of(2021,8,8,12,23));

        ResponseEntity<Object> resposta = service.salvar(request);
        assertEquals(HttpStatus.FORBIDDEN,resposta.getStatusCode());

    }

    @Test
    public void testSalvarErroNull() throws Exception {
        BatidaRequest request = new BatidaRequest();
        request.setDataHora(null);

        ResponseEntity<Object> resposta = service.salvar(request);
        assertEquals(HttpStatus.BAD_REQUEST,resposta.getStatusCode());
    }

    @Test
    public void testSalvarErroQtd() throws Exception {

        BatidaRequest request = new BatidaRequest();
        request.setDataHora(diaSemana);
        when(repository.buscarQuantidadeBatidas(diaSemana.toLocalDate())).thenReturn(4);
        ResponseEntity<Object> resposta = service.salvar(request);
        assertEquals(HttpStatus.FORBIDDEN,resposta.getStatusCode());
    }

    @Test
    public void testSalvarErroBatidaJaRegistrada() throws Exception {
        BatidaRequest request = new BatidaRequest();
        request.setDataHora(diaSemana);

        List<BatidaEntity> batidas = new ArrayList<>();
        BatidaEntity entity = new BatidaEntity(1,diaSemana);
        batidas.add(entity);

        when(repository.buscarPorBatida(diaSemana)).thenReturn(batidas);
        ResponseEntity<Object> resposta = service.salvar(request);
        assertEquals(HttpStatus.CONFLICT,resposta.getStatusCode());
    }
}