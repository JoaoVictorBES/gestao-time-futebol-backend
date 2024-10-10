package br.com.joaovictor.gestao_spy.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "eventos")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipoEvento;
	
	@ManyToOne
    @JoinColumn(name = "jogo_id", nullable = false)
	private Jogo jogo;
	
	@ManyToOne
    @JoinColumn(name = "jogador_id", nullable = false)
	private Jogador jogador;
	
	private Evento () {}
	
	private Evento (Long id, String tipoEvento, Jogo jogo, Jogador jogador) {
		this.id = id;
		this.tipoEvento = tipoEvento;
		this.jogo = jogo;
		this.jogador = jogador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	

	
}
