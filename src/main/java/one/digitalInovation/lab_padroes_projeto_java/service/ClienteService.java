package one.digitalInovation.lab_padroes_projeto_java.service;

import one.digitalInovation.lab_padroes_projeto_java.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    Cliente inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);


}
