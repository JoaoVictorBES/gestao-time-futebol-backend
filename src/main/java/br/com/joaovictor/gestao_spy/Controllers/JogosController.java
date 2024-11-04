package br.com.joaovictor.gestao_spy.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaovictor.gestao_spy.Entities.Evento;
import br.com.joaovictor.gestao_spy.Entities.Jogo;
import br.com.joaovictor.gestao_spy.Services.JogosService;

@RestController
@RequestMapping("api/jogos")
@CrossOrigin(origins = "*")
public class JogosController {
    
    @Autowired
    private JogosService jogosService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Jogo jogo){
    	
    	try {
	        List <Jogo> jogos =jogosService.create (jogo);
	        return new ResponseEntity<>(jogos, HttpStatus.CREATED);
    	} catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>("Erro ao criar jogo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    	}

    }

    @GetMapping ("/list")
    public ResponseEntity<?> list() {
    	
    	try {
	        List<Jogo> jogos = jogosService.list();
	        return new ResponseEntity<>(jogos, HttpStatus.OK);
    	} catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>("Erro ao listar os jogos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }

     @PreAuthorize("hasRole('ADMIN')")
     @PutMapping("/update/{id}")
     public ResponseEntity<?> update(@RequestBody Jogo jogo, @PathVariable Long id) {
       
    	try {
	        List<Jogo> jogos = jogosService.update(jogo, id);
	        return new ResponseEntity<>(jogos, HttpStatus.OK);
    	} catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>("Erro ao atualizar o jogo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }

    @PreAuthorize("hasRole('ADMIN')") 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

    	try {
    		List<Jogo> jogos = jogosService.delete(id);
    		return new ResponseEntity<>(jogos, HttpStatus.OK);
    	} catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>("Erro ao criar jogo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        
    	try {
    		Jogo jogo = jogosService.findById(id);
    		return new ResponseEntity<>(jogo, HttpStatus.OK);
    	} catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>("Erro ao encontrar o jogo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/eventos/{id}")
    public ResponseEntity<?> adicionarEvento(@PathVariable Long id, @RequestBody Evento evento) {
       
    	try {
    		Jogo jogoAtualizado = jogosService.adicionarEvento(id, evento);
    		return new ResponseEntity<>(jogoAtualizado, HttpStatus.OK);
    	} catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>("Erro ao adicionar evento: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }
}
