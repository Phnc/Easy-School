package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;



public class Responsavel extends Pessoa {
	

	private ArrayList<Aluno> alunos;
	
	public Responsavel(String name, String id, String password) {
		super(name, id, password);
		this.alunos = new ArrayList<Aluno>(1);
	}
	
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	public void removerAluno(Aluno aluno) {
		this.alunos.remove(aluno);
		
	}
	
	public void imprimirNotaAlunos() {
		for(int i = 0; i < this.alunos.size(); i++) {
			System.out.println(this.alunos.get(i).toString());
		}
	}

	
	

}
