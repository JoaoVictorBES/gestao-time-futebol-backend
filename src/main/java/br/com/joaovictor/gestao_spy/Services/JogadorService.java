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


        jogador = jogadorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Jogador não encontrado com o ID: " + id));
        
        Jogador jogador1 = new Jogador();

        jogador1.setNome(jogador.getNome());
        jogador1.setPosicao(jogador.getPosicao());
        jogador1.setIdade(jogador.getIdade());

        jogadorRepository.save(jogador1);
        
        return list();

    }

   
    public List<Jogador> list() {

        return jogadorRepository.findAll();
        
    }

    
    public List<Jogador> delete (Long id) {
       
        jogadorRepository.deleteById(id);
        System.out.println("Removido com sucesso");
        return list();

    }

    
    public Jogador  findById (Long id){

        Jogador jogador2 = jogadorRepository.findById(id).get();
        return jogador2;


    }


}
