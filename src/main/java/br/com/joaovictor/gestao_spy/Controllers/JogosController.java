package br.com.joaovictor.gestao_spy.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaovictor.gestao_spy.Entities.Jogo;
import br.com.joaovictor.gestao_spy.Services.JogosService;

@RestController
@RequestMapping("/jogos")
public class JogosController {
    
    @Autowired
    private JogosService jogosService;

    public List<Jogo> create(Jogo jogo){

        return jogosService.create (jogo);

    }

    public List<Jogo> list (){

        return jogosService.list();

    }

    public List<Jogo> update(Jogo jogo, Long id){

        return jogosService.update(jogo, id);

    }
}
