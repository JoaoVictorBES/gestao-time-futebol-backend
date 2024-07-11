package br.com.joaovictor.gestao_spy.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaovictor.gestao_spy.Entities.Jogo;
import br.com.joaovictor.gestao_spy.Repositories.JogoRepository;

@Service
public class JogosService {
    
    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> create(Jogo jogo){

        jogoRepository.save(jogo);
        return list();
    }

    public List<Jogo> list (){

        jogoRepository.findAll();
        return list();

    }

    public List<Jogo> update(Jogo jogo){

        jogoRepository.save(jogo);
        return list();

    }

    public List<Jogo> delete (Long id) {

        jogoRepository.deleteById(id);
        return list();

    }
}
