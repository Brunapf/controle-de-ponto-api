package br.com.controleponto.controledeponto.response;

import br.com.controleponto.controledeponto.entity.Batida;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BatidaResponse {

    @JsonProperty("id_registro")
    private Integer id;

    @JsonProperty("entrada1")
    private LocalDateTime entrada1;

    public BatidaResponse(Batida batida) {
        this.id = batida.getId();
        this.entrada1 = batida.getEntrada1();
    }
}
