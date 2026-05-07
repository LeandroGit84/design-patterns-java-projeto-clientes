package one.digitalInovation.lab_padroes_projeto_java.exceptions;

import one.digitalInovation.lab_padroes_projeto_java.model.Cliente;

public class ClienteDuplicadoException extends RuntimeException{
    public ClienteDuplicadoException(Cliente cliente) {
        super("Cliente já registrado: " + cliente);
    }
}
