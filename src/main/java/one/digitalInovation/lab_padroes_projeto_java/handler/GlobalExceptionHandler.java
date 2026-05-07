package one.digitalInovation.lab_padroes_projeto_java.handler;


import one.digitalInovation.lab_padroes_projeto_java.exceptions.ClienteNaoExistException;
import one.digitalInovation.lab_padroes_projeto_java.exceptions.ClienteNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<String> tratarErro (ClienteNaoEncontradoException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(ClienteNaoExistException.class)
    public ResponseEntity<String> tratarListaVazia (ClienteNaoExistException ex) {

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(ex.getMessage());

    }

}
