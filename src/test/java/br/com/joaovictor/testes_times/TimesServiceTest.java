package br.com.joaovictor.testes_times;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.joaovictor.gestao_spy.Entities.Time;
import br.com.joaovictor.gestao_spy.Repositories.TimeRepository;
import br.com.joaovictor.gestao_spy.Services.TimeService;

public class TimesServiceTest {

    @Mock
    private TimeRepository timeRepository;

    @InjectMocks
    private TimeService timeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {

        Time time = new Time();
        when(timeRepository.save(time)).thenReturn(time);
        when(timeRepository.findAll()).thenReturn(Arrays.asList(time));

        List<Time> result = timeService.create(time);

        assertEquals(1, result.size());
        verify(timeRepository, times(1)).save(time);
        verify(timeRepository, times(1)).findAll();

    }

    @Test
    public void testCreate_Exception() {

        Time time = new Time();
        when(timeRepository.save(time)).thenThrow(new RuntimeException("Erro ao salvar"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            timeService.create(time);
        });

        assertEquals("Erro ao criar o time: Erro ao salvar", exception.getMessage());
        verify(timeRepository, times(1)).save(time);
        verify(timeRepository, times(0)).findAll();

    }

    @Test
    public void testList() {

        Time time1 = new Time();
        Time time2 = new Time();
        when(timeRepository.findAll()).thenReturn(Arrays.asList(time1, time2));

        List<Time> result = timeService.list();

        assertEquals(2, result.size());
        verify(timeRepository, times(1)).findAll();

    }

    @Test
    public void testDelete() {

        Long id = 1L;
        when(timeRepository.existsById(id)).thenReturn(true);
        when(timeRepository.findAll()).thenReturn(Arrays.asList());

        List<Time> result = timeService.delete(id);

        assertEquals(0, result.size());
        verify(timeRepository, times(1)).existsById(id);
        verify(timeRepository, times(1)).deleteById(id);
        verify(timeRepository, times(1)).findAll();
        
    }

    @Test
    public void testDelete_TimeNotFound() {

        Long id = 1L;
        when(timeRepository.existsById(id)).thenReturn(false);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            timeService.delete(id);
        });

        assertEquals("Time não encontrado com o ID: " + id, exception.getMessage());
        verify(timeRepository, times(1)).existsById(id);
        verify(timeRepository, times(0)).deleteById(anyLong());
        verify(timeRepository, times(0)).findAll();
        
    }

}
