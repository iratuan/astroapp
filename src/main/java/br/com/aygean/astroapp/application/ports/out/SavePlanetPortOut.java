package br.com.aygean.astroapp.application.ports.out;

import br.com.aygean.astroapp.application.core.domain.Planet;

public interface SavePlanetPortOut {
    Planet savePlanet(Planet planet);
}
