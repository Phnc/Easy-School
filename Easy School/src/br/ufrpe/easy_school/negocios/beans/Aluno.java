package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;


public class Aluno extends Pessoa {
	
	public Aluno(String name, String id, String password) {
		super(name, id, password);
		this.disciplinas = new ArrayList<Disciplina>(1);
		// TODO Auto-generated constructor stub
	}
	
	

	private ArrayList<Disciplina> disciplinas;
	
	public Disciplina buscarDisc(Professor outro) {
		
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).getProfessor().equals(outro)) {
				return this.disciplinas.get(i);
			}
		}
		//se chegou aqui, chama alguma exception
		//disciplinaNaoEncontradaexception
		return null;
	}
	
	
	public void addDisciplina(Disciplina disc) {
		//usando a Disciplina 'temp' para n�o passarmos uma referencia para a disciplina original
		//caso estivessemos passando a original, qualquer modifica��o em um aluno, iria refeletir nos outros
		//foi uma solu��o que consegui encontrar para esse problema, talvez n�o seja a melhor
		Disciplina temp = new Disciplina(disc.getNome(), disc.getProfessor(), disc.getId());
		this.disciplinas.add(temp);
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
	
	public boolean cursa(Disciplina disc) {
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).equals(disc)) {
				return true;
			}
		}
		return false;
	}
	
	public Disciplina getDisciplina(Disciplina disc) {
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).equals(disc)) {
				return this.disciplinas.get(i);
			}
		}
		return null;
		
	}

}
