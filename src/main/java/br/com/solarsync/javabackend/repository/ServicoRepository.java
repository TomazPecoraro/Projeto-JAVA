package br.com.solarsync.javabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.solarsync.javabackend.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{
  
}
