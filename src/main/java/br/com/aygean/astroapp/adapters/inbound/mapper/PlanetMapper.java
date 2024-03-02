package br.com.aygean.astroapp.adapters.inbound.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.aygean.astroapp.adapters.inbound.response.PlanetResponse;
import br.com.aygean.astroapp.adapters.outbound.response.ItemApiPlanetResponse;
import br.com.aygean.astroapp.application.core.domain.Planet;

@Component
public class PlanetMapper {    
    public PlanetResponse mapToPlanetResponse(Planet planet) {
        PlanetResponse planetResponse = new PlanetResponse();
        BeanUtils.copyProperties(planet, planetResponse);
        return planetResponse;
    } 

    public PlanetResponse mapToPlanetResponse(ItemApiPlanetResponse planet) {        
        return new PlanetResponse(planet.getSlug(), planet.getNome(), planet.getDescricao(), planet.getImgUrl());
    } 
}
