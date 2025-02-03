package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.time.LocalDate;

public class Estudante extends Usuario{
	
	public Estudante(Integer prontuario, LocalDate dataNascimento ,String username, String password) {
		super(prontuario, dataNascimento, username, password);
	}
}
