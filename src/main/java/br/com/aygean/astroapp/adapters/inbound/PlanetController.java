package br.com.aygean.astroapp.adapters.inbound;

import java.util.ArrayList;

import br.com.aygean.astroapp.adapters.inbound.util.UrlUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.aygean.astroapp.adapters.inbound.mapper.PlanetMapper;
import br.com.aygean.astroapp.adapters.outbound.RestClientPlanetAdapter;
import br.com.aygean.astroapp.adapters.outbound.request.PlanetRequest;

/**
 * 
 * Este código é um controlador REST que lida com requisições relacionadas a
 * planetas. Ele possui dois métodos: listAllPlanets() e showPlanet(slug).
 * 
 * No método listAllPlanets(), ele cria um objeto PlanetRequest com condições
 * nulas, faz uma busca de planetas usando o RestClientPlanetAdapter, mapeia a
 * resposta para uma lista de planetas usando o PlanetMapper e retorna uma
 * resposta com a lista de planetas.
 * 
 * No método showPlanet(slug), ele cria um objeto PlanetRequest com o slug
 * fornecido na URL, faz uma busca de planetas usando o RestClientPlanetAdapter
 * e verifica se a resposta é bem-sucedida e não está vazia. Se for o caso,
 * mapeia a resposta para um planeta e retorna a resposta. Caso contrário,
 * retorna um status de BadRequest com uma mensagem informando que o planeta não
 * foi encontrado.
 */

@RestController
@RequestMapping("/api/planets")
public class PlanetController {

    @Autowired
    private RestClientPlanetAdapter searchPlanetRestAdapter;

    @Autowired
    private PlanetMapper planetMapper;

    @SuppressWarnings("null")
    @GetMapping
    public ResponseEntity<Object> listAllPlanets(HttpServletRequest request) {

        var PlanetRequest = new PlanetRequest(null);
        PlanetRequest.setCondicoes(null);
        var search = searchPlanetRestAdapter.search(PlanetRequest);

        var resposta = search.getBody().getResposta();
        var planetListResponse = new ArrayList<>();
        var baseUrl = UrlUtil.getBaseUrl(request);
        for (var p : resposta) {
            var pResponse = planetMapper.mapToPlanetResponse(p);
            pResponse.setUrl(baseUrl + "/api/planets/show/" + p.getSlug());
            planetListResponse.add(pResponse);
        }
        return ResponseEntity.ok(planetListResponse);
    }

    @SuppressWarnings("null")
    @GetMapping("/show/{slug}")
    public ResponseEntity<Object> showPlanet(@PathVariable String slug, HttpServletRequest request) {
        var PlanetRequest = new PlanetRequest(slug);
        var search = searchPlanetRestAdapter.search(PlanetRequest);
        if (search.getStatusCode().is2xxSuccessful()) {
            if (!search.getBody().getResposta().isEmpty()) {
                var planet = search.getBody().getResposta().get(0);
                var baseUrl = UrlUtil.getBaseUrl(request);
                var pResponse = planetMapper.mapToPlanetResponse(planet);
                pResponse.setUrl(baseUrl + "/api/planets/show/" + planet.getSlug());
                return ResponseEntity.ok(pResponse);
            }
        }
        /*
         * Se a resposta está vazia, considere como um BadRequest e forneça uma mensagem
         * adequada.
         */
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Planet not found!!!");
    }
}
