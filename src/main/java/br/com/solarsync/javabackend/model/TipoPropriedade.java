package br.com.solarsync.javabackend.model;

public enum TipoPropriedade {
    APARTAMENTO("Apartamento"),
    CASA("Casa"),
    CONDOMINIO("Condomínio"),
    CASA_GEMINADA("Casa Geminada"),
    KITNET("Kitnet"),
    LOFT("Loft"),
    VILA("Vila"),
    CHALE("Chalé"),
    DUPLEX("Duplex"),
    BANGALO("Bangalo"),
    GALPAO("Galpao");

    private final String descricao;

    TipoPropriedade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
