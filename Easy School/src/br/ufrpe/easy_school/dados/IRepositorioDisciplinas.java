package br.ufrpe.easy_school.dados;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;

public interface IRepositorioDisciplinas {
	
	/**
	 * Cadastra uma nova disciplina no repositório
	 *
	 * @param disc
	 * 			  Disciplina a ser cadastrada
	 */
	
	void cadastrar(Disciplina disc);
	
	/**
	 * Cadastra uma nova disciplina no repositório, este método usa o construtor da classe "Disciplina"
	 * 
	 * @param nome
	 * 			  Nome da disciplina que será cadastrada
	 * @param professor
	 * 				   Professor que ensina a disciplina
	 * @param id
	 * 			Id da nova disciplina
	 */
	void cadastrar(String nome, Professor professor, String id);
		
	/**
	 * Busca por uma disciplina com o id passado como parâmetro no repositório, caso ela exista, a retorna
	 * Caso não exista, retorna null
	 * 
	 * @param id
	 * 			id da disciplina a ser buscada
	 * @return
	 * 			a disciplina com o id passado como parâmetro, ou null, caso esta não exista
	 */
	Disciplina buscar(String id);
	/**
	 * Método auxiliar, verifica se a disciplina com o id passado como parâmetro já existe no repositório
	 * 
	 * @param id
	 * 			Id da disciplina a ser verificada
	 * @return
	 * 		  true ou false, dependendo da existência ou não de uma disciplina com o Id passado como parâmetro
	 */
	boolean existe(String id);
	
	/**
	 * Remove a disciplina com o id passado como parâmetro do repositório
	 * 
	 * @param id
	 * 			Id da dsciplina a ser removida
	 */
	
	void remover(String id);
	
	/**
	 * Este método é usado na GUI, para que o professor consiga selecionar uma dentre as disciplinas que ensina
	 * e modifique as notas dos alunos cadastrados nela 
	 * 
	 * Retorna uma lista de disciplinas ensinadas por um professor
	 * 
	 * @param prof
	 * 			  Professor que ensina as disciplinas da lista que será retornada
	 * @return
	 * 		  Lista de disciplinas ensinadas pelo professor passado como parâmetro		  
	 */
	ArrayList<String> arrayDisc(Professor prof);
	

}
