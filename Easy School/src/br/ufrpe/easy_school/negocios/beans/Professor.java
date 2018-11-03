package br.ufrpe.easy_school.negocios.beans;

import java.util.Scanner;

import br.ufrpe.easy_school.dados.RepositorioAluno;
import br.ufrpe.easy_school.dados.RepositorioProfessor;

public class Professor extends Pessoa {
	
	@SuppressWarnings("unused")
	private RepositorioProfessor repositorioProfessor;
	private RepositorioAluno repositorioAluno;
	
	

	public void setRepositorioProfessor(RepositorioProfessor repositorioProfessor) {
		this.repositorioProfessor = repositorioProfessor;
	}


	public void setRepositorioAluno(RepositorioAluno repositorioAluno) {
		this.repositorioAluno = repositorioAluno;
	}


	public Professor(String name, String id, String password) {
		super(name, id, password);
		// TODO Auto-generated constructor stub
	}
	
	
	public void mudarNota(Aluno aluno, int unidade, double nota) {
		aluno.buscarDisc(this).mudarNota(unidade, nota);
	}
	
	public void marcarFalta(Aluno aluno) {
		aluno.buscarDisc(this).marcarFalta();
	}
	
	public void removerFalta(Aluno aluno) {
		aluno.buscarDisc(this).removerFalta();
	}
	
	public void menuTeste() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Seus alunos");
		this.repositorioAluno.estudaCom(this);
		System.out.println("Digite o id do aluno o qual você deseja modificar a nota:");
		String aux1;
		aux1 = sc.nextLine();
		
		System.out.println("Agora digite a unidade (1 - 4):");
		int unidade = sc.nextInt();
		sc.nextLine();
		System.out.println("Agora digite a nota:");
		double nota = sc.nextDouble();
		
		
		
		this.repositorioAluno.acessarAluno(aux1).buscarDisc(this).mudarNota(unidade, nota);
		
		
		
	}

}
