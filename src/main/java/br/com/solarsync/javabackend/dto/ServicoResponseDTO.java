package br.com.solarsync.javabackend.dto;

import br.com.solarsync.javabackend.model.TipoServico;

public record ServicoResponseDTO(
    Long id,
    String tituloServico,
    String descricaoServico,
    Long idCliente,
    Long idEmpresa,
    TipoServico tipoServico
) {
}
