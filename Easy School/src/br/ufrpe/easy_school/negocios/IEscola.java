package br.ufrpe.easy_school.negocios;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Pessoa;
import br.ufrpe.easy_school.negocios.beans.Professor;
import br.ufrpe.easy_school.negocios.beans.Responsavel;

public interface IEscola {
	/**
	 * Adiciona uma nova pessoa ao reposit�rio, podendo ser aluno, respons�vel ou professor
	 * 
	 * @param pessoa
	 * 				pessoa a ser cadastrada no reposit�rio
	 */
	void cadastrarPessoa(Pessoa pessoa);
	
	/**
	 * Adiciona uma nova disciplina ao reposit�rio
	 * 
	 * @param disciplina
	 * 					disciplina a ser cadastrada no reposit�rio
	 */
	
	void cadastrarDisciplina(Disciplina disciplina);
	
	/**
	 * Busca uma pessoa com o id igual ao do par�metro
	 * 
	 * @param id
	 * 			id da pessoa a ser buscada
	 * @return
	 * 			Pessoa com o id equivalente, ou null, caso ela n�o exista
	 */
	
	Pessoa buscar(String id);
	
	
	/**
	 * Busca uma disciplina com o id passado como par�metro
	 * 
	 * @param id
	 * 			id da disciplina a ser buscada		
	 * 
	 * @return
	 * 			A disciplina que tem o id passado como par�metro ou null, caso ela n�o exista
	 */
	
	Disciplina buscarDisciplina(String id);
	
	/**
	 * Remove a pessoa com o id passado como par�metro do reposit�rio de pessoas
	 * 
	 * @param id
	 * 			id da pessoa a ser removida
	 */
	
	void removerPessoa(String id);
	
	/**
	 * Altera a nota de um aluno do reposit�rio, este m�todo ser� usado exclusivamente por professores
	 * 
	 * @param prof
	 * 				Professor que ensina uma disciplina ao aluno (� ele quem vai alterar a nota)
	 * @param idDisc
	 * 				Id da disciplina na qual o aluno ter� sua nota alterada
	 * @param idAluno
	 * 				Id do aluno a ter a nota alterada
	 * @param unidade
	 * 				A unidade na qual a nota ser� alterada (de 1 a 4)
	 * @param nota
	 * 				A nota a ser colocada naquela unidade (de 0 a 10)
	 */
	
	void mudarNota(Professor prof, String idDisc, String idAluno, int unidade, double nota);
	
	
	/**
	 * M�todo usado por um professor para marcar uma falta de um aluno
	 * 
	 * @param prof
	 * 				Professor que ensina uma disciplina ao aluno (� ele quem vai marcar a falta)
	 * @param idDisc
	 * 				Id da disciplina na qual o aluno ter� sua nota alterada
	 * @param idAluno
	 * 				Id do aluno a ter a nota alterada
	 */
	
	void marcarFalta(Professor prof, String idDisc, String idAluno);
	
	/**
	 * M�todo para efetuar o login de um usu�rio
	 * @param id
	 * 			id do usu�rio que est� tentando efetuar login
	 * @param password
	 * 					senha do usu�rio que est� tentando efetuar login
	 */
	
	boolean efetuarLogin(String id, String password);
	
	/**
	 * Adiciona um aluno a um respons�vel
	 * @param idAluno
	 * 				Id do aluno a ser adicionado
	 * @param idResponsavel
	 * 						Id do respons�vel associado a esse aluno
	 */
	
	void addAluno(String idAluno, String idResponsavel);
	
	/**
	 * Remove uma disciplina com o id passado como par�metro do reposit�rio de disciplinas
	 * 
	 * @param id
	 * 			Id da disciplina a ser removida
	 */
	void removerDisciplina(String id);
	
	/**
	 * Adiciona a disciplina que tem o id especificado no par�metro ao aluno com o id passado como par�metro 
	 * @param idAluno
	 * 				Id do aluno que ter� uma disciplina adicionada
	 * @param idDisc
	 * 				Id da disciplina a ser adicionada ao aluno
	 */
	void addDisciplina(String idAluno, String idDisc);
	

	/**
	 * Retorna uma lista de disciplinas ensinadas por um professor
	 * 
	 * @param prof
	 * 			  Professor que ensina as disciplinas
	 * @return
	 * 		  Lista de disciplinas ensinadas pelo professor
	 */
	
	ArrayList<Disciplina> arrayDisc(Professor prof);
	
	/**
	 * Retorna uma lista de alunos que cursam uma disciplina
	 * 
	 * @param disc
	 * 			  Disciplina que os alunos cursam
	 * @return
	 * 		  Lista de alunos que cursam a disciplina passada comom par�metro
	 */
	ArrayList<Aluno> alunosDisc(Disciplina disc);
	
	/**
	 * Devolve uma lista com todos os alunos cadastrados at� o momento
	 * @return
	 * 		  Lista com todos os alunos do sistema
	 */
	ArrayList<Aluno> getAlunos();
	
	/**
	 * Devolve uma lista com todos os professores cadastrados at� o momento
	 * @return
	 * 		  lista com todos os professores do sistema
	 */
	ArrayList<Professor> getProfessores();
	
	/**
	 * Devolve uma lista com todos os responsaveis cadastrados at� o momento 
	 * @return
	 * 		 lista com todos os responsaveis do sistema
	 */
	ArrayList<Responsavel> getResponsaveis();
	
	/**
	 * Devolve uma lsita com todas as disciplinas cadastradas at� o momento
	 * @return
	 * 		  lista com todas as disciplinas do sistema
	 */
	ArrayList<Disciplina> getDisciplinas();
	
	/**
	 * Devolve a lista de pessoas responsaveis por um aluno  
	 * @param aluno
	 * 			   Aluno da qual as pessoas sao responsaveis
	 * @return
	 * 		  Lista de responsaveis do aluno passado como par�metro
	 */
	
	public ArrayList<Responsavel> responsaveisAluno(Aluno aluno);
	
	/**
	 * salva todos os dados do sistema
	 */
	public void salvarSistema();
	
}
