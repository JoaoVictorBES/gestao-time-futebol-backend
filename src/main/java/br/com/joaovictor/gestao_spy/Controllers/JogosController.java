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

import br.com.joaovictor.gestao_spy.Entities.Jogo;
import br.com.joaovictor.gestao_spy.Services.JogosService;

@RestController
@RequestMapping("api/jogos")
@CrossOrigin(origins = "*")
public class JogosController {
    
    @Autowired
    private JogosService jogosService;

    @PostMapping("/create")
    public ResponseEntity<List<Jogo>> create(@RequestBody Jogo jogo){

        List <Jogo> jogos =jogosService.create (jogo);
        return new ResponseEntity<>(jogos, HttpStatus.CREATED);
        

    }

    @GetMapping ("/list")
    public ResponseEntity<List<Jogo>> list() {

        List<Jogo> jogos = jogosService.list();
        return new ResponseEntity<>(jogos, HttpStatus.OK);

    }

     @PutMapping("/update/{id}")
     public ResponseEntity<List<Jogo>> update(@RequestBody Jogo jogo, @PathVariable Long id) {
       
        List<Jogo> jogos = jogosService.update(jogo, id);
        return new ResponseEntity<>(jogos, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Jogo>> delete(@PathVariable Long id) {

        List<Jogo> jogos = jogosService.delete(id);
        return new ResponseEntity<>(jogos, HttpStatus.OK);
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Jogo> findById(@PathVariable Long id) {
        Jogo jogo = jogosService.findById(id);
        return new ResponseEntity<>(jogo, HttpStatus.OK);
    }
}
