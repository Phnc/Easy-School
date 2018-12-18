package br.ufrpe.easy_school.exceptions;

public class PessoaNaoExistenteException extends Exception {
	
	private String id;

	public PessoaNaoExistenteException(String id) {
		super("A pessoa de id " + id + " não existe");
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
}
