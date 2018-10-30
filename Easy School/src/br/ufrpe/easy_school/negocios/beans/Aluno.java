package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;

public class Aluno {
	private String nome;
	private String id;
	private String senha;
	private ArrayList<Disciplina> disciplinas;
	
	
	public boolean login(String newId, String newSenha) {
		if(this.id.equals(newId) && this.senha.equals(newSenha)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean logout() {
		//chama algum metodo para confirmar
		return true;
	}
	
	public Aluno(String nome, String id, String senha) {
		super();
		this.nome = nome;
		this.id = id;
		this.senha = senha;
		this.disciplinas = new ArrayList<Disciplina>(1);
	}
	
	public void addDisciplina(Disciplina disc) {
		this.disciplinas.add(disc);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@SuppressWarnings("unused")
	private String getSenha() {
		return senha;
	}

	@SuppressWarnings("unused")
	private void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	//devolve a posicao da disciplina ensinada pelo professor no arraylist de disciplinas do aluno (se esta existir)
	//se nao existir, devolve -1
	public int buscarDisciplina(Professor prof) {
		
		for(int i = 0; i < disciplinas.size(); i++) {
			if(this.disciplinas.get(i).getProfessor().equals(prof)) {
				return i;
			}
		}
		
		return -1;
		
	}

	@Override
	public String toString() {
		return "Nome:" + nome + ", Disciplinas:" + disciplinas;
	}

	
	
	
	
	
}
