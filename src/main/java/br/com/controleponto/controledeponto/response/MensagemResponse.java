package br.com.controleponto.controledeponto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensagemResponse {

    @JsonProperty("mensagem")
    String mensagem;
}
