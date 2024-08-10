package br.com.joaovictor.gestao_spy.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    
    
    @PostMapping("/criar")
    public ResponseEntity <List<Time>> create(@RequestBody Time time){

        List<Time> times = timeService.create(time);
        return new ResponseEntity<>(times, HttpStatus.CREATED);

    }

    @GetMapping ("/list")
    public ResponseEntity<List<Time>> list(){

        List<Time> times = timeService.list();
        return new ResponseEntity<>(times, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Time>> delete(@PathVariable Long id){

        List<Time> times = timeService.delete(id);
        return new ResponseEntity<>(times, HttpStatus.OK);

    }
}
