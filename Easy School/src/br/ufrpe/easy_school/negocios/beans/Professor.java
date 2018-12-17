package br.ufrpe.easy_school.negocios.beans;

public class Professor extends Pessoa implements Serializable{

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

}
