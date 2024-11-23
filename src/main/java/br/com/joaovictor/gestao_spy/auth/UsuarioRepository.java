package br.com.joaovictor.gestao_spy.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findByUsername(String username);

}
