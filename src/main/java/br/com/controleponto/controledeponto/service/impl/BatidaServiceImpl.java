package br.com.controleponto.controledeponto.service.impl;

import br.com.controleponto.controledeponto.entity.BatidaEntity;
import br.com.controleponto.controledeponto.repository.BatidaRepository;
import br.com.controleponto.controledeponto.request.BatidaRequest;
import br.com.controleponto.controledeponto.response.BatidaResponse;
import br.com.controleponto.controledeponto.response.MensagemResponse;
import br.com.controleponto.controledeponto.service.BatidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class BatidaServiceImpl implements BatidaService {

    @Autowired
    private BatidaRepository repository;

    public ResponseEntity<Object> salvar(BatidaRequest request) throws Exception{

        MensagemResponse response = new MensagemResponse();

        if(request.getDataHora() == null){
             response.setMensagem("Campo obrigatório não informado");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if("".equals(request.getDataHora())){
            response.setMensagem("Data e hora em formato inválido");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if(isFinalSemana(request.getDataHora())){
            response.setMensagem("Sábado e domingo não são permitidos como dia de trabalho.");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }

        Integer quantidadeBatidas = repository.buscarQuantidadeBatidas(request.getDataHora().toLocalDate());
        if(quantidadeBatidas >= 4){
            response.setMensagem("Apenas 4 horários podem ser registrados por dia.");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }

        List<BatidaEntity> batidasResgistradas = repository.buscarPorBatida(request.getDataHora());
        if(!batidasResgistradas.isEmpty()){
            response.setMensagem("Horário já registrado");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

       List<BatidaEntity> batidasPorData = repository.buscarBatidasPorData(request.getDataHora().toLocalDate());
        if(!batidasPorData.isEmpty()){
            for(BatidaEntity batida: batidasPorData){
               int qtd  = repository.confereHorarioMenorUmaHora(request.getDataHora(),batida.getEntrada1());
                if(qtd == 1){
                    response.setMensagem("Deve haver no mínimo 1 hora de almoço");
                    return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
                }
            }
        }

        BatidaEntity entity = new BatidaEntity();
        entity.setEntrada1(request.getDataHora());
        repository.save(entity);
        response.setMensagem("Created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    private boolean isFinalSemana(LocalDateTime dataHora) {
        LocalDate dia = dataHora.toLocalDate();
            if(!dia.getDayOfWeek().equals(DayOfWeek.SATURDAY) &&
                    !dia.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                return false;
            }
        return true;
    }

    public List<BatidaResponse> buscarTodos() throws Exception{
        var batidas = repository.findAll();
        return batidas.stream().map(batida -> new BatidaResponse(batida)).collect(Collectors.toList());
    }
}