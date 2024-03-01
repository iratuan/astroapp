// Classe responsável por implementar a lógica de salvar um planeta

package br.com.aygean.astroapp.application.core.usecase;
import br.com.aygean.astroapp.application.core.domain.Planet;
import br.com.aygean.astroapp.application.ports.in.SavePlanePortIn;
import br.com.aygean.astroapp.application.ports.out.SavePlanetPortOut;

public class SavePlanetUseCase implements SavePlanePortIn{    
    private final SavePlanetPortOut savePlanetPortOut;
    
    public SavePlanetUseCase(SavePlanetPortOut savePlanetPortOut) {
        this.savePlanetPortOut = savePlanetPortOut;
    }
    
    @Override
    public Planet savePlanet(Planet planet) {
        return this.savePlanetPortOut.savePlanet(planet);
    }
}