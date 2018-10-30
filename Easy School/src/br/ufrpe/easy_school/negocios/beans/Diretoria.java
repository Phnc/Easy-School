package br.ufrpe.easy_school.negocios.beans;

public class Diretoria {
	
	private String id;
	private String senha;
	
	
	
	
	public Diretoria(String id, String senha) {
		super();
		this.id = id;
		this.senha = senha;
	}
	
	

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
	
	
	
	

}
