package br.com.joaovictor.testes_jogos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.joaovictor.gestao_spy.Entities.Jogo;
import br.com.joaovictor.gestao_spy.Repositories.JogoRepository;
import br.com.joaovictor.gestao_spy.Services.JogosService;

public class JogosServiceTest {

    @Mock
    private JogoRepository jogoRepository;

    @InjectMocks
    private JogosService jogosService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {

        Jogo jogo = new Jogo();
        when(jogoRepository.save(jogo)).thenReturn(jogo);
        when(jogoRepository.findAll()).thenReturn(Arrays.asList(jogo));

        List<Jogo> result = jogosService.create(jogo);

        assertEquals(1, result.size());
        verify(jogoRepository, times(1)).save(jogo);
        verify(jogoRepository, times(1)).findAll();

    }

    @Test
    public void testList() {

        Jogo jogo1 = new Jogo();
        Jogo jogo2 = new Jogo();
        when(jogoRepository.findAll()).thenReturn(Arrays.asList(jogo1, jogo2));

        List<Jogo> result = jogosService.list();

        assertEquals(2, result.size());
        verify(jogoRepository, times(1)).findAll();

    }

    @Test
    public void testUpdate() {
        
        Long id = 1L;
        Jogo jogo = new Jogo();
        Jogo jogoExistente = new Jogo();
        when(jogoRepository.findById(id)).thenReturn(Optional.of(jogoExistente));
        when(jogoRepository.save(jogoExistente)).thenReturn(jogoExistente);
        when(jogoRepository.findAll()).thenReturn(Arrays.asList(jogoExistente));

        List<Jogo> result = jogosService.update(jogo, id);

        assertEquals(1, result.size());
        verify(jogoRepository, times(1)).findById(id);
        verify(jogoRepository, times(1)).save(jogoExistente);
        verify(jogoRepository, times(1)).findAll();

    }

    @Test
    public void testUpdate_JogoNotFound() {

        Long id = 1L;
        Jogo jogo = new Jogo();
        when(jogoRepository.findById(id)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            jogosService.update(jogo, id);
        });

        assertEquals("Jogo não encontrado com o ID: " + id, exception.getMessage());
        verify(jogoRepository, times(1)).findById(id);
        verify(jogoRepository, times(0)).save(any(Jogo.class));
        verify(jogoRepository, times(0)).findAll();

    }

    @Test
    public void testDelete() {

        Long id = 1L;
        when(jogoRepository.existsById(id)).thenReturn(true);
        when(jogoRepository.findAll()).thenReturn(Arrays.asList());

        List<Jogo> result = jogosService.delete(id);

        assertEquals(0, result.size());
        verify(jogoRepository, times(1)).existsById(id);
        verify(jogoRepository, times(1)).deleteById(id);
        verify(jogoRepository, times(1)).findAll();

    }

    @Test
    public void testDelete_JogoNotFound() {

        Long id = 1L;
        when(jogoRepository.existsById(id)).thenReturn(false);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            jogosService.delete(id);
        });

        assertEquals("Jogo não encontrado com o ID: " + id, exception.getMessage());
        verify(jogoRepository, times(1)).existsById(id);
        verify(jogoRepository, times(0)).deleteById(anyLong());
        verify(jogoRepository, times(0)).findAll();
        
    }

}
