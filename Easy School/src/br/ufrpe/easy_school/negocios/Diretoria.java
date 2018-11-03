package br.ufrpe.easy_school.negocios;

import br.ufrpe.easy_school.dados.RepositorioAluno;
import br.ufrpe.easy_school.dados.RepositorioDisciplina;
import br.ufrpe.easy_school.dados.RepositorioProfessor;
import br.ufrpe.easy_school.dados.RepositorioResponsavel;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Pessoa;
import br.ufrpe.easy_school.negocios.beans.Professor;
import br.ufrpe.easy_school.negocios.beans.Responsavel;

public class Diretoria extends Pessoa {
	
	private RepositorioAluno repositorioAluno;
	private RepositorioProfessor repositorioProfessor;
	private RepositorioDisciplina repositorioDisciplina;
	private RepositorioResponsavel repositorioResponsavel;

	
	public Diretoria(String name, String id, String password, RepositorioAluno repositorioAluno, RepositorioProfessor repositorioProfessor, RepositorioDisciplina repositorioDisciplina, RepositorioResponsavel repositorioResponsavel) {
		super(name, id, password);
		this.repositorioAluno = repositorioAluno;
		this.repositorioProfessor = repositorioProfessor;
		this.repositorioDisciplina = repositorioDisciplina;
		this.repositorioResponsavel = repositorioResponsavel;
		
	}

	
	public void cadastrarAluno(Aluno aluno) {
		if(aluno == null) {
			//exception
		}
		else {
			if(this.existeAluno(aluno) == false) {
				this.repositorioAluno.addAluno(aluno);
			}
			else {
				//exception
			}
		}
	}
	
	
	public void cadastrarProfessor(Professor professor) {
		if(professor == null) {
			//exception
		}
		else {
			if(this.existeProfessor(professor) == false) {
				this.repositorioProfessor.addProfessor(professor);
			}
			else {
				//exception
			}
		}
	}
	
	public void cadastrarDisciplina(Disciplina disciplina) {
		if(disciplina == null) {
			//exception
		}
		else {
			if(this.existeDisciplina(disciplina) == false) {
				this.repositorioDisciplina.addDisciplina(disciplina);
			}
			else {
				//exception
			}
			
		}
	}
	
	public void cadastrarResponsavel(Responsavel responsavel) {
		if(responsavel == null) {
			//exception
		}
		else {
			if(this.existeResponsavel(responsavel) == false) {
				this.repositorioResponsavel.addResponsavel(responsavel);
			}
			else {
				//exception
			}
			
		}
	}
	
	
	
	public boolean existeAluno(Aluno aluno) {
		return this.repositorioAluno.existe(aluno.getId());
	}
	
	public boolean existeProfessor(Professor professor) {
		return this.repositorioProfessor.existe(professor.getId());
	}
	
	public boolean existeDisciplina(Disciplina disciplina) {
		return this.repositorioDisciplina.existe(disciplina);
	}
	
	public boolean existeResponsavel(Responsavel responsavel) {
		return this.repositorioResponsavel.existe(responsavel.getId());
	}


	public RepositorioAluno getRepositorioAluno() {
		return repositorioAluno;
	}


	public RepositorioProfessor getRepositorioProfessor() {
		return repositorioProfessor;
	}


	public RepositorioDisciplina getRepositorioDisciplina() {
		return repositorioDisciplina;
	}


	public RepositorioResponsavel getRepositorioResponsavel() {
		return repositorioResponsavel;
	}
	
	
	
	
	
	

	

}
