package br.ufrpe.easy_school.dados;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.beans.Professor;

public class RepositorioProfessor {
	
	private static RepositorioProfessor instance;
	private ArrayList<Professor> professores;
	
	private RepositorioProfessor() {
		this.professores = new ArrayList<Professor>(1);
	}
	
	
	public void addProfessor(Professor prof) {
		this.professores.add(prof);
	}
	
	public void removerProfessor(Professor prof) {
		this.professores.remove(prof);
	}
	
	
	public static RepositorioProfessor getInstance() {
		if(instance == null) {
			instance = new RepositorioProfessor();
		}
		return instance;
	}
	
	public boolean existe(String id) {
		boolean existe = false;
		for(int i = 0; i < this.professores.size(); i++) {
			if(this.professores.get(i).getId().equals(id)) {
				existe = true;
			}
			
		}
		return existe;
	}
	
	
	public Professor acessarProfessor(String id) {
		for(int i = 0; i < this.professores.size(); i++) {
			if(this.professores.get(i).getId().equals(id)) {
				return this.professores.get(i);
			}
		}
		//se nao encontrou nenhum, chama alguma exception, mas como ainda nao aprendi, estou dizendo pra devolver null
		return null;
	}
	
	

}
