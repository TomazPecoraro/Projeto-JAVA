package br.com.solarsync.javabackend.dto;

import br.com.solarsync.javabackend.model.UserRole;

public record RegisterDTO(String login, String senha, UserRole role) {
}