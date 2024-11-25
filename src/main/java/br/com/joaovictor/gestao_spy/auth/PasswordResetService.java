package br.com.joaovictor.gestao_spy.auth;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    private EmailService emailService;

    public void generatePasswordResetToken(String email) {
        Usuario usuario = usuarioRepository.findByUsername(email)
            .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setToken(token);
        resetToken.setUser(usuario);
        resetToken.setExpirationTime(LocalDateTime.now().plusHours(1));

        tokenRepository.save(resetToken);

        emailService.sendPasswordResetEmail(usuario.getUsername(), token);
    }

    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = tokenRepository.findByToken(token)
            .orElseThrow(() -> new IllegalArgumentException("Token inválido ou expirado"));
    
        if (resetToken.isExpired()) {
            throw new IllegalArgumentException("Token expirado");
        }
    
        Usuario usuario = resetToken.getUser();
        usuario.setPassword(passwordEncoder.encode(newPassword));
        usuarioRepository.save(usuario);
    
        tokenRepository.delete(resetToken); 
    }

}
