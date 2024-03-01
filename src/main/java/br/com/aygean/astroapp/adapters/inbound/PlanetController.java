package br.com.aygean.astroapp.adapters.inbound;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.aygean.astroapp.adapters.inbound.mapper.PlanetMapper;
import br.com.aygean.astroapp.adapters.inbound.request.PlanetRequest;
import br.com.aygean.astroapp.adapters.inbound.request.RestApiPlanetRequest;
import br.com.aygean.astroapp.adapters.inbound.response.ApiPlanetResponse;
import br.com.aygean.astroapp.adapters.inbound.response.PlanetResponse;
import br.com.aygean.astroapp.adapters.inbound.response.RestApiPlanetResponse;
import br.com.aygean.astroapp.adapters.outbound.SearchPlanetRestAdapter;
import br.com.aygean.astroapp.application.core.domain.Planet;
import br.com.aygean.astroapp.application.core.usecase.SavePlanetUseCase;

@RestController
@RequestMapping("/api/planets")
public class PlanetController {

    @Autowired
    private SavePlanetUseCase savePlanetUseCase;

    @Autowired
    private SearchPlanetRestAdapter searchPlanetRestAdapter;

    @Autowired
    private PlanetMapper planetMapper;

    @PostMapping
    public ResponseEntity<PlanetResponse> savePlanet(@RequestBody PlanetRequest planetRequest,
            UriComponentsBuilder uriBuilder) {

        var planet = planetMapper.mapToPlanetDomain(planetRequest);
        planet = savePlanetUseCase.savePlanet(planet);
        var planetResponse = planetMapper.mapToPlanetResponse(planet);

        var uri = uriBuilder.path("/api/planets/{slug}").buildAndExpand(planetResponse.getSlug()).toUri();
        return ResponseEntity.created(uri).body(planetResponse);

    }

    @GetMapping("/{slug}")
    public ResponseEntity showPlanet(@PathVariable String slug) {
        var restApiPlanetRequest = new RestApiPlanetRequest(slug);
        var search = searchPlanetRestAdapter.search(restApiPlanetRequest);
        if(search.getStatusCode().is2xxSuccessful()){
            if(search.getBody()!=null && search.getBody() !=null && search.getBody().getResposta().get(0) !=null){
                List<ApiPlanetResponse> resposta = search.getBody().getResposta();
                PlanetResponse response = planetMapper.mapToPlanetResponse(search.getBody().getResposta().get(0));;
               return ResponseEntity.ok(response);
            }
            return ResponseEntity.ok("Planet not found!!!");
        }
        return ResponseEntity.badRequest().build();
    }

}
