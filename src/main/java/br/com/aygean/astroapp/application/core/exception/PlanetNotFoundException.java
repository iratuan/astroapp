package br.com.aygean.astroapp.application.core.exception;

public class PlanetNotFoundException extends RuntimeException {
    public PlanetNotFoundException(String message){
        super(message);
    }
}
