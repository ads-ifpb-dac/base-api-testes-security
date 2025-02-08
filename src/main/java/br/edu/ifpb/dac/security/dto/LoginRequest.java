package br.edu.ifpb.dac.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@Email(message = "O email não é válido") String email, @NotBlank String senha) {
}
