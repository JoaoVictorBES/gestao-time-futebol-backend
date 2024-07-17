package br.com.joaovictor.gestao_spy.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaovictor.gestao_spy.Entities.Jogador;


public interface JogadorRepository  extends JpaRepository<Jogador, Long>{

    /*void update(Jogador jogador);

    void findAll(Jogador jogador);*/

}
