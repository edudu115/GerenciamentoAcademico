package br.edu.ifsp.inoo.gerenciamento.academico.model;

/**
 * Interface para autenticação de usuários no sistema acadêmico.
 * <p>
 * Essa interface define um contrato para classes que necessitam de autenticação, 
 * exigindo a implementação de um método para validar credenciais de acesso.
 * </p>
 */
public interface IAutenticavel {

    /**
     * Método para autenticar um usuário com base em seu nome de usuário e senha.
     *
     * @param username O nome de usuário do usuário tentando autenticar.
     * @param senha A senha correspondente ao nome de usuário.
     * @return {@code true} se a autenticação for bem-sucedida, {@code false} caso contrário.
     */
    boolean autenticar(String username, String senha);
}
