package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.time.LocalDate;

public class Professor extends Usuario {
	
	public Professor(Integer prontuario, LocalDate dataNascimento ,String nome, String senha) {
		super(prontuario, dataNascimento, nome, senha);
	}
}
