package br.ufrpe.easy_school.exceptions;

public class DisciplinaJaExistenteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5457043783135076279L;
	private String id;

	public DisciplinaJaExistenteException(String id) {
		super("A disciplina de id " + id + " já existe");
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
