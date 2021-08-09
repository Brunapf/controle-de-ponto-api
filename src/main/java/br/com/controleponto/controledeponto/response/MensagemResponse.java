package br.com.controleponto.controledeponto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemResponse {

    @JsonProperty("mensagem")
    String mensagem;
}
