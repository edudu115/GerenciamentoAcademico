package br.edu.ifsp.inoo.gerenciamento.academico.model;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private List<Estudante> estudantes = new ArrayList<>();
    private List<Avaliacao> atividades = new ArrayList<>();

    public Turma(String codigo, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public void adicionarEstudante(Estudante estudante) {
        estudantes.add(estudante);
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        atividades.add(avaliacao);
    }

    public double calcularRendimento(Estudante estudante) {
        double totalNotas = 0;
        double totalPesos = 0;

        for (Avaliacao avaliacao : atividades) {
            Double nota = professor.consultarNota(estudante, avaliacao);
            if (nota != null) {
                totalNotas += nota * avaliacao.getPeso();
                totalPesos += avaliacao.getPeso();
            }
        }

        if (totalPesos > 0) {
            return totalNotas / totalPesos;
        } else {
            return 0;
        }
    }

    public double calcularFrequencia(Estudante estudante) {
        int faltas = estudante.consultarFaltas();
        int totalAulas = disciplina.getTotalAulas();

        if (totalAulas > 0) {
            return ((double) (totalAulas - faltas) / totalAulas) * 100;
        } else {
            return 0;
        }
    }

    public String getCodigo() {
        return this.codigo;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public List<Estudante> getEstudantes() {
        return this.estudantes;
    }

    public List<Avaliacao> getAtividades() {
        return this.atividades;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
