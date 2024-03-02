package br.com.aygean.astroapp.adapters.inbound.response;

import org.springframework.stereotype.Component;

public class PlanetResponse {
    private Long id;
    private String slug;
    private String name;
    private String description;
    private String image;
    private String url;

    public PlanetResponse() {
    }

    public PlanetResponse(String slug, String name, String description, String image) {
        var slugParts = slug.split("-");
        this.id = Long.valueOf(slugParts[1]);
        this.slug = slugParts[0];
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Long getId() {return id;}
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
    public void setUrl(String url) {this.url = url;}
    public String getUrl() {
        return url;
    }
}
