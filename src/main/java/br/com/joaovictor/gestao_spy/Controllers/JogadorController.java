package br.com.joaovictor.gestao_spy.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/jogadores")
public class JogadorController {
    
    @Autowired
    private JogadorService jogadorService;


    @SuppressWarnings("rawtypes")
    @PostMapping("/criar")
    List<Jogador> create(@RequestBody Jogador jogador){

        return jogadorService.create(jogador);

    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/list")
    List<Jogador> list(){

        return jogadorService.list();

    }

    @SuppressWarnings("rawtypes")
    @PutMapping("/update/{id}")
    List<Jogador> update(@RequestBody Jogador jogador, @PathVariable Long id){

        return jogadorService.update(jogador, id);

    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/delete/{id}")
    public List<Jogador> delete (@PathVariable Long id){

        return jogadorService.delete(id);

    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/findById/{id}")
    public Jogador findById (@RequestBody Jogador jogador, @PathVariable Long id){

        return jogadorService.findById(jogador, id);

    }


}
