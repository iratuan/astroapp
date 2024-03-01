package br.com.aygean.astroapp.adapters.inbound.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.aygean.astroapp.adapters.inbound.request.PlanetRequest;
import br.com.aygean.astroapp.adapters.inbound.response.ApiPlanetResponse;
import br.com.aygean.astroapp.adapters.inbound.response.PlanetResponse;
import br.com.aygean.astroapp.adapters.inbound.response.RestApiPlanetResponse;
import br.com.aygean.astroapp.application.core.domain.Planet;

@Component
public class PlanetMapper {
    public Planet mapToPlanetDomain(PlanetRequest planetRequest) {
        Planet planet = new Planet();
        BeanUtils.copyProperties(planetRequest, planet);
        return planet;

    }

    public PlanetResponse mapToPlanetResponse(Planet planet) {
        PlanetResponse planetResponse = new PlanetResponse();
        BeanUtils.copyProperties(planet, planetResponse);
        return planetResponse;
    } 

    public PlanetResponse mapToPlanetResponse(ApiPlanetResponse planet) {        
        return new PlanetResponse(planet.getSlug(), planet.getNome(), planet.getDescricao(), planet.getImgUrl());
    } 
}
