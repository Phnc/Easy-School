package br.ufrpe.easy_school.negocios;

import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Pessoa;
import br.ufrpe.easy_school.negocios.beans.Professor;

public interface IEscola {
	/**
	 * Adiciona uma nova pessoa ao repositório, podendo ser aluno, responsável ou professor
	 * 
	 * @param pessoa
	 * 				pessoa a ser cadastrada no repositório
	 */
	void cadastrarPessoa(Pessoa pessoa);
	
	/**
	 * Adiciona uma nova disciplina ao repositório
	 * 
	 * @param disciplina
	 * 					disciplina a ser cadastrada no repositório
	 */
	
	void cadastrarDisciplina(Disciplina disciplina);
	
	/**
	 * Busca uma pessoa com o id igual ao do parâmetro
	 * 
	 * @param id
	 * 			id da pessoa a ser buscada
	 * @return
	 * 			Pessoa com o id equivalente, ou null, caso ela não exista
	 */
	
	Pessoa buscar(String id);
	
	
	/**
	 * Busca uma disciplina com o id passado como parâmetro
	 * 
	 * @param id
	 * 			id da disciplina a ser buscada		
	 * 
	 * @return
	 * 			A disciplina que tem o id passado como parâmetro ou null, caso ela não exista
	 */
	
	Disciplina buscarDisciplina(String id);
	
	/**
	 * Remove a pessoa com o id passado como parâmetro do repositório de pessoas
	 * 
	 * @param id
	 * 			id da pessoa a ser removida
	 */
	
	void removerPessoa(String id);
	
	/**
	 * Altera a nota de um aluno do repositório, este método será usado exclusivamente por professores
	 * 
	 * @param prof
	 * 				Professor que ensina uma disciplina ao aluno (é ele quem vai alterar a nota)
	 * @param idDisc
	 * 				Id da disciplina na qual o aluno terá sua nota alterada
	 * @param idAluno
	 * 				Id do aluno a ter a nota alterada
	 * @param unidade
	 * 				A unidade na qual a nota será alterada (de 1 a 4)
	 * @param nota
	 * 				A nota a ser colocada naquela unidade (de 0 a 10)
	 */
	
	void mudarNota(Professor prof, String idDisc, String idAluno, int unidade, double nota);
	
	
	/**
	 * Método usado por um professor para marcar uma falta de um aluno
	 * 
	 * @param prof
	 * 				Professor que ensina uma disciplina ao aluno (é ele quem vai marcar a falta)
	 * @param idDisc
	 * 				Id da disciplina na qual o aluno terá sua nota alterada
	 * @param idAluno
	 * 				Id do aluno a ter a nota alterada
	 */
	
	void marcarFalta(Professor prof, String idDisc, String idAluno);
	
	/**
	 * Método para efetuar o login de um usuário
	 * @param id
	 * 			id do usuário que está tentando efetuar login
	 * @param password
	 * 					senha do usuário que está tentando efetuar login
	 */
	
	void efetuarLogin(String id, String password);
	
	/**
	 * Adiciona um aluno a um responsável
	 * @param idAluno
	 * 				Id do aluno a ser adicionado
	 * @param idResponsavel
	 * 						Id do responsável associado a esse aluno
	 */
	
	void addAluno(String idAluno, String idResponsavel);
	
	/**
	 * Remove uma disciplina com o id passado como parâmetro do repositório de disciplinas
	 * 
	 * @param id
	 * 			Id da disciplina a ser removida
	 */
	void removerDisciplina(String id);
	
	/**
	 * Adiciona a disciplina que tem o id especificado no parâmetro ao aluno com o id passado como parâmetro 
	 * @param idAluno
	 * 				Id do aluno que terá uma disciplina adicionada
	 * @param idDisc
	 * 				Id da disciplina a ser adicionada ao aluno
	 */
	void addDisciplina(String idAluno, String idDisc);
	
	
	
	
}
