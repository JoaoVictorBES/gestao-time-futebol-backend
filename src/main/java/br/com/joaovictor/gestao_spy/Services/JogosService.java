package br.com.joaovictor.gestao_spy.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaovictor.gestao_spy.Entities.Jogador;
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

        return jogoRepository.findAll();
        

    }

    public List<Jogo> update(Jogo jogo, Long id){

        Jogo jogoExistente = jogoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Jogo não encontrado com o ID: " + id));

        
        jogoExistente.setTime(jogo.getTime());
        jogoExistente.setData(jogo.getData());
        jogoExistente.setLocal(jogo.getLocal());
        

        jogoRepository.save(jogoExistente);
        return list(); 

    }

    public List<Jogo> delete (Long id) {

        if (jogoRepository.existsById(id)) {
            jogoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Jogo não encontrado com o ID: " + id);
        }
        return list(); 
    }
    
    public Jogo  findById (Long id){

    	return jogoRepository.findById(id)
    	        .orElseThrow(() -> new RuntimeException("Jogo não encontrado com o ID: " + id));


    }

}

