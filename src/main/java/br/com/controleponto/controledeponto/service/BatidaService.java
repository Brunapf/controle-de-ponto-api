package br.com.controleponto.controledeponto.service;

import br.com.controleponto.controledeponto.request.BatidaRequest;
import br.com.controleponto.controledeponto.response.BatidaResponse;
import br.com.controleponto.controledeponto.response.MensagemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BatidaService {

    public ResponseEntity<Object> salvar(BatidaRequest request) throws Exception;

    public List<BatidaResponse> buscarTodos() throws Exception;
}
