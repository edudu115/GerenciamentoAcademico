package br.edu.ifsp.inoo.gerenciamento.academico.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um administrador do sistema acadêmico, responsável por gerenciar
 * o cadastro de usuários (professores e alunos), turmas e disciplinas.
 * <p>
 * Esta classe herda de {@link Usuario} e possui funcionalidades específicas para operações administrativas.
 * </p>
 * 
 * @see Usuario
 * @see Professor
 * @see Estudante
 * @see Turma
 * @see Disciplina
 */
public class Administrator extends Usuario {
    /**
     * Referência ao último usuário cadastrado pelo administrador (Professor ou Estudante).
     */
    public Usuario user;
    
    /**
     * Referência à última turma cadastrada pelo administrador.
     */
    public Turma turma;
    
    /**
     * Referência à última disciplina cadastrada pelo administrador.
     */
    public Disciplina disciplina;

    /**
     * Constrói um administrador com credenciais padrão:
     * <ul>
     *   <li>Prontuário: 12345</li>
     *   <li>Data de nascimento: data atual</li>
     *   <li>Username: "admin"</li>
     *   <li>Password: "admin"</li>
     * </ul>
     */
        private List<Usuario> usuarios;
        private List<Turma> turmas;
        private List<Disciplina> disciplinas;
        private List<Professor> professores;

    public Administrator() {
        super(12345, LocalDate.now(), "admin", "admin");
        this.usuarios = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.professores = new ArrayList<>();
    }

    /**
     * Cadastra um novo professor no sistema.
     * 
     * @param prontuario       Número único de identificação do professor
     * @param dataNascimento   Data de nascimento do professor
     * @param username         Nome de usuário para acesso ao sistema
     * @param password         Senha para acesso ao sistema
     * @see Professor
     */
    public void cadastrarProfessor(Integer prontuario, LocalDate dataNascimento, String username, String password) {
        Professor professor = new Professor(prontuario, dataNascimento, username, password);
        this.professores.add(professor);
        this.usuarios.add(professor);
    }

    /**
     * Cadastra um novo aluno no sistema.
     * 
     * @param prontuario       Número único de identificação do aluno
     * @param dataNascimento   Data de nascimento do aluno
     * @param username         Nome de usuário para acesso ao sistema
     * @param password         Senha para acesso ao sistema
     * @see Estudante
     */
    public void cadastrarAluno(Integer prontuario, LocalDate dataNascimento, String username, String password) {
        Estudante estudante = new Estudante(prontuario, dataNascimento, username, password);
        this.usuarios.add(estudante);
    }

    /**
     * Cria uma nova turma associada a uma disciplina e professor.
     * 
     * @param codigo      Código identificador da turma
     * @param disciplina  Disciplina vinculada à turma
     * @param professor   Professor responsável pela turma
     * @see Turma
     */
    public void cadastrarTurma(String codigo, Disciplina disciplina, Professor professor) {
        Turma novaTurma = new Turma(codigo, disciplina, professor);
        this.turmas.add(novaTurma);
    }

    /**
     * Cria uma nova disciplina acadêmica.
     * 
     * @param nome           Nome completo da disciplina
     * @param sigla          Sigla identificadora (ex: "MAT101")
     * @param ementa         Descrição detalhada do conteúdo programático
     * @param cargaHoraria   Carga horária total em horas
     * @param totalAulas     Quantidade total de aulas previstas
     * @see Disciplina
     */
    public void cadastrarDisciplina(String nome, String sigla, String ementa, int cargaHoraria, int totalAulas) {
        Disciplina novaDisciplina = new Disciplina(nome, sigla, ementa, cargaHoraria, totalAulas);
        this.disciplinas.add(novaDisciplina);
    }

    // Métodos para recuperar as listas
    public List<Disciplina> getListaDisciplinas() {
        return disciplinas;
    }

    public List<Professor> getListaProfessores() {
        return professores;
    }

    public List<Turma> getListaTurmas() {
        return turmas;
    }
}