package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank // Anotação para o campo não poder vir vazio e nem nullo
        String logradouro,
        @NotBlank // Anotação para o campo não poder vir vazio e nem nullo
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}") // Anotação para usar a expressão regular e indicar que é 4 ou 6 digitos
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        String complemento,

        String numero) {

}
