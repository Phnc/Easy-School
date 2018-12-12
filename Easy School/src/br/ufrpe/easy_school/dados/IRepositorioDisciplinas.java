package br.ufrpe.easy_school.dados;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;

public interface IRepositorioDisciplinas {
	
	/**
	 * Cadastra uma nova disciplina no reposit�rio
	 *
	 * @param disc
	 * 			  Disciplina a ser cadastrada
	 */
	
	void cadastrar(Disciplina disc);
	
	/**
	 * Cadastra uma nova disciplina no reposit�rio, este m�todo usa o construtor da classe "Disciplina"
	 * 
	 * @param nome
	 * 			  Nome da disciplina que ser� cadastrada
	 * @param professor
	 * 				   Professor que ensina a disciplina
	 * @param id
	 * 			Id da nova disciplina
	 */
	void cadastrar(String nome, Professor professor, String id);
		
	/**
	 * Busca por uma disciplina com o id passado como par�metro no reposit�rio, caso ela exista, a retorna
	 * Caso n�o exista, retorna null
	 * 
	 * @param id
	 * 			id da disciplina a ser buscada
	 * @return
	 * 			a disciplina com o id passado como par�metro, ou null, caso esta n�o exista
	 */
	Disciplina buscar(String id);
	/**
	 * M�todo auxiliar, verifica se a disciplina com o id passado como par�metro j� existe no reposit�rio
	 * 
	 * @param id
	 * 			Id da disciplina a ser verificada
	 * @return
	 * 		  true ou false, dependendo da exist�ncia ou n�o de uma disciplina com o Id passado como par�metro
	 */
	boolean existe(String id);
	
	/**
	 * Remove a disciplina com o id passado como par�metro do reposit�rio
	 * 
	 * @param id
	 * 			Id da dsciplina a ser removida
	 */
	
	void remover(String id);
	
	/**
	 * Este m�todo � usado na GUI, para que o professor consiga selecionar uma dentre as disciplinas que ensina
	 * e modifique as notas dos alunos cadastrados nela 
	 * 
	 * Retorna uma lista de disciplinas ensinadas por um professor
	 * 
	 * @param prof
	 * 			  Professor que ensina as disciplinas da lista que ser� retornada
	 * @return
	 * 		  Lista de disciplinas ensinadas pelo professor passado como par�metro		  
	 */
	ArrayList<String> arrayDisc(Professor prof);
	

}
