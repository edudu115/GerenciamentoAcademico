package br.edu.ifsp.inoo.gerenciamento.academico.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.ifsp.inoo.gerenciamento.academico.model.Administrator;
import br.edu.ifsp.inoo.gerenciamento.academico.model.Avaliacao;
import br.edu.ifsp.inoo.gerenciamento.academico.model.Disciplina;
import br.edu.ifsp.inoo.gerenciamento.academico.model.Estudante;
import br.edu.ifsp.inoo.gerenciamento.academico.model.Professor;
import br.edu.ifsp.inoo.gerenciamento.academico.model.Usuario;

public class Main {
    private static List<Usuario> usuarios = new ArrayList<>();

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
        } else {
            Usuario usuario = autenticarUsuario(username, senha);

            if (usuario instanceof Professor) {
                System.out.println("Login bem-sucedido como Professor.");
                menuProfessor((Professor) usuario, scanner);
            } else if (usuario instanceof Estudante) {
                System.out.println("Login bem-sucedido como Estudante.");
                menuEstudante((Estudante) usuario, scanner);
            } else {
                System.out.println("Usuário ou senha incorretos.");
            }
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
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o prontuário do professor: ");
                    Integer prontuarioProfessor = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    LocalDate dataProfessor = lerData(scanner, "Digite uma data (no formato yyyy-MM-dd): ");
                    System.out.print("Digite o username do professor: ");
                    String usernameProfessor = scanner.nextLine();
                    System.out.print("Digite a senha do professor: ");
                    String senhaProfessor = scanner.nextLine();
                    admin.cadastrarProfessor(prontuarioProfessor, dataProfessor, usernameProfessor, senhaProfessor);
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
                    scanner.nextLine();  // Consumir a nova linha
                    admin.cadastrarDisciplina(nomeDisciplina, siglaDisciplina, ementaDisciplina, cargaHoraria, opcao);
                    System.out.println("Disciplina cadastrada com sucesso.");
                    break;
                case 3:
                    System.out.print("Digite o username do estudante: ");
                    String usernameEstudante = scanner.nextLine();
                    System.out.print("Digite a senha do estudante: ");
                    String senhaEstudante = scanner.nextLine();
                    LocalDate dataEstudante = lerData(scanner, "Digite uma data (no formato yyyy-MM-dd): ");
                    System.out.print("Digite o prontuário do estudante: ");
                    int prontuarioEstudante = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    admin.cadastrarAluno(prontuarioEstudante, dataEstudante, usernameEstudante, senhaEstudante);
                    System.out.println("Estudante cadastrado com sucesso.");
                    break;
                case 4:
                    System.out.print("Digite o código da turma: ");
                    String codigoTurma = scanner.nextLine();
                    System.out.print("Escolha a disciplina para a turma (nome): ");
                    String nomeTurma = scanner.nextLine();

                    System.out.print("Escolha o professor para a turma (username): ");
                    String professorTurma = scanner.nextLine();

                    Disciplina disciplinaSelecionada = null;
                    for (Disciplina d : admin.getDisciplinas()) {
                        if (d.getNome().equalsIgnoreCase(nomeTurma)) {
                            disciplinaSelecionada = d;
                            break;
                        }
                    }

                    Professor professorSelecionado = null;
                    for (Professor p : admin.getProfessores()) {
                        if (p.getUsername().equalsIgnoreCase(professorTurma)) {
                            professorSelecionado = p;
                            break;
                        }
                    }
                    admin.cadastrarTurma(codigoTurma, disciplinaSelecionada, professorSelecionado);
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
                    System.out.print("Digite o código da turma: ");
                    String codigoTurma = scanner.nextLine();
                    System.out.print("Digite o nome da avaliação: ");
                    String nomeAvaliacao = scanner.nextLine();
                    System.out.print("Digite o peso da avaliação: ");
                    int peso = scanner.nextInt();
                    professor.cadastrarAvaliacao(codigoTurma, nomeAvaliacao, peso);
                    break;

                case 2:
                    System.out.print("Digite o código da turma: ");
                    codigoTurma = scanner.nextLine();
                    System.out.print("Digite o nome do estudante: ");
                    String nomeEstudante = scanner.nextLine();
                    System.out.print("Digite o nome da avaliação: ");
                    String nomeAvaliacaoNota = scanner.nextLine();
                    System.out.print("Digite a nota: ");
                    double nota = scanner.nextDouble();
                    scanner.nextLine();

                    Administrator admin = new Administrator();

                    Estudante estudanteSelecionado = null;
                    for (Estudante e : admin.getEstudantes()) {
                        if (e.getUsername().equalsIgnoreCase(nomeEstudante)) {
                            estudanteSelecionado = e;
                            break;
                        }
                    }

                    Avaliacao avaliacaoSelecionada = null;
                    for (Avaliacao a : professor.getAvaliacoes()) {
                        if (a.getNome().equalsIgnoreCase(nomeAvaliacaoNota)) {
                            avaliacaoSelecionada = a;
                            break;
                        }
                    }
                    professor.registrarNota(codigoTurma, estudanteSelecionado, avaliacaoSelecionada, nota);
                    System.out.println("Nota registrada com sucesso.");
                    break;

                case 3:
                    System.out.print("Digite o código da turma: ");
                    codigoTurma = scanner.nextLine();
                    System.out.print("Digite o nome do estudante: ");
                    nomeEstudante = scanner.nextLine();
                    System.out.print("Digite a quantidade de faltas: ");
                    int faltas = scanner.nextInt();
                    scanner.nextLine();

                    Administrator adm = new Administrator();
                    Estudante estudanteBuscado = null;
                    for (Estudante e : adm.getEstudantes()) {
                        if (e.getUsername().equalsIgnoreCase(nomeEstudante)) {
                            estudanteBuscado = e;
                            break;
                        }
                    }
                    professor.registrarFalta(codigoTurma, estudanteBuscado, faltas);
                    break;

                case 4:
                    System.out.print("Digite o código da turma: ");
                    codigoTurma = scanner.nextLine();
                    professor.gerarRelatorioAlunos(codigoTurma);
                    break;

                case 5:
                    System.out.print("Digite o código da turma: ");
                    codigoTurma = scanner.nextLine();
                    professor.consultarNota(codigoTurma);
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
                    estudante.consultarRendimento();
                    break;
                case 2:
                    System.out.println("Faltas gerais: " + estudante.getFaltasGerais());
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static LocalDate lerData(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String dataStr = scanner.nextLine();
            if (!dataStr.isEmpty()) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    return LocalDate.parse(dataStr, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido. Tente novamente.");
                }
            } else {
                System.out.println("A data não pode ser vazia. Tente novamente.");
            }
        }
    }

    private static Usuario autenticarUsuario(String username, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.autenticar(username, senha)) {
                return usuario;
            }
        }
        return null;
    }
}