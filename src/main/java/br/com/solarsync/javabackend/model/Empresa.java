package br.com.solarsync.javabackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_SOLARSYNC_EMPRESA")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long id;

    @Column(name = "nm_empresa")
    private String nome;

    @Column(name = "descricao_empresa", columnDefinition = "TEXT")
    private String descricaoEmpresa;

    @Column(name = "producao_energetica_empresa")
    private Long producaoEnergeticaKWH;

    @Column(name = "cnpj_empresa")
    private String cnpj;

    @Column(name = "email_empresa")
    private String email;

    @Column(name = "telefone_empresa")
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "regiao_cobertura_empresa")
    private Regiao regiaoCobertura;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_propriedade_empresa")
    private TipoPropriedade tipoPropriedade;

    public Empresa() {
    }

    public Empresa(Long id, String nome, String descricaoEmpresa, Long producaoEnergeticaKWH, String cnpj, String email,
        String telefone, Regiao regiaoCobertura, TipoPropriedade tipoPropriedade) {
      this.id = id;
      this.nome = nome;
      this.descricaoEmpresa = descricaoEmpresa;
      this.producaoEnergeticaKWH = producaoEnergeticaKWH;
      this.cnpj = cnpj;
      this.email = email;
      this.telefone = telefone;
      this.regiaoCobertura = regiaoCobertura;
      this.tipoPropriedade = tipoPropriedade;
    }

    // Getters e Setters
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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



    public String getDescricaoEmpresa() {
        return descricaoEmpresa;
    }



    public void setDescricaoEmpresa(String descricaoEmpresa) {
        this.descricaoEmpresa = descricaoEmpresa;
    }



    public Long getProducaoEnergeticaKWH() {
        return producaoEnergeticaKWH;
    }



    public void setProducaoEnergeticaKWH(Long producaoEnergeticaKWH) {
        this.producaoEnergeticaKWH = producaoEnergeticaKWH;
    }

    @Override
    public String toString() {
      return "Empresa [id=" + id + ", nome=" + nome + ", descricaoEmpresa=" + descricaoEmpresa
          + ", producaoEnergeticaKWH=" + producaoEnergeticaKWH + ", cnpj=" + cnpj + ", email=" + email + ", telefone="
          + telefone + ", regiaoCobertura=" + regiaoCobertura + ", tipoPropriedade=" + tipoPropriedade + "]";
    }

    
}
