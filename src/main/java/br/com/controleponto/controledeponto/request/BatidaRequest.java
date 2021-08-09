package br.com.controleponto.controledeponto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatidaRequest {

    @JsonProperty("dataHora")
    LocalDateTime dataHora;

}
