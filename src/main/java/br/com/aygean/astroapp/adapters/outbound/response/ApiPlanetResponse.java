package br.com.aygean.astroapp.adapters.outbound.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiPlanetResponse {

    @JsonProperty("resposta")
    private List<ItemApiPlanetResponse> resposta;

    public List<ItemApiPlanetResponse> getResposta() {
        return resposta;
    }

    public void setResposta(List<ItemApiPlanetResponse> resposta) {
        this.resposta = resposta;
    }

}