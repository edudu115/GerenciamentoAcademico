package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.time.LocalDate;

public abstract class Usuario implements IAutenticavel {
	private Integer prontuario;
	private LocalDate dataNascimento;
	private String username;
	private String password;
	
	public Usuario(Integer pront, LocalDate data, String name, String pass) {
		this.prontuario = pront;
		this.dataNascimento = data;
		this.username = name;
		this.password = pass;
	}
	
	@Override
	public boolean autenticar(String user, String pass) {
		boolean autenticador = false;
		if(this.getUsername().equals(user) && getPassword().equals(pass)) {
			autenticador = true;
		}
		return autenticador;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Integer getProntuario() {
		return prontuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
