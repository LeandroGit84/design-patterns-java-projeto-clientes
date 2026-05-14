package one.digitalInovation.lab_padroes_projeto_java.service.serviceImpl;

import one.digitalInovation.lab_padroes_projeto_java.exceptions.ClienteNaoEncontradoException;
import one.digitalInovation.lab_padroes_projeto_java.model.Cliente;
import one.digitalInovation.lab_padroes_projeto_java.model.ClienteRepository;
import one.digitalInovation.lab_padroes_projeto_java.model.Endereco;
import one.digitalInovation.lab_padroes_projeto_java.model.EnderecoRepository;
import one.digitalInovation.lab_padroes_projeto_java.service.ClienteService;

import one.digitalInovation.lab_padroes_projeto_java.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(id));
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
        return cliente;
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

        Cliente clienteBd = clienteRepository.findById(id)
                .orElseThrow(()-> new ClienteNaoEncontradoException(id));

                cliente.setId(clienteBd.getId());
                salvarClienteComCep(cliente);
    }

    @Override
    public void deletar(Long id) {
        Cliente cliente = buscarPorId(id);
        clienteRepository.delete(cliente);

    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
