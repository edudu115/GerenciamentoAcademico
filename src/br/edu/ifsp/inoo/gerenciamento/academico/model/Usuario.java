package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.time.LocalDate;

/**
 * Classe abstrata que representa um usuário no sistema de gerenciamento acadêmico.
 * <p>
 * Cada usuário possui um prontuário, uma data de nascimento, um nome de usuário 
 * e uma senha para autenticação no sistema.
 * </p>
 */
public abstract class Usuario implements IAutenticavel {
    private Integer prontuario;
    private LocalDate dataNascimento;
    private String username;
    private String password;

    /**
     * Construtor para inicializar um usuário com prontuário, data de nascimento, 
     * nome de usuário e senha.
     *
     * @param pront O número do prontuário do usuário.
     * @param data A data de nascimento do usuário.
     * @param name O nome de usuário.
     * @param pass A senha do usuário.
     */
    public Usuario(Integer pront, LocalDate data, String name, String pass) {
        this.prontuario = pront;
        this.dataNascimento = data;
        this.username = name;
        this.password = pass;
    }

    /**
     * Realiza a autenticação do usuário comparando o nome de usuário e a senha fornecidos 
     * com os dados armazenados.
     *
     * @param user O nome de usuário fornecido para autenticação.
     * @param pass A senha fornecida para autenticação.
     * @return {@code true} se as credenciais estiverem corretas, {@code false} caso contrário.
     */
    @Override
    public boolean autenticar(String user, String pass) {
        boolean autenticador = false;
        if (this.getUsername().equals(user) && getPassword().equals(pass)) {
            autenticador = true;
        }
        return autenticador;
    }

    /**
     * Obtém a data de nascimento do usuário.
     *
     * @return A data de nascimento do usuário.
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Obtém o número do prontuário do usuário.
     *
     * @return O prontuário do usuário.
     */
    public Integer getProntuario() {
        return prontuario;
    }

    /**
     * Obtém o nome de usuário.
     *
     * @return O nome de usuário.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define um novo nome de usuário.
     *
     * @param username O novo nome de usuário.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return A senha do usuário.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define uma nova senha para o usuário.
     *
     * @param password A nova senha do usuário.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
