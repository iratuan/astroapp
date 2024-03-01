
package br.com.aygean.astroapp.application.core.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlanetTest {

    @Test
    public void testGetSlug() {
        Planet planet = new Planet("earth", "Earth", "Description of Earth", "earth.jpg");
        assertEquals("earth", planet.getSlug());
    }

    @Test
    public void testSetSlug() {
        Planet planet = new Planet();
        planet.setSlug("mars");
        assertEquals("mars", planet.getSlug());
    }

    @Test
    public void testGetName() {
        Planet planet = new Planet("earth", "Earth", "Description of Earth", "earth.jpg");
        assertEquals("Earth", planet.getName());
    }

    @Test
    public void testSetName() {
        Planet planet = new Planet();
        planet.setName("Mars");
        assertEquals("Mars", planet.getName());
    }

    @Test
    public void testGetDescription() {
        Planet planet = new Planet("earth", "Earth", "Description of Earth", "earth.jpg");
        assertEquals("Description of Earth", planet.getDescription());
    }

    @Test
    public void testSetDescription() {
        Planet planet = new Planet();
        planet.setDescription("Description of Mars");
        assertEquals("Description of Mars", planet.getDescription());
    }

    @Test
    public void testGetImage() {
        Planet planet = new Planet("earth", "Earth", "Description of Earth", "earth.jpg");
        assertEquals("earth.jpg", planet.getImage());
    }

    @Test
    public void testSetImage() {
        Planet planet = new Planet();
        planet.setImage("mars.jpg");
        assertEquals("mars.jpg", planet.getImage());
    }
}