package br.com.aygean.astroapp.adapters.outbound.request;

public class PlanetRequest {
    private Conditions condicoes;

    public PlanetRequest(String slug){
        this.condicoes = new Conditions(slug);
    }

    public Conditions getCondicoes() {
        return condicoes;
    }

    public void setCondicoes(Conditions condicoes) {
        this.condicoes = condicoes;
    }
}