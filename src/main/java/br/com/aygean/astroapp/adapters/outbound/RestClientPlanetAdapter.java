package br.com.aygean.astroapp.adapters.outbound;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.aygean.astroapp.adapters.outbound.request.PlanetRequest;
import br.com.aygean.astroapp.adapters.outbound.response.ApiPlanetResponse;


@Service
@FeignClient(name = "planets", url = "${external.sistemasolar.api.url}")
public interface RestClientPlanetAdapter {

    @PostMapping("/planetas/obter")
    ResponseEntity<ApiPlanetResponse> search(@RequestBody PlanetRequest request);
    
}
