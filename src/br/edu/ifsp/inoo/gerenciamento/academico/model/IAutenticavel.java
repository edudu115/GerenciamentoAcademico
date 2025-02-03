package br.edu.ifsp.inoo.gerenciamento.academico.model;

public interface IAutenticavel {

	boolean autenticar(Integer prontuario, String senha);
}
