package br.ufrpe.easy_school.negocios.beans;

public class Diretoria {
	//A classe diretoria tem acesso aos repositorios de alunos, professores e responsáveis e pode modificar informações dentro delas
	//por exemplo, a diretoria pode "remover" um professor e depois "adicionar" um novo. Basicamente, ela é responsável pelo CRUD das outras classes
	//Além de poder visualizar informações sobre elas
	//Imagine que um aluno sofre um acidente na escola, a diretoria tem acesso à informações relevantes neste caso, como tipo sanguineo e alergias.
	
	
	private String login;
	private String senha;
	
	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static void adicionarAluno(String nome, String cpf, String tipoSanguineo, String senha, String matricula, String nomeResponsavel) {
		
	}
	
	public static void removerAluno(String cpf, String matricula) {
		
	}
	
	public static void adicionarProfessor(String nome, String cpf, String senha) {
		
	}
	
	public static void removerProfessor(String cpf) {
		
	}
}
