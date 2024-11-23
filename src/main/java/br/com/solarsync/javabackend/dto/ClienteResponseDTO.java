package br.com.solarsync.javabackend.dto;

import br.com.solarsync.javabackend.model.Regiao;
import br.com.solarsync.javabackend.model.TipoPropriedade;

public record ClienteResponseDTO(
    Long id,
    String nome,
    String descricaoCliente,
    Long consumoEnergeticoKWH,
    String email,
    String password,
    Regiao regiaoCobertura,
    TipoPropriedade tipoPropriedade) {
}
