package br.com.joaovictor.gestao_spy.auth;

import java.time.LocalDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PasswordRecoveryService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final Logger logger = LoggerFactory.getLogger(PasswordRecoveryService.class);

    public String generateRecoveryToken(String email) {
        
        logger.info("Gerando token de recuperação para o email: {}", email);

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O e-mail não pode ser nulo ou vazio");
        }

        Usuario usuario = usuarioRepository.findByEmail(email)
        .orElseThrow(() -> {
            logger.error("Usuário com o email {} não encontrado", email);
            return new UsernameNotFoundException("Email não encontrado");
        });

        String token = UUID.randomUUID().toString();

        usuario.setRecoveryToken(token);
        usuario.setTokenExpiration(LocalDateTime.now().plusHours(1));
        usuarioRepository.save(usuario);

        logger.info("Token salvo no banco de dados para o email {}", email);
        return token;

        //String resetLink = "http://localhost:4200/reset-password?token=" + token;
        //emailService.sendEmail(email, "Recuperação de senha", "Clique no link para redefinir sua senha. " + resetLink);
    }

}
