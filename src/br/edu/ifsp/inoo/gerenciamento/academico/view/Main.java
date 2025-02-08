package br.edu.ifsp.inoo.gerenciamento.academico.view;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.edu.ifsp.inoo.gerenciamento.academico.model.Administrator;
import br.edu.ifsp.inoo.gerenciamento.academico.model.Estudante;
import br.edu.ifsp.inoo.gerenciamento.academico.model.Professor;
import br.edu.ifsp.inoo.gerenciamento.academico.model.Usuario;



public class Main {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        
        Administrator admin = new Administrator();
        
        System.out.println("--- Sistema de Gestão Acadêmico ---");
        System.out.print("Digite seu Usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite sua Senha: ");
        String senha = scanner.nextLine();

		if (admin.autenticar(username, senha)) {
            System.out.println("Login bem-sucedido como Administrador.");
            menuAdministrator(admin, scanner);
        }
    }

    public static void menuAdministrator(Administrator admin, Scanner scanner) {
        Usuario newUser;
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
                    System.out.print("Digite o prontuário do professor: ");
                    Integer prontuarioProfessor = scanner.nextInt();
                    System.out.print("Digite uma data (no formato yyyy-MM-dd):  ");
                    String dataNascimentoProfessor = scanner.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate dataProfessor = LocalDate.parse(dataNascimentoProfessor, formatter);
                    System.out.print("Digite o username do professor: ");
                    String usernameProfessor = scanner.nextLine();
                    System.out.print("Digite a senha do professor: ");
                    String senhaProfessor = scanner.nextLine();
                    System.out.println("Professor cadastrado com sucesso.");
                	newUser = new Professor(prontuarioProfessor, dataProfessor, usernameProfessor, senhaProfessor);
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
                    System.out.println("Estudante cadastrado com sucesso.");
                    break;
                case 4:
                    System.out.print("Digite o código da turma: ");
                    String codigoTurma = scanner.nextLine();
                    System.out.print("Escolha a disciplina para a turma (nome): ");
                    String nomeTurma = scanner.nextLine();
                    
                    System.out.print("Escolha o professor para a turma (username): ");
                    String professorTurma = scanner.nextLine();
                    
                    System.out.println("Turma cadastrada com sucesso.");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void menuProfessor(Usuario professor, Scanner scanner) {
        
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

    public static void menuEstudante(Usuario estudante, Scanner scanner) {
        
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
