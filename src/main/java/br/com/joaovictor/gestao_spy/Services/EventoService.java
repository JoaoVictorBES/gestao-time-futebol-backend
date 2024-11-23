package br.com.joaovictor.gestao_spy.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaovictor.gestao_spy.Entities.Evento;
import br.com.joaovictor.gestao_spy.Entities.Jogador;
import br.com.joaovictor.gestao_spy.Entities.Jogo;
import br.com.joaovictor.gestao_spy.Repositories.EventoRepository;
import br.com.joaovictor.gestao_spy.Repositories.JogadorRepository;
import br.com.joaovictor.gestao_spy.Repositories.JogoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private JogoRepository jogoRepository;

	@Autowired
	private JogadorRepository jogadorRepository;

	public Jogo adicionarEvento(Long id, Evento evento) {
    	
        Jogo jogo = jogoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Jogo não encontrado com o ID: " + id));
        
        evento.setJogo(jogo);
        jogo.addEvento(evento);

        if (evento.getTipoEvento().equalsIgnoreCase("gol")) {
        	Jogador jogador = evento.getJogador(); 
            jogador.incrementarGols(); 
            jogadorRepository.save(jogador);
        }

        eventoRepository.save(evento);
        return jogoRepository.save(jogo);
    }
	
}
