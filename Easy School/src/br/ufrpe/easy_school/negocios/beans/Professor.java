package br.ufrpe.easy_school.negocios.beans;

import java.io.Serializable;

public class Professor extends Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6640534907895243857L;

	public Professor(String name, String id, String password) {
		super(name, id, password);
		// TODO Auto-generated constructor stub
	}
	
	public void mudarNota(Aluno aluno, int unidade, double nota) {
		aluno.buscarDisc(this).mudarNota(unidade, nota);
	}
	
	public void marcarFalta(Aluno aluno) {
		aluno.buscarDisc(this).marcarFalta();
	}
	
	public void removerFalta(Aluno aluno) {
		aluno.buscarDisc(this).removerFalta();
	}
	
	public boolean equals(Professor outro) {
		if(this.getId().equals(outro.getId()) && this.getName().equals(outro.getName())) {
			return true;
		}
		return false;
	}

}
