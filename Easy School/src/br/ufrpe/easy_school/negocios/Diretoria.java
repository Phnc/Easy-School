package br.ufrpe.easy_school.negocios;

import java.util.Scanner;

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
				this.repositorioAluno.acessarAluno(aluno.getId()).setRepositorioAluno(repositorioAluno);

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
				this.repositorioProfessor.acessarProfessor(professor.getId()).setRepositorioAluno(repositorioAluno);
				this.repositorioProfessor.acessarProfessor(professor.getId()).setRepositorioProfessor(repositorioProfessor);
				
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
				this.repositorioResponsavel.acessarResponsavel(responsavel.getId()).setRepositorioResponsavel(repositorioResponsavel);
				this.repositorioResponsavel.acessarResponsavel(responsavel.getId()).setRepositorioAluno(repositorioAluno);
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
	
	
	public void menuTeste() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cadastrar um professor: ");
		String aux1, aux2, aux3;
		System.out.println("Digite o nome:");
		aux1 = sc.nextLine();
		System.out.println("O id:");
		aux2 = sc.nextLine();
		System.out.println("A senha: (quando usarmos gui ela nao vai aparecer)");
		aux3 = sc.nextLine();
		Professor profTeste = new Professor(aux1, aux2, aux3);
		
		this.cadastrarProfessor(profTeste);
		
		
		System.out.println("Cadastrar uma nova disciplina associada ao professor criado anteriormente");
		System.out.println("Nome:");
		aux1 = sc.nextLine();
		System.out.println("Id:");
		aux2 = sc.nextLine();
		
		Disciplina discTeste = new Disciplina(aux1, profTeste, aux2);
		this.cadastrarDisciplina(discTeste);
		
		System.out.println("Cadastrar um aluno: (a disciplina criada há pouco será associada a ele)");
		System.out.println("Nome: ");
		aux1 = sc.nextLine();
		System.out.println("Id: ");
		aux2 = sc.nextLine();
		System.out.println("Senha:");
		aux3 = sc.nextLine();
		
		Aluno alunoTeste = new Aluno(aux1, aux2, aux3);
		this.cadastrarAluno(alunoTeste);
		this.repositorioAluno.acessarAluno(alunoTeste.getId()).addDisciplina(discTeste);
		
		
		System.out.println("Cadastrar um responsável: (o aluno anterior será associado a ele)");
		System.out.println("Nome:");
		aux1 = sc.nextLine();
		System.out.println("Id:");
		aux2 = sc.nextLine();
		System.out.println("Senha:");
		aux3 = sc.nextLine();
		
		Responsavel responsavelTeste = new Responsavel(aux1, aux2, aux3);
		this.cadastrarResponsavel(responsavelTeste);
		this.repositorioResponsavel.acessarResponsavel(responsavelTeste.getId()).addAluno(alunoTeste);
		
		profTeste.menuTeste();
		alunoTeste.menuTeste();
		responsavelTeste.menuTeste();
		
		
	}
	
	
	
	

	

}
