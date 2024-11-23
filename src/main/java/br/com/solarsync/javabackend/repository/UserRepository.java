package br.com.solarsync.javabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.solarsync.javabackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  UserDetails findByLogin(String login);
}