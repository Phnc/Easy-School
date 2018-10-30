package br.ufrpe.easy_school.negocios.beans;

import java.util.Arrays;

public class Disciplina {
	
	private Professor professor;
	private String nome;
	private String id;
	private double[] notas;
	int faltas;
	
	public Disciplina(Professor professor, String nome, String id) {
		super();
		this.professor = professor;
		this.nome = nome;
		this.id = id;
		this.notas = new double[4];
		faltas = 0;
	}
	
	public boolean verificarProf(Professor prof) {
		if(this.professor.equals(prof)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public void mudarNota(Professor prof, int unidade, double nota) {
		if(this.verificarProf(prof) == true) {
			this.notas[unidade] = nota;
		}
		else {
			//devolve algum erro ou exception
		}
	}
	
	public void marcarFalta(Professor prof) {
		if(this.verificarProf(prof) == true) {
			this.faltas += 1;
		}
		else {
			//alguma exception
		}
		
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Disciplina [Professor: " + professor + "| Disciplina: " + nome +  "| Notas:"
				+ Arrays.toString(notas) + " Faltas " + faltas + "]";
	}
	
	
	
	

}
