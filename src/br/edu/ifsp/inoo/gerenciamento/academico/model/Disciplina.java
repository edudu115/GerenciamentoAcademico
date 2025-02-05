package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String sigla;
    private String ementa;
    private int cargaHoraria;
    private int totalAulas;
    private List<Avaliacao> avaliacoes; 

    
    public Disciplina(String nome, String sigla, String ementa, int cargaHoraria, int totalAulas) {
        this.nome = nome;
        this.sigla = sigla;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.totalAulas = totalAulas;
        this.avaliacoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getTotalAulas() {
        return totalAulas;
    }

    public void setTotalAulas(int totalAulas) {
        this.totalAulas = totalAulas;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao != null) {
            this.avaliacoes.add(avaliacao);
        }
    }

    
    public void removerAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.remove(avaliacao);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", ementa='" + ementa + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", totalAulas=" + totalAulas +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}