package br.ufrpe.easy_school.exceptions;

public class PessoaNaoExistenteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7179702122473482867L;
	private String id;

	public PessoaNaoExistenteException(String id) {
		super("A pessoa de id " + id + " n�o existe");
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
}
