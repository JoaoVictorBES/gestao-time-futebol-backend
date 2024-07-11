package br.com.joaovictor.gestao_spy.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaovictor.gestao_spy.Entities.Time;

public interface TimeRepository extends JpaRepository<Time, Long> {

}
