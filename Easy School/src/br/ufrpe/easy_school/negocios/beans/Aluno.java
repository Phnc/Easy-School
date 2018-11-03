package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;
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
	
}
