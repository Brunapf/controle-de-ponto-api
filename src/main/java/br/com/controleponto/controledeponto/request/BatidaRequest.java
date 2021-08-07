package br.com.controleponto.controledeponto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BatidaRequest {

    @JsonProperty("dataHora")
    LocalDateTime dataHora;

}
