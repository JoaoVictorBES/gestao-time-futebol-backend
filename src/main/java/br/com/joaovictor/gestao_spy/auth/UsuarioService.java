package br.com.joaovictor.gestao_spy.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario create (Usuario usuario){

        if (usuario.getRole() == null || usuario.getRole().isEmpty()) {
            usuario.setRole("USER"); 
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        return this.usuarioRepository.save(usuario);
        
    } 

}
