package br.ufrpe.easy_school.negocios;

import java.util.ArrayList;

import br.ufrpe.easy_school.dados.IRepositorioPessoas;
import br.ufrpe.easy_school.exceptions.PessoaExistenteException;
import br.ufrpe.easy_school.exceptions.PessoaNaoExistenteException;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Pessoa;
import br.ufrpe.easy_school.negocios.beans.Professor;
import br.ufrpe.easy_school.negocios.beans.Responsavel;

public class CadastroPessoas {
	IRepositorioPessoas repositorio;
	
	/*
	 * Adicionar this.repositorio.salvarArquivoRepositorioPessoas() ao final de todos os m�todos.
	 */
	
	public CadastroPessoas(IRepositorioPessoas instanciaRepositorio) {
		this.repositorio = instanciaRepositorio;
	}
	
	
	public void cadastrar(Pessoa p) throws PessoaExistenteException {
		if(p == null) {
			//se for nulo, nao cadastra
		}
		else {
			if(!this.existe(p.getId())) {
				this.repositorio.cadastrar(p);
				this.repositorio.salvarArquivosRepositorioPessoas();
			}
			else {
				throw new PessoaExistenteException(p.getId());
			}
		}
	}
	
	
	
	public void descadastrar(String id) throws PessoaNaoExistenteException {
		
		Pessoa p = this.buscar(id);
		if(p == null) {
			//exception pessoa nao existe
			throw new PessoaNaoExistenteException(id);
		}
		else {
			this.repositorio.remover(id);
			this.repositorio.salvarArquivosRepositorioPessoas();
		}
	}
	
	
	public void mudarNota(Professor prof, String idDisc, String idAluno, int unidade, double nota) throws PessoaNaoExistenteException {
		Pessoa temp = this.buscar(idAluno);
		if(!(temp instanceof Aluno)) {
			//aluno nao cadastrado
			throw new PessoaNaoExistenteException(idAluno);
		}
		else {
			((Aluno) this.buscar(idAluno)).buscarDisc(prof).mudarNota(unidade, nota);
			this.repositorio.salvarArquivosRepositorioPessoas();
		}
	}
	
	public void addAluno(String idAluno, String idResponsavel) throws PessoaNaoExistenteException {
		Pessoa temp = this.buscar(idAluno);
		if(temp instanceof Aluno) {
			if(this.buscar(idResponsavel) instanceof Responsavel) {
				Responsavel atual = (Responsavel) this.buscar(idResponsavel);
				atual.addAluno((Aluno)temp);
				this.repositorio.salvarArquivosRepositorioPessoas();
			}
		}
	}
	
	public boolean efetuarLogin(String id, String password) throws PessoaNaoExistenteException {

		boolean retorno = false;
		if(this.existe(id) ) {
			retorno = this.buscar(id).login(id, password);
		}
		else {
			//senha incorreta exception
		}
		
		return retorno;
	}
	
	public void addDisciplina(String idAluno, Disciplina disc) throws PessoaNaoExistenteException {
		Pessoa temp = this.buscar(idAluno);
		if (temp instanceof Aluno) {
			((Aluno) this.buscar(idAluno)).addDisciplina(disc);
			this.repositorio.salvarArquivosRepositorioPessoas();
		}
		
	}
	
	public void marcarFalta(Professor prof, String idDisc, String idAluno) throws PessoaNaoExistenteException {
		Pessoa temp = this.buscar(idAluno);
		if (temp instanceof Aluno) {
			((Aluno) this.buscar(idAluno)).buscarDisc(prof).marcarFalta();
			this.repositorio.salvarArquivosRepositorioPessoas();
		}
	}
	
	
	
	public Pessoa buscar(String id) throws PessoaNaoExistenteException {
		return this.repositorio.buscar(id);
	}
	
	
	public boolean existe(String id) {
		return this.repositorio.existe(id);
	}
	
	public void remover(String id) {
		this.repositorio.remover(id);
	}
	
	public ArrayList<Aluno> alunosDisc(Disciplina disc){
		return this.repositorio.alunosDisc(disc);
	}
	
	public ArrayList<Aluno> getAlunos(){
		return this.repositorio.getAlunos();
	}
	
	public ArrayList<Professor> getProfessores(){
		return this.repositorio.getProfessores();
	}
	
	public ArrayList<Responsavel> getResponsaveis(){
		return this.repositorio.getResponsaveis();
	}
	
	public ArrayList<Responsavel> responsaveisAluno(Aluno aluno){
		return this.repositorio.responsaveisAluno(aluno);
	}
	
}





	