package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;

public class Responsavel {
	
	private String nome;
	private String cpf;
	private String senha;
	
	private ArrayList<Aluno> estudante;
	private ArrayList<String> reclamacoes;
	private ArrayList<String> notificacoes;
	
	
	public Responsavel(String nome, String cpf, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.notificacoes = new ArrayList<String>(0);
		this.reclamacoes = new ArrayList<String>(0);
		this.estudante = new ArrayList<Aluno>(0);
		
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
