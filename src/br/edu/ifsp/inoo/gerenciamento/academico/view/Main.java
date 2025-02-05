package br.edu.ifsp.inoo.gerenciamento.academico.view;
import java.util.Scanner;

import br.edu.ifsp.inoo.gerenciamento.academico.model.Administrator;

public class Main {

	public static void main(String[] args) {
		
		    private static Scanner scanner = new Scanner(System.in);
		    private static Administrator admin = new Administrator();
		    
		 
		        while (true) {
		            System.out.println("Bem_vindo ADMIN");
		            System.out.println("1. Cadastrar Professor");
		            System.out.println("2. Cadastrar Disciplina");
		            System.out.println("3. Cadastrar Turma");
		            System.out.println("4. Cadastrar Estudante");
		            System.out.println("5. Sair");
		            System.out.print("Escolha uma opção: ");
		            
		            int opcao = scanner.nextInt();
		            scanner.nextLine(); 

		            switch (opcao) {
		                case 1:
		                    cadastrarProfessor();
		                    break;
		                case 2:
		                    cadastrarDisciplina();
		                    break;
		                case 3:
		                    cadastrarTurma();
		                    break;
		                case 4:
		                    cadastrarEstudante();
		                    break;
		                case 5:
		                    System.out.println("Saindo...");
		                    return;
		                default:
		                    System.out.println("Opção inválida!");
		            }
		        }
		    }


	}

}
