package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um estudante no sistema acadêmico.
 * <p>
 * Um estudante é um tipo de {@link Usuario} que pode se matricular em turmas, consultar seu rendimento
 * e ter seu número de faltas registrado.
 * </p>
 * 
 * <p>
 * Esta classe permite:
 * <ul>
 *   <li>Matricular o estudante em turmas.</li>
 *   <li>Consultar o rendimento do estudante em todas as turmas matriculadas.</li>
 *   <li>Registrar e consultar o número total de faltas do estudante.</li>
 * </ul>
 * </p>
 */
public class Estudante extends Usuario {
    /**
     * Lista de turmas em que o estudante está matriculado.
     */
    private List<Turma> turmasMatriculadas;

    /**
     * Número total de faltas do estudante.
     */
    private int faltasGerais;

    /**
     * Constrói um novo estudante com os dados fornecidos.
     *
     * @param prontuario      Número único de identificação do estudante
     * @param dataNascimento  Data de nascimento do estudante
     * @param username        Nome de usuário para acesso ao sistema
     * @param password        Senha para acesso ao sistema
     */
    public Estudante(Integer prontuario, LocalDate dataNascimento, String username, String password) {
        super(prontuario, dataNascimento, username, password);
        this.turmasMatriculadas = new ArrayList<>();
        this.faltasGerais = 0;
    }

    /**
     * Matricula o estudante em uma turma, caso ele ainda não esteja matriculado.
     *
     * @param turma Turma em que o estudante será matriculado
     */
    public void matricularEmTurma(Turma turma) {
        if (!turmasMatriculadas.contains(turma)) {
            turmasMatriculadas.add(turma);
            turma.addEstudante(this);
            System.out.println("Matriculado na turma: " + turma.getDisciplina().getNome());
        } else {
            System.out.println("Já está matriculado nesta turma.");
        }
    }

    /**
     * Exibe o rendimento do estudante em todas as turmas matriculadas.
     * <p>
     * O rendimento inclui a nota e a frequência do estudante em cada turma.
     * </p>
     */
    public void consultarRendimento() {
        for (Turma turma : turmasMatriculadas) {
            System.out.println("Disciplina: " + turma.getDisciplina().getNome());
            System.out.println("Rendimento: " + turma.calcularRendimento(this));
            System.out.println("Frequência: " + turma.calcFaltaEstudante(this) + "%");
        }
    }

    /**
     * Retorna o número total de faltas do estudante.
     *
     * @return Número total de faltas
     */
    public int getFaltasGerais() {
        return faltasGerais;
    }

    /**
     * Incrementa o número total de faltas do estudante.
     */
    public void addFaltasGerais() {
        this.faltasGerais++;
    }

    /**
     * Retorna a lista de turmas em que o estudante está matriculado.
     *
     * @return Lista de turmas matriculadas
     */
    public List<Turma> getTurmasMatriculadas() {
        return turmasMatriculadas;
    }
}