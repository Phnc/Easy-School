package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;
//Uma turma associa um professor a uma disciplina e um conjunto de alunos
//o ArrayList de alunos pode ser tirado do Repositorio de alunos

public class Turma {
	Professor professor;
	Disciplina disc;
	ArrayList<Aluno> alunos;
	
public void addNota(String nome, int unidade, double nota, int disc) {
		
		buscarAluno(nome).mudarNota(disc, unidade, nota);
	}
	
	
	
	public Aluno buscarAluno(String nome) {
		for(int i = 0; i < alunos.size(); i++) {
			if(nome.equals(alunos.get(i).getNome())) {
				return alunos.get(i);
			}
		}
		return null;
	}
	
	
	public String getAlunos() {
		String imprimir = "";
		for(int i = 0; i < alunos.size(); i++) {
			imprimir += alunos.get(i).getNome() + "\n";
		}
		return imprimir;
	}

}
