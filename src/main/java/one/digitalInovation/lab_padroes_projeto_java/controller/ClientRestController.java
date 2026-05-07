package one.digitalInovation.lab_padroes_projeto_java.controller;



import one.digitalInovation.lab_padroes_projeto_java.model.Cliente;
import one.digitalInovation.lab_padroes_projeto_java.model.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import one.digitalInovation.lab_padroes_projeto_java.servico.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClientRestController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping

    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(
                clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {

        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        clienteService.excluir(id);
        return ResponseEntity.ok().build();
    }

}