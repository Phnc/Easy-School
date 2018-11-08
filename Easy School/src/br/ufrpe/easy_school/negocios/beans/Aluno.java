package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufrpe.easy_school.dados.*;

public class Aluno extends Pessoa {
	
	private ArrayList<Disciplina> disciplinas;
	@SuppressWarnings("unused")
	private RepositorioAluno repositorioAluno;
	

	public void setRepositorioAluno(RepositorioAluno repositorioAluno) {
		this.repositorioAluno = repositorioAluno;
	}

	public Aluno(String name, String id, String password) {
		super(name, id, password);
		this.disciplinas = new ArrayList<Disciplina>(1);
	}
	
	public void criarDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas.addAll(disciplinas);
	}
	
	
	
	public Disciplina buscarDisc(Professor outro) {
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).getProfessor().getId().equals(outro.getId())) {
				return this.disciplinas.get(i);
			}
		}
		//se chegou aqui, chama alguma exception
		return null;
	}
	
	
	
	public void addDisciplina(Disciplina disc) {
		this.disciplinas.add(disc);
	}
	
	
	public void menuNotas() {
		System.out.println("Visualizando notas:");
		System.out.println("=====================");
		System.out.println("");
		System.out.println("");
		System.out.println(this.toString());
		System.out.println("");
		System.out.println("");
		System.out.println("=====================");
	}
	
	public void menuLogin() {
		Scanner sc = new Scanner(System.in);
		String aux2;
		System.out.println("Digite sua senha:");
		aux2 = sc.nextLine();
		int sair = 0;
		
		while(this.login(this.getId(), aux2) == false && sair == 0) {
			System.out.println("Digite a senha");
			aux2 = sc.nextLine();
			
			System.out.println("Digite 0 para tentar novamente");
			sair = sc.nextInt();
			sc.nextLine();
		}
		
		if (this.login(this.getId(), aux2) == true) {
			this.menuNotas();
		}
	}
	
	

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public String toString() {
		String imprimir = super.toString();
		for(int i = 0; i < this.disciplinas.size(); i++) {
			imprimir += this.disciplinas.get(i).toString();
		}
		return imprimir;
	}
	
	public void menuTeste() {
		System.out.println("Imprimindo notas do aluno " + this.getName() + " ................");
		System.out.println(this.disciplinas.toString());
		System.out.println("........................");
	}
	
	public void disciplinasComProf(Professor professor) {
		System.out.println("Nome: " + this.getName()+ ", Id: " + this.getId());
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).getProfessor().equals(professor)) {
				System.out.println(this.disciplinas.get(i));
			}
		}
	}
	
	
}
