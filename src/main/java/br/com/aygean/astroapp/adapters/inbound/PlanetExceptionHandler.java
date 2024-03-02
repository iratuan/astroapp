package br.com.aygean.astroapp.adapters.inbound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Este código é um manipulador de exceções para lidar com
 * IndexOutOfBoundsException ao acessar informações sobre planetas. Ele retorna
 * uma resposta com status de BAD_REQUEST e uma mensagem indicando que o planeta
 * não foi encontrado.
 * 
 * Explicação passo a passo do código:
 * 1. O pacote br.com.aygean.astroapp.adapters.inbound; é importado.
 * 2. As classes HttpStatus, ResponseEntity e ExceptionHandler do Spring
 * Framework são importadas.
 * 3. A anotação RestControllerAdvice é usada para indicar que a classe
 * PlanetExceptionHandler é um manipulador de exceções para controladores REST.
 * 4. A classe PlanetExceptionHandler possui um método
 * handleIndexOutOfBoundsException que é anotado com @ExceptionHandler para
 * lidar com a exceção IndexOutOfBoundsException.
 * 5. O método recebe um parâmetro do tipo IndexOutOfBoundsException e retorna
 * uma ResponseEntity com status BAD_REQUEST e uma mensagem indicando que o
 * planeta não foi encontrado.
 */

@RestControllerAdvice
public class PlanetExceptionHandler {
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<String> handleIndexOutOfBoundsException(IndexOutOfBoundsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Planet not found!!!");
    }
}
