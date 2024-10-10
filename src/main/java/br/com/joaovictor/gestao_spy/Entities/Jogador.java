package br.com.joaovictor.gestao_spy.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String posicao;
    private int idade;
    private int gol;
    private int assistencia;
    private String imagemUrl;
   
    
    public Jogador(){

    }

    public Jogador(Long id, String nome, String posicao, int idade, int gol, int assistencia, String imagemUrl) {
    	
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.idade = idade;
        this.gol = gol;
        this.assistencia = assistencia;
        this.imagemUrl = imagemUrl;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

	public int getAssistencia() {
		return assistencia;
	}

	public void setAssistencia(int assistencia) {
		this.assistencia = assistencia;
	}

	public int getGol() {
		return gol;
	}

	public void setGol(int gol) {
		this.gol = gol;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public void incrementarGols() {
	    this.gol++; 
	}


}
