package br.edu.ifpb.dac.security;

import br.edu.ifpb.dac.security.dto.LoginRequest;
import br.edu.ifpb.dac.security.dto.RegistrarUsuarioRequest;
import br.edu.ifpb.dac.usuario.Usuario;
import br.edu.ifpb.dac.usuario.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UsuarioRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UsuarioRepository userRepository, AuthenticationManager authenticationManager,
                                 PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registrar(RegistrarUsuarioRequest input) {
        Usuario usuario = input.toUserAccount();
        usuario.setSenha(passwordEncoder.encode(input.senha()));
        return userRepository.save(usuario);
    }

    public Usuario autenticar(LoginRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.senha()));
        return userRepository.findByEmail(input.email()).orElseThrow();
    }

}
