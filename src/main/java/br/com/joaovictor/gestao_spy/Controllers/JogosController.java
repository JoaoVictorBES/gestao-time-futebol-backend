package br.com.joaovictor.gestao_spy.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/jogos")
public class JogosController {
    
    @Autowired
    private JogosService jogosService;

    @PostMapping("/create")
    public List<Jogo> create(@RequestBody Jogo jogo){

        jogosService.create (jogo);
        return list();
        

    }

    @GetMapping ("/list")
    public List<Jogo> list (){

        return jogosService.list();

    }

     @PutMapping("/update/{id}")
    public List<Jogo> update(@RequestBody Jogo jogo, @PathVariable Long id){

        return jogosService.update(jogo, id);

    }
}
