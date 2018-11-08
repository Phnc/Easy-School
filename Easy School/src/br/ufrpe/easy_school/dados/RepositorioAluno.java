package br.ufrpe.easy_school.dados;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Professor;

public class RepositorioAluno {
	
	private static RepositorioAluno instance;
	private ArrayList<Aluno> alunos;
	
	private RepositorioAluno() {
		
		this.alunos = new ArrayList<Aluno>(1);
		
	}
	
	
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	public void removerAluno(Aluno aluno) {
		this.alunos.remove(aluno);
	}
	
	
	public Aluno acessarAluno(String id) {
		for(int i = 0; i < this.alunos.size(); i++) {
			if(this.alunos.get(i).getId().equals(id)) {
				return this.alunos.get(i);
			}
		}
		
		return null;
	}
	
	
	public void estudaCom(Professor professor) {
		for(int i = 0; i < this.alunos.size(); i++) {
		
					this.alunos.get(i).disciplinasComProf(professor);
				
		}
	}
	
	public int getSize() {
		return this.alunos.size();
	}
	
	
	
	public static RepositorioAluno getInstance() {
		if(instance == null) {
			instance = new RepositorioAluno();
		}
		return instance;
	}
	
	public boolean existe(String id) {
		boolean existe = false;
		for(int i = 0; i < this.alunos.size(); i++) {
			if(this.alunos.get(i).getId().equals(id)) {
				existe = true;
			}
			
		}
		return existe;
	}
	
	

}
