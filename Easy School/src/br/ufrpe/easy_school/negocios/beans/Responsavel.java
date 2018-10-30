package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;

public class Responsavel {
	
	private String nome;
	private String id;
	private String senha;
	private ArrayList<Aluno> alunos;
	
	public boolean logout() {
		//chama algum metodo para confirmar
		return true;
	}
	
	
	
	
	public Responsavel(String nome, String id, String senha) {
		super();
		this.nome = nome;
		this.id = id;
		this.senha = senha;
		this.alunos = new ArrayList<Aluno>(1);
	}


	public boolean login(String newId, String newSenha) {
		if(this.id.equals(newId) && this.senha.equals(newSenha)) {
			return true;
		}
		else {
			return false;
		}
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


	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}


	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}


	@SuppressWarnings("unused")
	private String getSenha() {
		return senha;
	}


	@SuppressWarnings("unused")
	private void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}


	@Override
	public String toString() {
		String aux = "";
		for(int i = 0; i < alunos.size(); i++) {
			aux += alunos.get(i).toString();
			aux += "\n";
		}
		
		return aux;
	}
	
	
	
	
	
}
