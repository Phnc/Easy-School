package br.ufrpe.easy_school.dados;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.beans.Disciplina;

public class RepositorioDisciplina {
	
	private static RepositorioDisciplina instance;
	private ArrayList<Disciplina> disciplinas;
	
	private RepositorioDisciplina() {
		this.disciplinas = new ArrayList<Disciplina>(1);
	}
	
	public void addDisciplina(Disciplina disc) {
		this.disciplinas.add(disc);
	}
	
	public void removerDisciplina(Disciplina disc) {
		this.disciplinas.remove(disc);
	}
	
	public boolean existe(Disciplina disc) {
		boolean devolve = false;
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).equals(disc)) {
				
				devolve = true;
				
			}
		}
		return devolve;
	}
	
	public Disciplina buscarDisciplina(String id) {
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).getId().equals(id)){
				return this.disciplinas.get(i);
			}
		}
		return null;
	}
	
	
	public static RepositorioDisciplina getInstance() {
		if(instance == null) {
			instance = new RepositorioDisciplina();
		}
		return instance;
	}
	

	

}
