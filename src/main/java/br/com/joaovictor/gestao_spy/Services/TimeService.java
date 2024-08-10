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

        try {
            timeRepository.save(time);
            return list(); 
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar o time: " + e.getMessage(), e);
        }

    }

    public List<Time> list(){

        return timeRepository.findAll();
        

    }

    public List<Time> delete(Long id){

        if (timeRepository.existsById(id)) {
            timeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Time não encontrado com o ID: " + id);
        }

        return list();

    }
}
