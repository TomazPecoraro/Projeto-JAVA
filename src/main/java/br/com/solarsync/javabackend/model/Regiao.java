package br.com.solarsync.javabackend.model;

public enum Regiao {
  AMERICA_DO_NORTE("America do Norte"),
  AMERICA_DO_SUL("America do Sul"),
  EUROPA("Europa"),
  ASIA("Asia"),
  AFRICA("Africa"),
  OCEANIA("Oceania"),
  ORIENTE_MEDIO("Oriente Medio"),
  AMERICA_CENTRAL("America Central"),
  CARIBE("Caribe"),
  ANTARCTICA("Antarctica");

  private final String nomeRegiao;

  Regiao(String nomeRegiao) {
    this.nomeRegiao = nomeRegiao;
  }

  public String getDescricao() {
    return nomeRegiao;
  }
}
