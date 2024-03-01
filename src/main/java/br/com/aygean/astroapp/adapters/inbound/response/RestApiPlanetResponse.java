package br.com.aygean.astroapp.adapters.inbound.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestApiPlanetResponse {

    @JsonProperty("resposta")
    private List<ApiPlanetResponse> resposta;

    public List<ApiPlanetResponse> getResposta() {
        return resposta;
    }

    public void setResposta(List<ApiPlanetResponse> resposta) {
        this.resposta = resposta;
    }

}