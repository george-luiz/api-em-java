package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank // Anotação para o campo não poder vir vazio e nem nullo
        String nome,
        @NotBlank
        @Email // Anotação indicando que o campo é um email
        String email,

        @NotNull
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") // Anotação para usar a expressão regular e indicar que é 4 ou 6 digitos
        String crm,

        @NotNull // Anotação para indicar que o campo não pode ser nulo o NotBlanck é apenas para String
        Especialidade especialidade,
        @NotNull
        @Valid // Anotação para indicar que é para validar o DadosEndereço com as Anotação dentro da classe
        DadosEndereco endereco) {

}
