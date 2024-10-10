package br.com.joaovictor.gestao_spy.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joaovictor.gestao_spy.Entities.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

}
