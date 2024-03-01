package br.com.aygean.astroapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.aygean.astroapp.adapters.inbound.SavePlanetAdapter;
import br.com.aygean.astroapp.application.core.usecase.SavePlanetUseCase;

@Configuration
public class BeanConfig {
    @Bean
    SavePlanetUseCase savePlanetUseCase(SavePlanetAdapter savePlanetAdapter){
        return  new SavePlanetUseCase(savePlanetAdapter);
    }
}
