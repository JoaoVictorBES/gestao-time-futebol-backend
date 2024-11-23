package br.com.joaovictor.gestao_spy.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/cadastro")    
    public ResponseEntity<Usuario> create (@RequestBody Usuario usuario){

        this.usuarioService.create(usuario);
        return new ResponseEntity<Usuario> (usuario, HttpStatus.CREATED);

    }

}
