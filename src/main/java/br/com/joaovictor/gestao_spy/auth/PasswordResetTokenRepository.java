package br.com.joaovictor.gestao_spy.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository {

    Optional<PasswordResetToken> findByToken(String token);

}
