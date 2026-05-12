package one.digitalInovation.lab_padroes_projeto_java.servico.implementar;

import one.digitalInovation.lab_padroes_projeto_java.model.Cliente;
import one.digitalInovation.lab_padroes_projeto_java.model.ClienteRepository;
import one.digitalInovation.lab_padroes_projeto_java.model.Endereco;
import one.digitalInovation.lab_padroes_projeto_java.model.EnderecoRepository;
import one.digitalInovation.lab_padroes_projeto_java.servico.ClienteService;
import one.digitalInovation.lab_padroes_projeto_java.servico.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    //TODO Singleton: Injetar os componentes do Spring com @Autowrid
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    //TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    }

    @Override
    public void inserir(Cliente cliente) {
        //FIXME Verificar se o Endereço do Cliente ja existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
                //FIXME Caso não exista, integrar com ViaCep e persistir o retorno.
        cliente.setEndereco(endereco);
        //FIXME Inserir Cliente, vinculando o Endereço (novo ou existente).
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        //FIXME Buscar Cliente por ID, caso exista.
        //FIXME Verificar se o Endereço do Cliente ja existe (pelo CEP).
        //FIXME Caso não exista, integrar com ViaCep e persistir o retorno.
        //FIXME Alterar Cliente, vinculando o Endereço (novo ou existente).

    }

    @Override
    public void deletar(Long id) {
        //FIXME Deletar Cliente por ID.

    }
}
