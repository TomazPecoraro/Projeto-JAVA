package br.com.solarsync.javabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.solarsync.javabackend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
