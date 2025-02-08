package br.edu.ifpb.dac.security.dto;

public record LoginResponse(String token, Long expiresIn) {
}
