package br.com.joaovictor.gestao_spy.auth;



import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaovictor.gestao_spy.DTO.ChangePasswordDTO;
import br.com.joaovictor.gestao_spy.DTO.RecoveryTokenDTO;


@RestController
@RequestMapping("/api/recover")
public class RecoverPasswordController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordRecoveryService passwordRecoveryService;

    private static final Logger logger = LoggerFactory.getLogger(RecoverPasswordController.class);
   
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/recovery-password")
    public ResponseEntity<RecoveryTokenDTO> recoverPassword(@RequestBody EmailRequest emailRequest) {
        
        String email = emailRequest.getEmail();
        logger.info("Requisição recebida para recuperação de senha. Email: {}", email);
        String token = passwordRecoveryService.generateRecoveryToken(email);
        RecoveryTokenDTO dto = new RecoveryTokenDTO();
        dto.setToken(token);

        return ResponseEntity.ok(dto);
    }


    
    @PostMapping("/change-password")
    public ResponseEntity<Object> changePassword(@RequestParam String token, @RequestBody ChangePasswordDTO newPassword){

        Usuario usuario = usuarioRepository.findByRecoveryToken(token)
        .orElseThrow(() -> {
            logger.error("Token inválido ou não encontrado: {}", token);
            return new IllegalArgumentException("Token inválido");
        });

        if (newPassword == null || newPassword.getNewPassword().isBlank() ) {
            throw new IllegalArgumentException("Token ou nova senha não podem ser nulos ou vazios");
        }

        usuario.setPassword(passwordEncoder.encode(newPassword.getNewPassword()));
        usuarioRepository.save(usuario);

        return ResponseEntity.ok().build();

    }


    @PostMapping("/reset-password")
    public ResponseEntity<String> validateToken(@RequestParam String token) {
        
        logger.info("Tentativa de redefinição de senha com token: {}", token);
        
        if (token == null || token.isBlank() ) {
            throw new IllegalArgumentException("Token ou nova senha não podem ser nulos ou vazios");
        }

        Optional<Usuario> usuario1 = usuarioRepository.findByRecoveryToken(token);
        
        Usuario usuario = usuario1.get();

        if (usuario.getTokenExpiration().isBefore(LocalDateTime.now())) {
            logger.error("Token expirado para o usuário: {}", usuario.getEmail());
            throw new IllegalArgumentException("Token expirado");
        };
        

        return ResponseEntity.ok("Token validado.");
}   

}
