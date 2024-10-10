package br.com.joaovictor.gestao_spy.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaovictor.gestao_spy.Entities.Jogador;
import br.com.joaovictor.gestao_spy.Entities.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long>{

	public Optional <Jogador> save (Long id);
	
}
