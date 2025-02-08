package br.edu.ifsp.inoo.gerenciamento.academico.model;

public interface IAutenticavel {

	boolean autenticar(String username, String senha);
}
