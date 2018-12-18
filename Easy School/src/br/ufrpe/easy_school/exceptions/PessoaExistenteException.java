package br.ufrpe.easy_school.exceptions;

public class PessoaExistenteException extends Exception{
	
	private String id;

	public PessoaExistenteException(String id) {
		super("A pessoa de id " + id + " já existe");
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
