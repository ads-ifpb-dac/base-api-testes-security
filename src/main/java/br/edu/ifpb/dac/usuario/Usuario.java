package br.edu.ifpb.dac.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Usuario implements UserDetails {

    private Long id;
    private String email;
    private String usuario;
    private String nomeCompleto;
    private String senha;

    public Usuario() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_account_seq")
    @SequenceGenerator(name = "user_account_seq", sequenceName = "user_account_seq", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false)
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String fullName) {
        this.nomeCompleto = fullName;
    }

    @Column(nullable = false)
    @JsonIgnore
    public String getSenha() {
        return senha;
    }

    public void setSenha(String password) {
        this.senha = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String username) {
        this.usuario = username;
    }

    @Override
    @Transient
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    @Transient
    @JsonIgnore
    public String getPassword() {
        return this.senha;
    }

    @Override
    @Transient
    @JsonIgnore
    public String getUsername() {
        return this.usuario;
    }

    @Override
    @Transient
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

}
