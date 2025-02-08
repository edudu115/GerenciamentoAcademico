package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.util.ArrayList;

/**
 * Classe que representa uma disciplina acadêmica.
 * <p>
 * Uma disciplina é composta por um nome, sigla, ementa, carga horária, total de aulas,
 * e listas de turmas e avaliações associadas a ela.
 * </p>
 * 
 * <p>
 * Esta classe permite:
 * </P>
 * <ul>
 *   <li>Adicionar e remover turmas vinculadas à disciplina.</li>
 *   <li>Adicionar e remover avaliações associadas à disciplina.</li>
 *   <li>Consultar informações básicas da disciplina, como nome, sigla, ementa, carga horária e total de aulas.</li>
 * </ul>
 * 
 */
public class Disciplina {
    /**
     * Nome da disciplina.
     */
    private String nome;

    /**
     * Sigla identificadora da disciplina (ex: "MAT101").
     */
    private String sigla;

    /**
     * Ementa da disciplina, contendo uma descrição detalhada do conteúdo programático.
     */
    private String ementa;

    /**
     * Carga horária total da disciplina, em horas.
     */
    private int cargaHoraria;

    /**
     * Total de aulas previstas para a disciplina.
     */
    private int totalAulas;

    /**
     * Lista de turmas associadas à disciplina.
     */
    private ArrayList<Turma> turmas;

    /**
     * Lista de avaliações associadas à disciplina.
     */
    private ArrayList<Avaliacao> avaliacoes;

    /**
     * Constrói uma nova disciplina com os dados fornecidos.
     *
     * @param nome          Nome da disciplina
     * @param sigla         Sigla identificadora da disciplina
     * @param ementa        Ementa da disciplina
     * @param cargaHoraria  Carga horária total da disciplina
     * @param totalAulas    Total de aulas previstas para a disciplina
     */
    public Disciplina(String nome, String sigla, String ementa, int cargaHoraria, int totalAulas) {
        this.nome = nome;
        this.sigla = sigla;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.totalAulas = totalAulas;
        this.turmas = new ArrayList<Turma>();
        this.avaliacoes = new ArrayList<Avaliacao>();
    }

    /**
     * Retorna o nome da disciplina.
     *
     * @return Nome da disciplina
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a sigla da disciplina.
     *
     * @return Sigla da disciplina
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * Retorna a ementa da disciplina.
     *
     * @return Ementa da disciplina
     */
    public String getEmenta() {
        return ementa;
    }

    /**
     * Retorna a carga horária da disciplina.
     *
     * @return Carga horária da disciplina
     */
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * Retorna o total de aulas previstas para a disciplina.
     *
     * @return Total de aulas da disciplina
     */
    public int getTotalAulas() {
        return totalAulas;
    }

    /**
     * Retorna a lista de avaliações associadas à disciplina.
     *
     * @return Lista de avaliações
     */
    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    /**
     * Retorna a lista de turmas associadas à disciplina.
     *
     * @return Lista de turmas
     */
    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    /**
     * Adiciona uma avaliação à lista de avaliações da disciplina.
     *
     * @param avaliacao Avaliação a ser adicionada
     */
    public void addAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    /**
     * Adiciona uma turma à lista de turmas da disciplina.
     *
     * @param turma Turma a ser adicionada
     */
    public void addTurma(Turma turma) {
        this.turmas.add(turma);
    }

    /**
     * Remove uma avaliação da lista de avaliações da disciplina.
     *
     * @param avaliacao Avaliação a ser removida
     */
    public void rmAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.remove(avaliacao);
    }

    /**
     * Remove uma turma da lista de turmas da disciplina.
     *
     * @param turma Turma a ser removida
     */
    public void rmTurma(Turma turma) {
        this.turmas.remove(turma);
    }
}