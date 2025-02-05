package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.time.LocalDate;
import java.util.*;

public class Professor extends Usuario {
    private List<Turma> turmas;
    
    public Professor(Integer prontuario, LocalDate dataNascimento, String nome, String senha) {
        super(prontuario, dataNascimento, nome, senha);
        this.turmas = new ArrayList<>();
    }
    
    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }
    
    public void cadastrarAvaliacao(String codigoTurma, String nomeAvaliacao, double peso) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigoTurma)) { // Corrigido para getCodigo()
                turma.cadastrarAvaliacao(nomeAvaliacao, peso);
                return;
            }
        }
        System.out.println("Turma não encontrada.");
    }
    
    public void registrarNota(String codigoTurma, Estudante estudante, double nota) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigoTurma)) {
                turma.registrarNota(estudante, nota);
                return;
            }
        }
        System.out.println("Turma não encontrada.");
    }
    
    public void registrarFalta(String codigoTurma, Estudante estudante, int quantidade) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigoTurma)) {
                turma.registrarFalta(estudante, quantidade);
                return;
            }
        }
        System.out.println("Turma não encontrada.");
    }
    
    public String gerarRelatorioAlunos(String codigoTurma) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigoTurma)) {
                return turma.gerarRelatorioAlunos();
            }
        }
        return "Turma não encontrada.";
    }
    
    public String gerarRelatorioTurma(String codigoTurma) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigoTurma)) {
                return turma.gerarRelatorioTurma();
            }
        }
        return "Turma não encontrada.";
    }
}