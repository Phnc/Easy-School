package br.ufrpe.easy_school.dados;

import java.util.ArrayList;

import br.ufrpe.easy_school.exceptions.PessoaExistenteException;
import br.ufrpe.easy_school.exceptions.PessoaNaoExistenteException;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Pessoa;

public interface IRepositorioPessoas {

	


	/**
	 * Cadastra uma novo pessoa no ArrayList de pessoas
	 * 
	 * @param pessoa
	 *              A referência da pessoa a ser cadastrada
	 */
	void cadastrar(Pessoa pessoa) throws PessoaExistenteException;
	
	/**
	 * Cria um objeto de uma subclasse de Pessoa usando o construtor padrão da classe
	 * Método sobrecarregado
	 * @param nome
	 * 				nome da nova pessoa a ser cadastrada
	 * @param i
	 * 				id da nova pessoa a ser cadastrada
	 * @param password
	 * 				senha da nova pessoa
	 */
	
	void cadastrar(String nome, String id, String password) throws PessoaExistenteException;
	
	
	/**
	 * Procura um pessoa baseado no ID dado como parâmetro
	 * 
	 * @param id
	 * 			Id da pessoa a ser buscada
	 * @return A pessoa encontrada, ou null, caso uma pessoa com esse ID não exista
	 */
	
	Pessoa buscar(String id) throws PessoaNaoExistenteException;
	
	
	/**
	 * Verifica se existe uma pessoa cadastrada com o ID passado como parâmetro
	 * 
	 * @param id
	 * 			ID da pessoa a ser buscada
	 */
	boolean existe(String id);
	
	
	/**
	 * Remove a pessoa cujo ID é passado como parâmetro
	 * 
	 * @param id
	 * 			ID da pessoa a ser removida
	 * 
	 * @throws pessoaNaoExistente
	 */
	
	void remover(String id);
	
	/**
	 * Devolve uma lista de alunos que cursam uma disciplina
	 * 
	 * @param disc
	 * 		 	  Disciplina cursada pelos alunos	
	 * @return
	 * 		  Alunos que cursam a disciplina passada como parâmetro
	 */
	
	ArrayList<Aluno> alunosDisc(Disciplina disc);

	void salvarArquivosRepositorioPessoas();
	
	//void carregarArquivoRepositorioPessoas();
	
	//void ordenarPorOrdemAlfabetica();

}
