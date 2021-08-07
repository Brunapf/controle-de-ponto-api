package br.com.controleponto.controledeponto.controller;

import br.com.controleponto.controledeponto.request.BatidaRequest;
import br.com.controleponto.controledeponto.response.BatidaResponse;
import br.com.controleponto.controledeponto.service.BatidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batidas")
public class BatidasController {

    @Autowired
    private BatidaService batidaService;

    @GetMapping()
    public ResponseEntity<Object> findAll() throws Exception{
        List<BatidaResponse> batidas = batidaService.buscarTodos();
        return new ResponseEntity<>(batidas, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> saveBatida(@RequestBody BatidaRequest request) throws Exception{
        return batidaService.salvar(request);
    }


}
