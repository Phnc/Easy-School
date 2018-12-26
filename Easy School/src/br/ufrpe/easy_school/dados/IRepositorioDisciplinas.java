package br.ufrpe.easy_school.dados;

import java.util.ArrayList;

import br.ufrpe.easy_school.exceptions.DisciplinaJaExistenteException;
import br.ufrpe.easy_school.exceptions.DisciplinaNaoExistenteException;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;

public interface IRepositorioDisciplinas {
	/**
	 * Cadastra uma nova disciplina no repositório de disciplinas
	 * 
	 * @param disc
	 * 			  Disciplina a ser cadastrada		  
	 */
	void cadastrar(Disciplina disc);
	
	/**
	 * Cadastra uma nova disciplina no repositório de disciplinas(usa o construtor padrão da classe "Disciplina"
	 * 
	 * @param nome
	 * 			  Nome da Disciplina a ser cadastrada
	 * @param professor
	 * 				   Professor que ensina essa disciplina
	 * @param id
	 * 			id da nova disciplina
	 */
	void cadastrar(String nome, Professor professor, String id) throws DisciplinaJaExistenteException;
		
	/**
	 *  Devolve uma disciplina com o id passado como parâmetro
	 * 
	 * @param id
	 * 			id da disciplina a ser buscada
	 * @return
	 * 		  Disciplina com o id passado como parâmetro
	 * 
	 * @throws DisciplinaNaoExistenteException
	 */
	Disciplina buscar(String id) throws DisciplinaNaoExistenteException;
	
	/**
	 * "Diz" se uma disciplinan existe ou não
	 * @param id
	 * 		    id da disciplina que terá a existência verificada
	 * @return
	 * 		  true ou false, dependendo da existência ou não 
	 */
	boolean existe(String id);
	
	/**
	 * 
	 * @param id
	 * 			id da disciplina a ser removida
	 * @throws DisciplinaNaoExistenteException
	 */
	void remover(String id) throws DisciplinaNaoExistenteException;
	
	/**
	 * Devolve uma lista de disciplinas que um professor ensina
	 * 
	 * @param prof
	 * 			  Professor que ensina as disciplinas
	 * @return
	 * 		  Array de disciplinas ensinadas pelo professor
	 */
	
	ArrayList<Disciplina> arrayDisc(Professor prof);
	


	void salvarArquivosRepositorioDisciplinas();

	void carregarArquivosRepositorioDisciplinas();
	/**
	 * Devolve uma lista com todas as disciplinas do repositorio
	 * @return
	 * 		  todas as disciplinas do repositorio
	 */
	ArrayList<Disciplina> getDisciplinas();

	//void ordenarPorOrdemAlfabetica();
}
