package br.com.joaovictor.gestao_spy.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaovictor.gestao_spy.Entities.Jogador;
import br.com.joaovictor.gestao_spy.Repositories.JogadorRepository;

@Service
public class JogadorService {
    
    @Autowired
    public JogadorRepository jogadorRepository;

    public List<Jogador> create(Jogador jogador){
        
        jogadorRepository.save(jogador);
        return list();

    }

    public List<Jogador> update(Jogador jogador, Long id){

        jogadorRepository.save(jogador);
        return list();

    }

    public List<Jogador> list() {

        jogadorRepository.findAll();
        return list();
    }

    public List<Jogador> delete (Long id) {
       
        jogadorRepository.deleteById(id);
        System.out.println("Removido com sucesso");
        return list();

    }

    public Long findById (Long id){

        jogadorRepository.findById(id);
        return id;

    }


}
