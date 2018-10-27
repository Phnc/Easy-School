package br.ufrpe.easy_school.negocios.beans;

public class Professor {
	
	private String nome;
	private int idade;
	private String cpf;
	private String senha;
	
	public Professor(String nome, int idade, String cpf, String senha) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade(){
		return idade;
	}
	
	public void setIdade(int idade){
		this.idade = idade;
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
