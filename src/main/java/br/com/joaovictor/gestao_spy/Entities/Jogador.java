package br.com.joaovictor.gestao_spy.Entities;


import br.com.joaovictor.gestao_spy.Entities.Enums.Mensalidade;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private Long idade;

    @Enumerated(EnumType.STRING)
    private Mensalidade mensalidade;
    
    public Jogador(){

    }

    public Jogador(Long id, String nome, String posicao, Long idade, Mensalidade mensalidade) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.idade = idade;
        this.mensalidade = mensalidade;
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

    public Long getIdade() {
        return idade;
    }
    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public Mensalidade getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Mensalidade mensalidade) {
        this.mensalidade = mensalidade;
    }

}
