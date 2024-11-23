package br.com.solarsync.javabackend.dto;

import br.com.solarsync.javabackend.model.Regiao;
import br.com.solarsync.javabackend.model.TipoPropriedade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmpresaRequestDTO(

    @NotBlank(message = "O nome da empresa é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome da empresa deve ter entre 2 e 100 caracteres.")
    String nome,

    @NotBlank(message = "O CNPJ é obrigatório.")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter 14 dígitos.")
    String cnpj,

    @NotBlank(message = "A descricao não pode ser nula")
    String descricaoEmpresa,

    @NotNull(message = "A produção energetica não pode ser nula")
    Long producaoEnergeticaKWH,

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    String email,

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "\\d{10,15}", message = "O telefone deve conter entre 10 e 15 dígitos.")
    String telefone,

    @NotNull(message = "A região de cobertura é obrigatória.")
    Regiao regiaoCobertura,

    @NotNull(message = "O tipo de propriedade é obrigatório.")
    TipoPropriedade tipoPropriedade
) {
}
