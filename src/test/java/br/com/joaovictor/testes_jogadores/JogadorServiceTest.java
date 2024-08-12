package br.com.joaovictor.testes_jogadores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.joaovictor.gestao_spy.Entities.Jogador;
import br.com.joaovictor.gestao_spy.Repositories.JogadorRepository;
import br.com.joaovictor.gestao_spy.Services.JogadorService;

public class JogadorServiceTest {

    @Mock
    @Autowired
    private JogadorRepository jogadorRepository;

    @InjectMocks
    @Autowired
    private JogadorService jogadorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        
        Jogador jogador = new Jogador();
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        List<Jogador> jogadores = Arrays.asList(jogador1, jogador2);

        when(jogadorRepository.save(any(Jogador.class))).thenReturn(jogador);
        when(jogadorService.list()).thenReturn(jogadores);

        
        List<Jogador> result = jogadorService.create(jogador);

        
        assertEquals(jogadores, result);
        verify(jogadorRepository).save(jogador);
    }

    @Test
    void testUpdate() {
        Jogador jogador = new Jogador();
        jogador.setNome("João");

        Jogador jogadorExistente = new Jogador();
        jogadorExistente.setId(1L);
        jogadorExistente.setNome("Antigo Nome");

        when(jogadorRepository.findById(1L)).thenReturn(Optional.of(jogadorExistente));
        when(jogadorRepository.save(jogadorExistente)).thenReturn(jogadorExistente);
        when(jogadorRepository.findAll()).thenReturn(List.of(jogadorExistente));

        List<Jogador> result = jogadorService.update(jogador, 1L);

        verify(jogadorRepository, times(1)).findById(1L);
        verify(jogadorRepository, times(1)).save(jogadorExistente);
        verify(jogadorRepository, times(1)).findAll();

        assertEquals(1, result.size());
        assertEquals("João", result.get(0).getNome());
    }

    @Test
    void testList() {
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador());

        when(jogadorRepository.findAll()).thenReturn(jogadores);

        List<Jogador> result = jogadorService.list();

        verify(jogadorRepository, times(1)).findAll();
        assertEquals(1, result.size());
    }

    @Test
    void testDelete() {
        Jogador jogador = new Jogador();
        jogador.setId(1L);

        when(jogadorRepository.findAll()).thenReturn(new ArrayList<>());

        List<Jogador> result = jogadorService.delete(1L);

        verify(jogadorRepository, times(1)).deleteById(1L);
        verify(jogadorRepository, times(1)).findAll();
        assertTrue(result.isEmpty());
    }

    

    @Test
    void testFindById() {
        Jogador jogador = new Jogador();
        jogador.setId(1L);

        when(jogadorRepository.findById(1L)).thenReturn(Optional.of(jogador));

        Jogador result = jogadorService.findById(1L);

        verify(jogadorRepository, times(1)).findById(1L);
        assertEquals(1L, result.getId());
    }
}
