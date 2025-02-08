package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representa um professor no sistema de gerenciamento acadêmico.
 * <p>
 * Um professor é um tipo de usuário que pode gerenciar turmas, cadastrar 
 * avaliações, registrar notas e faltas, além de gerar relatórios de alunos.
 * </p>
 */
public class Professor extends Usuario {
    private ArrayList<Turma> turmas;
    private ArrayList<Avaliacao> avaliacoes;

    /**
     * Construtor para inicializar um professor com os dados básicos.
     *
     * @param prontuario      O número de identificação do professor.
     * @param dataNascimento  A data de nascimento do professor.
     * @param nome            O nome do professor.
     * @param senha           A senha de acesso do professor.
     */
    public Professor(Integer prontuario, LocalDate dataNascimento, String nome, String senha) {
        super(prontuario, dataNascimento, nome, senha);
        this.turmas = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    /**
     * Adiciona uma turma à lista de turmas do professor.
     *
     * @param turma A turma a ser adicionada.
     */
    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    /**
     * Cadastra uma nova avaliação para uma turma específica.
     *
     * @param codigoTurma  O código da turma onde a avaliação será cadastrada.
     * @param nomeAvaliacao O nome da avaliação.
     * @param peso         O peso da avaliação.
     */
    public void cadastrarAvaliacao(String codigoTurma, String nomeAvaliacao, int peso) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigoTurma)) {
                turma.addAvaliacao(new Avaliacao(nomeAvaliacao, peso));
                Avaliacao novaAvaliacao = new Avaliacao(nomeAvaliacao, peso);
                this.avaliacoes.add(novaAvaliacao);
                return;
            }
        }
        System.out.println("Turma não encontrada.");
    }

    /**
     * Registra uma nota para um estudante em uma avaliação específica dentro de uma turma.
     *
     * @param codigoTurma O código da turma onde a nota será registrada.
     * @param estudante   O estudante que receberá a nota.
     * @param avaliacao   A avaliação referente à nota.
     * @param nota        O valor da nota a ser registrada.
     */
    public void registrarNota(String codigoTurma, Estudante estudante, Avaliacao avaliacao, double nota) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigoTurma)) {
                turma.registrarNota(estudante, avaliacao, nota);
                return;
            }
        }
        System.out.println("Turma não encontrada.");
    }

    /**
     * Registra uma falta para um estudante em uma turma específica.
     *
     * @param codigoTurma O código da turma onde a falta será registrada.
     * @param estudante   O estudante que receberá a falta.
     * @param quantidade  O número de faltas a serem registradas.
     */
    public void registrarFalta(String codigoTurma, Estudante estudante, int quantidade) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigoTurma)) {
                turma.addFalta(estudante);
                return;
            }
        }
        System.out.println("Turma não encontrada.");
    }

    /**
     * Gera um relatório de alunos de uma turma específica.
     *
     * @param codigoTurma O código da turma cujo relatório será gerado.
     */
    public void gerarRelatorioAlunos(String codigoTurma) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigoTurma)) {
                turma.gerarAluno();
                return;
            }
        }
        System.out.println("Turma não encontrada.");
    }

    /**
     * Consulta as notas dos alunos de uma turma específica e exibe o rendimento.
     *
     * @param codigoTurma O código da turma cujas notas serão consultadas.
     */
    public void consultarNota(String codigoTurma) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigoTurma)) {
                System.out.println(turma.calcularRendimento(null));
                return;
            }
        }
        System.out.println("Turma não encontrada.");
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public ArrayList<Avaliacao> getAvaliacoes(){
        return avaliacoes;
    }
}