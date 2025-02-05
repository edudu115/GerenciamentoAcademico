package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estudante extends Usuario {
    private String nome;
    private String matricula;
    private List<Turma> turmasMatriculadas;
    private int faltas;

    public Estudante(Integer prontuario, LocalDate dataNascimento, String username, String password, String nome, String matricula) {
        super(prontuario, dataNascimento, username, password);
        this.nome = nome;
        this.matricula = matricula;
        this.turmasMatriculadas = new ArrayList<>();
        this.faltas = 0;
    }

    public void matricularEmTurma(Turma turma) {
        if (!turmasMatriculadas.contains(turma)) {
            turmasMatriculadas.add(turma);
            turma.adicionarEstudante(this);
            System.out.println("Matriculado na turma: " + turma.getDisciplina().getNome());
        } else {
            System.out.println("Já está matriculado nesta turma.");
        }
    }

    public void consultarRendimento() {
        for (Turma turma : turmasMatriculadas) {
            System.out.println("Disciplina: " + turma.getDisciplina().getNome());
            System.out.println("Rendimento: " + turma.calcularRendimento(this));
            System.out.println("Frequência: " + turma.calcularFrequencia(this) + "%");
        }
    }

    public int consultarFaltas() {
        return faltas;
    }

    public void registrarFalta() {
        this.faltas++;
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
