package br.ufrpe.easy_school.exceptions;

public class DisciplinaNaoExistenteException extends Exception {
	
	private String id;

	public DisciplinaNaoExistenteException(String id) {
		super("A disciplina de id " + id + " não existe");
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
