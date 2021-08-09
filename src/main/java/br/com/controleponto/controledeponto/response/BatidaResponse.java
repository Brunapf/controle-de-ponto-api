package br.com.controleponto.controledeponto.response;

import br.com.controleponto.controledeponto.entity.BatidaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatidaResponse {

    @JsonProperty("id_registro")
    private Integer id;

    @JsonProperty("entrada1")
    private LocalDateTime entrada1;

    public BatidaResponse(BatidaEntity batidaEntity) {
        this.id = batidaEntity.getId();
        this.entrada1 = batidaEntity.getEntrada1();
    }
}
