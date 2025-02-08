package br.edu.ifpb.dac.usuario;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarPorNomeUsuario(String nomeUsuario) {
        return usuarioRepository.findByUsuario(nomeUsuario).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

}
