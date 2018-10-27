package br.ufrpe.easy_school.data;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import br.ufrpe.easy_school.negocios.beans.Turma;

public class Repositorio {
	
	private ArrayList<Aluno> repositorioAlunos;
	private ArrayList<Disciplina> repositorioDisciplinas;
	private ArrayList<Professor> repositorioProfessores;
	private ArrayList<Responsavel> repositorioResponsaveis;
	private ArrayList<Turma> repositorioTurmas;
	public ArrayList<Aluno> getRepositorioAlunos() {
		return repositorioAlunos;
	}
	
	public void setRepositorioAlunos(ArrayList<Aluno> repositorioAlunos) {
		this.repositorioAlunos = repositorioAlunos;
	}
	public ArrayList<Disciplina> getRepositorioDisciplinas() {
		return repositorioDisciplinas;
	}
	public void setRepositorioDisciplinas(ArrayList<Disciplina> repositorioDisciplinas) {
		this.repositorioDisciplinas = repositorioDisciplinas;
	}
	public ArrayList<Professor> getRepositorioProfessores() {
		return repositorioProfessores;
	}
	public void setRepositorioProfessores(ArrayList<Professor> repositorioProfessores) {
		this.repositorioProfessores = repositorioProfessores;
	}
	public ArrayList<Responsavel> getRepositorioResponsaveis() {
		return repositorioResponsaveis;
	}
	public void setRepositorioResponsaveis(ArrayList<Responsavel> repositorioResponsaveis) {
		this.repositorioResponsaveis = repositorioResponsaveis;
	}
	public ArrayList<Turma> getRepositorioTurmas() {
		return repositorioTurmas;
	}
	public void setRepositorioTurmas(ArrayList<Turma> repositorioTurmas) {
		this.repositorioTurmas = repositorioTurmas;
	}
	
	
}