package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.util.ArrayList;

/**
 * Representa uma turma no sistema de gerenciamento acadêmico.
 * <p>
 * Cada turma está associada a uma disciplina, um professor responsável 
 * e uma lista de estudantes matriculados. Além disso, a turma possui 
 * avaliações e um controle de faltas dos estudantes.
 * </p>
 */
public class Turma {
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private int faltas;
    private ArrayList<Estudante> estudantes;
    private ArrayList<Avaliacao> avaliacoes;

    /**
     * Construtor para inicializar uma turma com código, disciplina e professor responsável.
     *
     * @param codigo     O código identificador da turma.
     * @param disciplina A disciplina associada à turma.
     * @param professor  O professor responsável pela turma.
     */
    public Turma(String codigo, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.estudantes = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    /**
     * Adiciona um estudante à turma.
     *
     * @param estudante O estudante a ser adicionado.
     */
    public void addEstudante(Estudante estudante) {
        estudantes.add(estudante);
    }

    /**
     * Adiciona uma avaliação à lista de avaliações da turma.
     *
     * @param avaliacao A avaliação a ser adicionada.
     */
    public void addAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    /**
     * Registra uma falta para um estudante específico.
     * A quantidade total de faltas da turma também é incrementada.
     *
     * @param estudante O estudante que recebeu a falta.
     */
    public void addFalta(Estudante estudante) {
        this.faltas++;
        estudante.addFaltasGerais();
    }

    /**
     * Registra uma nota para um estudante em uma avaliação específica.
     *
     * @param estudante O estudante que receberá a nota.
     * @param avaliacao A avaliação correspondente à nota.
     * @param nota      O valor da nota a ser registrada.
     */
    public void registrarNota(Estudante estudante, Avaliacao avaliacao, double nota) {
        avaliacao.setNota(nota);
    }

    /**
     * Calcula o rendimento de um estudante com base nas avaliações realizadas.
     * O rendimento é dado pela soma das notas ponderadas dividida por 100.
     *
     * @param estudante O estudante cujo rendimento será calculado.
     * @return O rendimento do estudante, variando de 0 a 1.
     */
    public double calcularRendimento(Estudante estudante) {
        double totalNotas = 0;

        for (Avaliacao avaliacao : avaliacoes) {
            totalNotas += avaliacao.getNota() * avaliacao.getPeso();
        }
        return totalNotas / 100;
    }

    /**
     * Calcula a porcentagem de presença de um estudante na turma.
     *
     * @param estudante O estudante cuja frequência será calculada.
     * @return A porcentagem de presença do estudante, de 0 a 100.
     */
    public double calcFaltaEstudante(Estudante estudante) {
        if (disciplina.getTotalAulas() > 0) {
            return ((double) (disciplina.getTotalAulas() - this.faltas) / disciplina.getTotalAulas()) * 100;
        } else {
            return 0;
        }
    }

    /**
     * Exibe no console os nomes de todos os estudantes matriculados na turma.
     */
    public void gerarAluno() {
        for (Estudante estudante : estudantes) {
            System.out.println(estudante.getUsername());
        }
    }

    /**
     * Obtém o número total de faltas registradas na turma.
     *
     * @return O número de faltas da turma.
     */
    public int getFaltas() {
        return this.faltas;
    }

    /**
     * Obtém o código identificador da turma.
     *
     * @return O código da turma.
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * Obtém a disciplina associada à turma.
     *
     * @return A disciplina da turma.
     */
    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    /**
     * Obtém o professor responsável pela turma.
     *
     * @return O professor da turma.
     */
    public Professor getProfessor() {
        return this.professor;
    }

    /**
     * Obtém a lista de estudantes matriculados na turma.
     *
     * @return A lista de estudantes da turma.
     */
    public ArrayList<Estudante> getEstudantes() {
        return this.estudantes;
    }

    /**
     * Obtém a lista de avaliações da turma.
     *
     * @return A lista de avaliações cadastradas na turma.
     */
    public ArrayList<Avaliacao> getAtividades() {
        return this.avaliacoes;
    }
}
