package br.ufrpe.easy_school.negocios.beans;

import java.io.Serializable;

public class Disciplina implements Serializable{
	
	private String nome;
	private Professor professor;
	private double[] notas;
	private int faltas;
	private String id;
	
	public Disciplina(String nome, Professor professor, String id) {
		super();
		this.nome = nome;
		this.professor = professor;
		this.notas = new double[4];
		this.faltas = 0;
		this.setId(id);;
	}

	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		if(id != null && !id.isEmpty()) {
			this.id = id;
		}
		else {
			//exception
		}
	}
	

	public Professor getProfessor() {
		return professor;
	}
	
	
		

	public double getNotasUnidade(int unidade) {
		return notas[unidade];
	}

	public String getNome() {
		return nome;
	}

	public void mudarNota(int unidade, double nota) {
		if((unidade <= 4 && unidade > 0) && nota <= 10) {
			this.notas[unidade - 1] = nota;
		}
		else {
			//alguma exception
		}
	}
	
	public void marcarFalta() {
		this.faltas += 1;
	}
	
	public void removerFalta() {
		if(this.faltas > 0) {
			this.faltas--;
		}
	}

	public String toString() {
		StringBuffer helper = new StringBuffer();
		helper.append(this.getNome() + "\n");
		helper.append(this.getId());
		String retornar = helper.toString();
		return retornar;
	}
	
	public boolean equals(Disciplina outra) {
		boolean devolve = false;
		if(this.professor.equals(outra.getProfessor()) && this.getNome().equals(outra.getNome())) {
			if(this.id.equals(outra.getId())) {
				devolve = true;
			}
		}
		
		
		
		return devolve;
	}
	
	public Double getNota1() {
		return notas[0];
	}
	public Double getNota2() {
		return notas[1];
	}
	public Double getNota3() {
		return notas[2];
	}
	public Double getNota4() {
		return notas[3];
	}
	

	public Integer getFaltas() {
		return this.faltas;
	}
	
	

}
