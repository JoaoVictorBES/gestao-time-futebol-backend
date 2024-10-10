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


        Jogador jogadorExistente = jogadorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Jogador não encontrado com o ID: " + id));
        
        jogadorExistente.setNome(jogador.getNome());
        jogadorExistente.setPosicao(jogador.getPosicao());
        jogadorExistente.setIdade(jogador.getIdade());
        /*jogadorExistente.setMensalidade(jogador.getMensalidade());*/

        jogadorRepository.save(jogadorExistente);
        
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
    
    
    public Jogador adicionarGol(Long id) {
    	
        Jogador jogador = jogadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
        jogador.setGol(jogador.getGol() + 1);
        return jogadorRepository.save(jogador);
        
    }

    
    public Jogador adicionarAssistencia(Long id) {
    	
        Jogador jogador = jogadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
        jogador.setAssistencia(jogador.getAssistencia() + 1);
        return jogadorRepository.save(jogador);
        
    }
    
}
