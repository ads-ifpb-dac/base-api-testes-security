package br.edu.ifpb.dac.security.dto;

import br.edu.ifpb.dac.usuario.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record RegistrarUsuarioRequest(
        @NotBlank String nome,
        @NotBlank String usuario,
        @Email String email,
        @NotBlank @Length(min = 6) String senha
) {

    public Usuario toUserAccount() {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNomeCompleto(nome);
        novoUsuario.setUsuario(usuario);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);
        return novoUsuario;
    }

}
