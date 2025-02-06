package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estudante extends Usuario {
    private String nome;
    private String matricula;
    private List<Turma> turmasMatriculadas;

    public Estudante(Integer prontuario, LocalDate dataNascimento, String username, String password, String nome, String matricula) {
        super(prontuario, dataNascimento, username, password);
        this.nome = nome;
        this.matricula = matricula;
        this.turmasMatriculadas = new ArrayList<>();
    }

    public void matricularEmTurma(Turma turma) {
        if (!turmasMatriculadas.contains(turma)) {
            turmasMatriculadas.add(turma);
            turma.adicionarEstudante(this);
            System.out.println("Matriculado na turma: " + turma.getdisciplina());
        } else {
            System.out.println("Já está matriculado nesta turma.");
        }
    }

    public void consultarRendimento() {
        for (Turma turma : turmasMatriculadas) {
            System.out.println("Disciplina: " + turma.getdisciplina());
            System.out.println("Nota Final: " + turma.getNotaFinal(this));
            System.out.println("Faltas: " + turma.getFaltas(this));
            System.out.println("Situação: " + turma.getSituacao(this));
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Turma> getTurmasMatriculadas() {
        return turmasMatriculadas;
    }
}

