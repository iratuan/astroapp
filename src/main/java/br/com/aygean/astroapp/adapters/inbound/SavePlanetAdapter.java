package br.com.aygean.astroapp.adapters.inbound;

import org.springframework.stereotype.Service;

import br.com.aygean.astroapp.application.core.domain.Planet;
import br.com.aygean.astroapp.application.ports.out.SavePlanetPortOut;

@Service
public class SavePlanetAdapter implements SavePlanetPortOut {

    @Override
    public Planet savePlanet(Planet planet) {
        return planet;
    }

}
