package br.com.joaovictor.gestao_spy.DTO;


public class JogadorDTO {

    private String nome;
    private String posicao;
    private Long idade;


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

    
}
