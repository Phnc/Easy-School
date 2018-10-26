package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;

public class Disciplina {
	
	private String nome;
	private ArrayList<String> notificacoes;
	
	
	public Disciplina(String nome) {
		super();
		this.nome = nome;
		this.notificacoes = new ArrayList<String>(0);
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	
	
	
	
	
	
	

}
