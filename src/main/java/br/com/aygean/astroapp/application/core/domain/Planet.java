/**
 * Classe que representa um planeta com informações básicas.
 */
package br.com.aygean.astroapp.application.core.domain;

public class Planet {
    private String slug;
    private String name;
    private String description;
    private String image;

    public Planet() {
    }

    public Planet(String slug, String name, String description, String image) {
        this.slug = slug;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}