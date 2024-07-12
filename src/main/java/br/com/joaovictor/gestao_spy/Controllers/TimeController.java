package br.com.joaovictor.gestao_spy.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaovictor.gestao_spy.Entities.Time;
import br.com.joaovictor.gestao_spy.Services.TimeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/times")
public class TimeController {
    
    @Autowired
    private TimeService timeService;

    @PostMapping("/cre")
    public String postMethodName(@RequestBody String entity) {
       
        
        return entity;
    }
    
    @PostMapping("/create")
    public List<Time> create(Time time){

        return timeService.create(time);

    }

    @GetMapping ("/list")
    public List<Time> list(){

        return timeService.list();

    }

    @DeleteMapping("/delete/{id}")
    public List<Time> delete(@PathVariable Long id){

        return timeService.delete(id);

    }
}
