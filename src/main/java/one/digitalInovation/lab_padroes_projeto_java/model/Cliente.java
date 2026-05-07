package one.digitalInovation.lab_padroes_projeto_java.model;

import jakarta.persistence.*;

@Entity
public class Cliente {

    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

>>>>>>> bf460ff (Implemantações de metodos (buscarPorId, inserir))
    @ManyToOne
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
