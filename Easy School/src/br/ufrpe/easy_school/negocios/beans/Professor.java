package br.ufrpe.easy_school.negocios.beans;

public class Professor {
	
	private String nome;
	private String id;
	private String senha;
	
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

	@SuppressWarnings("unused")
	private String getSenha() {
		return senha;
	}

	@SuppressWarnings("unused")
	private void setSenha(String senha) {
		this.senha = senha;
	}

	public Professor(String nome, String id, String senha) {
		super();
		this.nome = nome;
		this.id = id;
		this.senha = senha;
	}
	
	public boolean equals(Professor prof) {
		
		if(this.nome.equals(prof.getNome()) && this.id.equals(prof.getId())) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public String toString() {
		return  nome;
	}
	
	public void modificarNota(Aluno aluno, int unidade, double nota) {
		int aux = aluno.buscarDisciplina(this);
		if(aux != -1) {
			aluno.getDisciplinas().get(aux).mudarNota(this, unidade, nota);
		}
		else {
			//alguma exception
		}
	}
	
	public void marcarFalta(Aluno aluno) {
		int aux = aluno.buscarDisciplina(this);
		if(aux != -1) {
			aluno.getDisciplinas().get(aux).marcarFalta(this);
		}
		else {
			//alguma exception
		}
	}
	
	
	
	
}
