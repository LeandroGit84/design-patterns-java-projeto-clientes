package one.digitalInovation.lab_padroes_projeto_java.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException(Long id) {
        super("Cliente não encontrado! " + id);
    }

}
