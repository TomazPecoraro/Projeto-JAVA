package br.com.solarsync.javabackend.dto;

import br.com.solarsync.javabackend.model.TipoServico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServicoRequestDTO(

    @NotBlank(message = "O título do serviço é obrigatório.") 
    String tituloServico,

    @NotBlank(message = "A descrição do serviço é obrigatória.") 
    String descricaoServico,

    @NotNull(message = "O ID do cliente é obrigatório.") 
    Long idCliente,

    @NotNull(message = "O ID da empresa é obrigatório.") 
    Long idEmpresa,

    @NotNull(message = "O tipo de serviço é obrigatório.") 
    TipoServico tipoServico
) {
}
