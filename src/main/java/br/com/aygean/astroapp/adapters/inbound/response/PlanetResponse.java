package br.com.aygean.astroapp.adapters.inbound.response;

public class PlanetResponse {
    private String slug;
    private String name;
    private String description;
    private String image;

    public PlanetResponse(String slug, String name, String description, String image) {
        this.slug = slug;
        this.name = name;
        this.description = description;
        this.image = image;
    }
    public PlanetResponse() {
        //TODO Auto-generated constructor stub
    }
    public String getSlug() {
        return slug;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }

    
}
