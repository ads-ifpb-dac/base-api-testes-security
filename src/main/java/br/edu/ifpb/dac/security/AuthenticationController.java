package br.edu.ifpb.dac.security;

import br.edu.ifpb.dac.security.dto.LoginRequest;
import br.edu.ifpb.dac.security.dto.LoginResponse;
import br.edu.ifpb.dac.security.dto.RegistrarUsuarioRequest;
import br.edu.ifpb.dac.security.jwt.JwtService;
import br.edu.ifpb.dac.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody @Valid RegistrarUsuarioRequest registerUserDto) {
        Usuario usuarioRegistrado = authenticationService.registrar(registerUserDto);
        return ResponseEntity.ok(usuarioRegistrado);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> autenticar(@RequestBody @Valid LoginRequest loginUserDto) {
        Usuario usuarioAutenticado = authenticationService.autenticar(loginUserDto);
        String jwtToken = jwtService.generateToken(usuarioAutenticado);
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

}
