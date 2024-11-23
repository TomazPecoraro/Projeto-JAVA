package br.com.solarsync.javabackend.dto;

import br.com.solarsync.javabackend.model.Regiao;
import br.com.solarsync.javabackend.model.TipoPropriedade;

public record EmpresaResponseDTO(
    Long id,
    String nome,
    String descricaoEmpresa,
    Long producaoEnergeticaKWH,
    String cnpj,
    String email,
    String telefone,
    Regiao regiaoCobertura,
    TipoPropriedade tipoPropriedade
) {
}
