package br.ufrpe.easy_school.negocios;

import java.util.Scanner;

import br.ufrpe.easy_school.dados.RepositorioAluno;
import br.ufrpe.easy_school.dados.RepositorioDisciplina;
import br.ufrpe.easy_school.dados.RepositorioProfessor;
import br.ufrpe.easy_school.dados.RepositorioResponsavel;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RepositorioAluno repositorioAluno = RepositorioAluno.getInstance();
		RepositorioProfessor repositorioProfessor = RepositorioProfessor.getInstance();
		RepositorioDisciplina repositorioDisciplina = RepositorioDisciplina.getInstance();
		RepositorioResponsavel repositorioResponsavel = RepositorioResponsavel.getInstance();
		
		Diretoria diretoriaTeste = new Diretoria("teste12", "0000", "00001", repositorioAluno, repositorioProfessor, repositorioDisciplina, repositorioResponsavel);
		
		int i = 0;
		Scanner sc = new Scanner(System.in);
		while(i == 0) {
			int j = 0;
			System.out.println("1 - Login diretoria:");
			System.out.println("2 - Login professor:");
			System.out.println("3 - Login aluno:");
			System.out.println("4 - Login responsável:");
			System.out.println("5 - Sair");
			j = sc.nextInt();
			sc.nextLine();
			String aux1;
			switch(j) {
				case 1:
					diretoriaTeste.menuLogin();
					break;
				case 2:
					
					System.out.println("Digite seu login (id)");
					aux1 = sc.nextLine();
					if(repositorioProfessor.existe(aux1) == true) {
						repositorioProfessor.acessarProfessor(aux1).menuLogin();
					}
					break;
				
				case 3:
					System.out.println("Digite sew login (Id)");
					aux1 = sc.nextLine();
					if(repositorioAluno.existe(aux1) == true) {
						repositorioAluno.acessarAluno(aux1).menuLogin();
					}
					break;
					
				case 4:
					System.out.println("Digite seu login (id)");
					aux1 = sc.nextLine();
					if(repositorioResponsavel.existe(aux1) == true) {
						repositorioResponsavel.acessarResponsavel(aux1).menuLogin();
					}
					break;
				case 5:
					i++;
					break;
				
				
				default:
					break;
			}
			
			
			
		}
		
		sc.close();


	}

}
