package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

import javax.annotation.processing.Generated;

// Anotações para JPA para a tabela do banco de dados
@Table(name = "medicos")
@Entity(name = "medicos")
@Getter // Anotação para o Lombok gerar os getters
@NoArgsConstructor // Anotação para o Lombok gerar o construtor sem argumentos que a JPA exige
@AllArgsConstructor // Anotação para o Lombok gerar o construtor com todos os campos
@EqualsAndHashCode(of = "id")
// Anotação para o Lombok gerar o Equals And Hash em cima do ID que foi passado como argumentos

public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gerar o ID automaticamente
    private long id;
    private String nome;
    private String email;

    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING) // Declarar que é Enum
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;


    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }


    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarEndereco(dados.endereco());
        }
    }
}
