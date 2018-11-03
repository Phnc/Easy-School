package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;

public class Aluno extends Pessoa {
	
	private ArrayList<Disciplina> disciplinas;

	public Aluno(String name, String id, String password) {
		super(name, id, password);
		this.disciplinas = new ArrayList<Disciplina>(1);
	}
	
	public void criarDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas.addAll(disciplinas);
	}
	
	
	public Disciplina buscarDisc(Professor prof) {
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).getProfessor().equals(prof)) {
				return this.disciplinas.get(i);
			}
		}
		//se chegou aqui, chama alguma exception
		return null;
	}
	
	
	
	public void addDisciplina(Disciplina disc) {
		this.disciplinas.add(disc);
	}
	
	

	public String toString() {
		String imprimir = super.toString();
		for(int i = 0; i < this.disciplinas.size(); i++) {
			imprimir += this.disciplinas.get(i).toString();
		}
		return imprimir;
	}
	
}
