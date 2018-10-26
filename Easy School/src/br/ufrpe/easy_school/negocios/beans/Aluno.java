package br.ufrpe.easy_school.negocios.beans;



public class Aluno {
	
	//nomeResponsavel para uso futuro em buscas no repositorio de responsaveis
	//nao sei se um aluno pode ter um 'Responsavel' dentro dele
	//ao mesmo tempo que responsavel tem um 'Aluno' dentro dele
	private String nomeResponsavel;
	private String nome;
	private String cpf;
	private String tipoSanguineo;
	private String senha;
	private String matricula;
	private double[][] notas;
	

	public Aluno(String nome, String cpf, String tipoSanguineo, String senha, String matricula, String nomeResponsavel) {
		super();
		this.nomeResponsavel = nomeResponsavel;
		this.nome = nome;
		this.cpf = cpf;
		this.tipoSanguineo = tipoSanguineo;
		this.senha = senha;
		this.matricula = matricula;
		//11 disciplinas, 4 notas em cada uma
		notas = new double[11][4];

	}
	
	
	public void mudarNota(int disc, int unidade, double nota) {
		notas[disc][unidade] = nota;
	}


	public String getNomeResponsavel() {
		return nomeResponsavel;
	}


	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
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


	public String getTipoSanguineo() {
		return tipoSanguineo;
	}


	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}





	
	
	
	
	

}
