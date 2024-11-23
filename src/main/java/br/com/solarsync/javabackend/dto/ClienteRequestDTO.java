package br.com.solarsync.javabackend.dto;

import br.com.solarsync.javabackend.model.Regiao;
import br.com.solarsync.javabackend.model.TipoPropriedade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteRequestDTO(

    @NotBlank(message = "O nome é obrigatório.") @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.") String nome,

    @NotBlank(message = "A descrição é obrigatória.") String descricaoCliente,

    @NotNull(message = "Consuno Energetico nao pode ser nulo") Long consumoEnergeticoKWH,

    @NotBlank(message = "O email é obrigatório.") @Email(message = "Formato de email inválido.") String email,

    @NotBlank(message = "A senha é obrigatória.") @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres.") String password,

    @NotNull(message = "A região de cobertura é obrigatória.") Regiao regiaoCobertura,

    @NotNull(message = "O tipo de propriedade é obrigatório.") TipoPropriedade tipoPropriedade) {
}
