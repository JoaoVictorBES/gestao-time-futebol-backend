package br.com.joaovictor.gestao_spy.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaovictor.gestao_spy.Entities.Usuario;

public interface LoginRepository extends JpaRepository<Usuario, Long> {
 
    public Optional<Usuario> findByUsername(String login);

}
