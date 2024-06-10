package com.ti.mpreventiva.Entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ti.mpreventiva.DTO.DadosAdicionarTecnico;
import com.ti.mpreventiva.DTO.DadosAtualizarTecnico;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;

@Table(name = "Tecnico")
@Entity(name = "tecnicos")
@EqualsAndHashCode(of = "id_tecnico")
public class Tecnico implements UserDetails  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tecnico;
	@NotBlank
    public String login;
    @NotBlank
    private String senha;
    
    private String nome;
    
    // Constructors
    public Tecnico () {
    	
    }
    
    public Tecnico(Long id_tecnico, String login, String senha, String nome) {
        this.id_tecnico = id_tecnico;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }
    
    public Tecnico (DadosAdicionarTecnico dados) {
    	this.id_tecnico = dados.id_tecnico();
        this.login = dados.login();
        this.senha = new BCryptPasswordEncoder().encode(dados.senha());
        this.nome = dados.nome();
    }
    
    public void AtualizarInformacoesTecnico(@Valid DadosAtualizarTecnico dados) {
		if (dados.login() != null) {
			this.login = dados.login();
		}
		if (dados.senha() != null) {
			this.senha = new BCryptPasswordEncoder().encode(dados.senha());
		}
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
	}

 // Getters and Setters

    public Long getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(Long id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}