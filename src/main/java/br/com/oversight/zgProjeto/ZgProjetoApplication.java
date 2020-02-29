package br.com.oversight.zgProjeto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.oversight.zgProjeto.domainServer.entity.PapelUsuario;
import br.com.oversight.zgProjeto.domainServer.entity.Usuario;
import br.com.oversight.zgProjeto.domainServer.entity.enumerable.EnumPapel;
import br.com.oversight.zgProjeto.domainServer.repository.UsuarioRepository;

@SpringBootApplication
public class ZgProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZgProjetoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UsuarioRepository usuarioRepository) {
		return args -> {
			initUsers(usuarioRepository);
		};
	}

	private void initUsers(UsuarioRepository usuarioRepository) {
		Usuario UsuarioTemp = usuarioRepository.findByEmail("admin@admin.com");
		if (UsuarioTemp == null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Usuario usuarioAdmin = new Usuario();
			usuarioAdmin.setNome("Administrador do Sistema");
			usuarioAdmin.setEmail("admin@admin.com");
			usuarioAdmin.setLogin("895.888.880-69");
			usuarioAdmin.setSenha(encoder.encode("123456"));
			usuarioAdmin.adicionarPapelUsuario(new PapelUsuario(EnumPapel.ADMIN));
			usuarioRepository.save(usuarioAdmin);
		}
	}
}
