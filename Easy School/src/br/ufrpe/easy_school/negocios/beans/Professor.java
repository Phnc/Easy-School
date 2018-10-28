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
	
	//Esse método mudar nota fazia parte dos métodos da Classe Aluno.
	//Eu acho que ele ficaria melhor dessa forma, dentro da Classe Professor, já que é ele quem vai mudar a nota de fato.
	//Possivelmente mudar pra aluno.getNotas() já que o atributo é privado, mas esse getter não existe ainda.
	public void mudarNota(Aluno aluno, int disciplina, int unidade, double nota){
		aluno.notas[disciplina][unidade] = nota;
	}

}
