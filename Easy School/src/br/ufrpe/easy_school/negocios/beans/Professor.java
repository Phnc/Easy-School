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
	
	
	public void menuNota() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Seus alunos:");
		System.out.println("");
		System.out.println("=============================");
		this.repositorioAluno.estudaCom(this);
		
		System.out.println("");
		System.out.println("=============================");
		System.out.println("Digite o id do aluno o qual você quer modificar a nota:");
		String aux;
		int unidade;
		double nota;
		aux = sc.nextLine();
		System.out.println("Digite a unidade:");
		unidade = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite a nota:");
		nota = sc.nextDouble();
		sc.nextLine();
		this.repositorioAluno.acessarAluno(aux).buscarDisc(this).mudarNota(unidade, nota);
	}
	
	public void menuFaltas() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Seus alunos:");
		System.out.println("");
		System.out.println("=============================");
		this.repositorioAluno.estudaCom(this);
		
		System.out.println("");
		System.out.println("=============================");
		System.out.println("Digite o id do aluno o qual você quer marcar falta:");
		String aux;
		aux = sc.nextLine();
		
		this.repositorioAluno.acessarAluno(aux).buscarDisc(this).marcarFalta();
		
	}
	
	public void menuOpcao() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1 - Modificar notas de seus alunos:");
		System.out.println("2 - Marcar faltas:");
		int aux = 0;
		aux = sc.nextInt();
		sc.nextLine();
		if(aux == 1) {
			this.menuNota();
		}
		else if(aux == 2) {
			this.menuFaltas();
		}
		else {
			//sei que deveria ser uma exception, mas ainda não aprendi isso
			System.out.println("ERRO");
		}
	}
	
	
	public void menuLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite sua senha");
		String aux2;
		int sair = 0;
		aux2 = sc.nextLine();
		while(this.login(this.getId(), aux2) == false && sair == 0) {
			System.out.println("Digite a senha");
			aux2 = sc.nextLine();
			
			System.out.println("Digite 0 para tentar novamente");
			sair = sc.nextInt();
			sc.nextLine();
		}
		
		if (this.login(this.getId(), aux2) == true) {
			this.menuOpcao();
		}
			
			
		
		
	}
	
	
	public boolean equals(Professor outro) {
		return super.equals(outro);
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
