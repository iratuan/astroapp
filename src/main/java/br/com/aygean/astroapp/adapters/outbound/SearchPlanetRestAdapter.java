package br.com.aygean.astroapp.adapters.outbound;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.aygean.astroapp.adapters.inbound.request.RestApiPlanetRequest;
import br.com.aygean.astroapp.adapters.inbound.response.RestApiPlanetResponse;


@Service
@FeignClient(name = "planets", url = "${service.url}")
public interface SearchPlanetRestAdapter {

    @PostMapping("/planetas/obter")
    ResponseEntity<RestApiPlanetResponse> search(@RequestBody RestApiPlanetRequest request);
    
}
