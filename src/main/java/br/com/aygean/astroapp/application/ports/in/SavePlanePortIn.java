package br.com.aygean.astroapp.application.ports.in;

import br.com.aygean.astroapp.application.core.domain.Planet;

public interface SavePlanePortIn {
    Planet savePlanet(Planet planet);
}
