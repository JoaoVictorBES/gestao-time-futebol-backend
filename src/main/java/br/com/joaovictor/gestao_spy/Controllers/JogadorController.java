package br.com.joaovictor.gestao_spy.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaovictor.gestao_spy.Entities.Jogador;
import br.com.joaovictor.gestao_spy.Services.JogadorService;

@RestController
@RequestMapping("api/jogadores")
@CrossOrigin(origins = "*")
public class JogadorController {
    
    @Autowired
    private JogadorService jogadorService;

    @PostMapping("/create")
    List<Jogador> create(@RequestBody Jogador jogador){

        return jogadorService.create(jogador);
        
    }

    
    @GetMapping("/list")
    List<Jogador> list(){

        return jogadorService.list();

    }

    
    @PutMapping("/update/{id}")
    public List<Jogador> update(@RequestBody Jogador jogador, @PathVariable Long id){

        return jogadorService.update(jogador, id);

    }

    
    @DeleteMapping("/delete/{id}")
    public List<Jogador> delete (@PathVariable Long id){
    	
        return jogadorService.delete(id);

    }

    
    @GetMapping("/findById/{id}")
    public ResponseEntity<Jogador> findById ( @PathVariable Long id){

    	Jogador jogador = jogadorService.findById(id);
        return new ResponseEntity<>(jogador, HttpStatus.OK);

    }
    
    @PutMapping("/{id}/gols")
    public ResponseEntity<Jogador> adicionarGol(@PathVariable Long id) {
    	
        Jogador jogador = jogadorService.adicionarGol(id);
        return new ResponseEntity<>(jogador, HttpStatus.OK);
        
    }
    
    @PutMapping("/{id}/assistencias")
    public ResponseEntity<Jogador> adicionarAssistencia(@PathVariable Long id) {
    	
        Jogador jogador = jogadorService.adicionarAssistencia(id);
        return new ResponseEntity<>(jogador, HttpStatus.OK);
        
    }


}
