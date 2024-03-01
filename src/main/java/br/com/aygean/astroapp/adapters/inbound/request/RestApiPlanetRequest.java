package br.com.aygean.astroapp.adapters.inbound.request;

public class RestApiPlanetRequest {
    private Conditions condicoes;

    public RestApiPlanetRequest(String slug){
        this.condicoes = new Conditions(slug);
    }

    public Conditions getCondicoes() {
        return condicoes;
    }

    public void setCondicoes(Conditions condicoes) {
        this.condicoes = condicoes;
    }

    @Override
    public String toString() {
        return "RestApiPlanetRequest [condicoes=" + condicoes + "]";
    }

    
}

class Conditions{
    private String slug;

    public Conditions(String slug) {
        this.slug = slug;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Conditions [slug=" + slug + "]";
    }
    
}
