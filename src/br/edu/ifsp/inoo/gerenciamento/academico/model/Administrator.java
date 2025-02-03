package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.time.LocalDate;

public class Administrator extends Usuario{
	public Usuario user;
	
	public Administrator() {
		super(12345, LocalDate.now() , "admin", "admin");
	}
	
	public void cadastrarProfessor(Integer prontuario, LocalDate dataNascimento ,String username, String password) {
		this.user = new Professor(prontuario, dataNascimento, username, password);
	}
	
	public void cadastrarAluno(Integer prontuario, LocalDate dataNascimento ,String username, String password) {
		this.user = new Estudante(prontuario, dataNascimento, username, password);
	}
}
