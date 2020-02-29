package br.com.oversight.zgProjeto.domainServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oversight.zgProjeto.domainServer.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Usuario findByLogin(String login);

    Usuario findByEmail(String string);
}
