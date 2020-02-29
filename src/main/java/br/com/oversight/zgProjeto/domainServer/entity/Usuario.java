package br.com.oversight.zgProjeto.domainServer.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario implements UserDetails {

	private static final long serialVersionUID = -3828363555235026397L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Informe o Nome.")
	@Length(min = 0, max = 255, message = "O limite do campo nome é de 255 caracteres.")
	@Column(nullable = false, length = 255)
	private String nome;

	@NotBlank(message = "Informe o CPF.")
	@CPF
	@Column(unique = true, nullable = false)
	private String login;

	@Column(nullable = false)
	@NotBlank(message = "Informe a senha")
	@Length(min = 0, max = 255, message = "O limite do campo senha é de 255 caracteres.")
	private String senha;

	@Column(unique = true, length = 255, nullable = false)
	@NotBlank(message = "Informe o E-mail.")
	@Email(message = "Informe um endereço de e-mail válido.")
	@Length(min = 0, max = 255, message = "O limite do campo e-mail é de 255 caracteres.")
	private String email;

	@Column(columnDefinition = "boolean default true", nullable = false)
	private boolean accountNonExpired = true;

	@Column(columnDefinition = "boolean default true", nullable = false)
	private boolean accountNonLocked = true;

	@Column(columnDefinition = "boolean default true", nullable = false)
	private boolean credentialsNonExpired = true;

	@Column(columnDefinition = "boolean default true", nullable = false)
	private boolean enabled = true;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new Date();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id")
	private Set<PapelUsuario> papeisUsuario = new HashSet<>();

	@PrePersist
	private void atualizarData() {
		setDataCriacao(new Date());
	}

	public void adicionarPapelUsuario(PapelUsuario papelUsuario) {
		papeisUsuario.add(papelUsuario);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthority = new ArrayList<>();
		papeisUsuario.forEach(p -> grantedAuthority.add(p.getPapel()));
		return grantedAuthority;
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
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
}