package br.edu.ifsp.inoo.gerenciamento.academico.view;
import java.time.LocalDate;
import java.util.Scanner;

import br.edu.ifsp.inoo.gerenciamento.academico.model.Administrator;
import br.edu.ifsp.inoo.gerenciamento.academico.model.Estudante;
import br.edu.ifsp.inoo.gerenciamento.academico.model.Professor;



public class Main {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        
        Administrator admin = new Administrator();
        
        Professor professor = new Professor(1234, LocalDate.now(), "Ednilson", "mudar123");
        
        Estudante estudante = new Estudante(1234, LocalDate.now(), "Ednilson", "mudar123");

        
        System.out.print("Digite seu prontuario: ");
        String username = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        if (admin.autenticar(username, senha)) {
            System.out.println("Login bem-sucedido como Administrador.");
            menuAdministrator(admin, scanner);
        } else if (professor.autenticar(username, senha)) {
            System.out.println("Login bem-sucedido como Professor.");
            menuProfessor(professor, scanner);
        } else if (estudante.autenticar(username, senha)) {
            System.out.println("Login bem-sucedido como Estudante.");
            menuEstudante(estudante, scanner);
        } else {
            System.out.println("Usuário ou senha incorretos.");
        }
    }

    public static void menuAdministrator(Administrator admin, Scanner scanner) {
        
        while (true) {
            System.out.println("\nMenu Administrador:");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Disciplina");
            System.out.println("3. Cadastrar Estudante");
            System.out.println("4. Cadastrar Turma");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do professor: ");
                    String nomeProfessor = scanner.nextLine();
                    System.out.print("Digite o prontuário do professor: ");
                    String prontuarioProfessor = scanner.nextLine();
                    System.out.print("Digite o username do professor: ");
                    String usernameProfessor = scanner.nextLine();
                    System.out.print("Digite a senha do professor: ");
                    String senhaProfessor = scanner.nextLine();
                    Professor novoProfessor = new Professor(usernameProfessor, senhaProfessor, prontuarioProfessor);
                    admin.cadastrarProfessor(novoProfessor);
                    System.out.println("Professor cadastrado com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite o nome da disciplina: ");
                    String nomeDisciplina = scanner.nextLine();
                    System.out.print("Digite a sigla da disciplina: ");
                    String siglaDisciplina = scanner.nextLine();
                    System.out.print("Digite a ementa da disciplina: ");
                    String ementaDisciplina = scanner.nextLine();
                    System.out.print("Digite a carga horária da disciplina: ");
                    int cargaHoraria = scanner.nextInt();
                    scanner.nextLine();  
                    Disciplina novaDisciplina = new Disciplina(nomeDisciplina, siglaDisciplina, ementaDisciplina, cargaHoraria);
                    admin.cadastrarDisciplina(novaDisciplina);
                    System.out.println("Disciplina cadastrada com sucesso.");
                    break;
                case 3:
                    System.out.print("Digite o nome do estudante: ");
                    String nomeEstudante = scanner.nextLine();
                    System.out.print("Digite o prontuário do estudante: ");
                    String prontuarioEstudante = scanner.nextLine();
                    System.out.print("Digite o username do estudante: ");
                    String usernameEstudante = scanner.nextLine();
                    System.out.print("Digite a senha do estudante: ");
                    String senhaEstudante = scanner.nextLine();
                    Estudante novoEstudante = new Estudante(usernameEstudante, senhaEstudante, prontuarioEstudante);
                    admin.cadastrarEstudante(novoEstudante);
                    System.out.println("Estudante cadastrado com sucesso.");
                    break;
                case 4:
                    System.out.print("Digite o código da turma: ");
                    String codigoTurma = scanner.nextLine();
                    System.out.print("Escolha a disciplina para a turma (nome): ");
                    String nomeTurma = scanner.nextLine();
                    
                    Disciplina disciplinaTurma = new Disciplina(nomeTurma, "SIGLA", "EMENTA", 60); 
                    System.out.print("Escolha o professor para a turma (username): ");
                    String professorTurma = scanner.nextLine();
                    
                    Professor professorTurmaObj = new Professor(professorTurma, "1234", "P001"); 
                    Turma novaTurma = new Turma(codigoTurma, disciplinaTurma, professorTurmaObj);
                    admin.cadastrarTurma(novaTurma);
                    System.out.println("Turma cadastrada com sucesso.");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void menuProfessor(Professor professor, Scanner scanner) {
        
        while (true) {
            System.out.println("\nMenu Professor:");
            System.out.println("1. Cadastrar Avaliação");
            System.out.println("2. Registrar Nota");
            System.out.println("3. Registrar Frequência");
            System.out.println("4. Emitir Relatório de Alunos");
            System.out.println("5. Emitir Relatório de Turma");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    
                    System.out.println("Cadastro de Avaliação.");
                    break;
                case 2:
                    
                    System.out.println("Registro de Nota.");
                    break;
                case 3:
                    
                    System.out.println("Registro de Frequência.");
                    break;
                case 4:
                    
                    System.out.println("Emitindo Relatório de Alunos.");
                    break;
                case 5:
                    
                    System.out.println("Emitindo Relatório de Turma.");
                    break;
                case 6:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void menuEstudante(Estudante estudante, Scanner scanner) {
        
        while (true) {
            System.out.println("\nMenu Estudante:");
            System.out.println("1. Consultar Rendimento");
            System.out.println("2. Consultar Faltas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    
                    System.out.println("Consultando Rendimento.");
                    break;
                case 2:
                    
                    System.out.println("Consultando Faltas.");
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
