package br.com.joaovictor.gestao_spy.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaovictor.gestao_spy.Entities.Time;
import br.com.joaovictor.gestao_spy.Repositories.TimeRepository;

@Service
public class TimeService {
    
    @Autowired
    private TimeRepository timeRepository;

    public List<Time> create(Time time){

        timeRepository.save(time);
        return list();

    }

    public List<Time> list(){

        timeRepository.findAll();
        return list();

    }

    public List<Time> delete(Long id){

        timeRepository.deleteById(id);
        return list();

    }
}
