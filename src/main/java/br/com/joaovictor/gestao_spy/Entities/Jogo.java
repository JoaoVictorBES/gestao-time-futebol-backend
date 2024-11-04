package br.com.joaovictor.gestao_spy.Entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogo")
public class Jogo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data;
    private String local;
    private String time;
    private String hora;
    private String resultado;
    private int assistencias = 0;
    private int gols = 0;
    
    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evento> eventos = new ArrayList<>();

    public Jogo(){

    }

    public Jogo(String data, String local, String time, String hora, String resultado, int assistencias, int gols) {
        
        this.data = data;
        this.local = local;
        this.time = time;
        this.hora = hora;
        this.resultado = resultado;
        this.assistencias = assistencias;
        this.gols = gols;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	public void addEvento(Evento evento) {
        this.eventos.add(evento);
        evento.setJogo(this);
    }

    public void removeEvento(Evento evento) {
        this.eventos.remove(evento);
        evento.setJogo(null);
    }

	public int getAssistencia() {
		return assistencias;
	}

	public void setAssistencia(int assistencia) {
		this.assistencias = assistencia;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}
    
}
