package br.com.solarsync.javabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.solarsync.javabackend.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
