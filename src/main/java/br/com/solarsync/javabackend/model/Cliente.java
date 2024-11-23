package br.com.solarsync.javabackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_SOLARSYNC_CLIENTE")
public class Cliente {

  public Cliente() {
  }

  public Cliente(Long id, String nome, String descricaoCliente, Long consumoEnergeticoKWH, String email,
      String password, Regiao regiaoCobertura, TipoPropriedade tipoPropriedade) {
    this.id = id;
    this.nome = nome;
    this.descricaoCliente = descricaoCliente;
    this.consumoEnergeticoKWH = consumoEnergeticoKWH;
    this.email = email;
    this.password = password;
    this.regiaoCobertura = regiaoCobertura;
    this.tipoPropriedade = tipoPropriedade;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nm_cliente")
  private String nome;

  @Column(name = "descricao_cliente", columnDefinition = "TEXT")
  private String descricaoCliente;

  @Column(name = "consumo_energetico_cliente")
  private Long consumoEnergeticoKWH;

  @Column(name = "em_cliente")
  private String email;

  @Column(name = "pswd_cliente")
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "regiao_cobertura_cliente")
  private Regiao regiaoCobertura;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_propriedade_cliente")
  private TipoPropriedade tipoPropriedade;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Regiao getRegiaoCobertura() {
    return regiaoCobertura;
  }

  public void setRegiaoCobertura(Regiao regiaoCobertura) {
    this.regiaoCobertura = regiaoCobertura;
  }

  public TipoPropriedade getTipoPropriedade() {
    return tipoPropriedade;
  }

  public void setTipoPropriedade(TipoPropriedade tipoPropriedade) {
    this.tipoPropriedade = tipoPropriedade;
  }

  public String getDescricaoCliente() {
    return descricaoCliente;
  }

  public void setDescricaoCliente(String descricaoCliente) {
    this.descricaoCliente = descricaoCliente;
  }

  public Long getConsumoEnergeticoKWH() {
    return consumoEnergeticoKWH;
  }

  public void setConsumoEnergeticoKWH(Long consumoEnergeticoKWH) {
    this.consumoEnergeticoKWH = consumoEnergeticoKWH;
  }

  @Override
  public String toString() {
    return "Cliente [id=" + id + ", nome=" + nome + ", descricaoCliente=" + descricaoCliente + ", consumoEnergeticoKWH="
        + consumoEnergeticoKWH + ", email=" + email + ", regiaoCobertura=" + regiaoCobertura
        + ", tipoPropriedade=" + tipoPropriedade + "]";
  }

  

}