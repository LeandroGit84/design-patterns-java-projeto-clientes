package one.digitalInovation.lab_padroes_projeto_java.exceptions;

public class ClienteNaoExistException extends RuntimeException{
    public ClienteNaoExistException() {
        super("Cliente Não existe ");
    }
}
