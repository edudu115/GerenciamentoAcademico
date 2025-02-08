package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.time.LocalDate;

public class Administrator extends Usuario{
	public Usuario user;
	public Turma turma;
	public Disciplina disciplina;
	
	public Administrator() {
		super(12345, LocalDate.now() , "admin", "admin");
	}
	
	public void cadastrarProfessor(Integer prontuario, LocalDate dataNascimento ,String username, String password) {
		this.user = new Professor(prontuario, dataNascimento, username, password);
	}
	
	public void cadastrarAluno(Integer prontuario, LocalDate dataNascimento ,String username, String password) {
		this.user = new Estudante(prontuario, dataNascimento, username, password);
	}
	
	public void cadastrarTurma(String codigo, Disciplina disciplina, Professor professor) {
		this.turma = new Turma(codigo, disciplina, professor);
	}
	
	public void cadastrarDisciplina(String nome, String sigla, String ementa, int cargaHoraria, int totalAulas) {
		this.disciplina = new Disciplina(nome, sigla, ementa, cargaHoraria, totalAulas);
	}
	
}
