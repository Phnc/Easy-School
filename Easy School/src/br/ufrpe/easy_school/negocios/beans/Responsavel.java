package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.Mensagem;

import java.io.Serializable;

public class Responsavel extends Pessoa implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8975599232833897615L;
	private ArrayList<Aluno> alunos;
	private ArrayList<Mensagem> mensagens;
	
	public Responsavel(String name, String id, String password) {
		super(name, id, password);
		this.alunos = new ArrayList<Aluno>(1);
		this.mensagens = new ArrayList<Mensagem>(1);
	}
	
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	public void removerAluno(Aluno aluno) {
		this.alunos.remove(aluno);
		
	}
	
	public void addMensagem(Mensagem mensagem) {
		this.mensagens.add(mensagem);
	}
	
	public void removeMensagem(Mensagem mensagem) {
		this.mensagens.remove(mensagem);
	}
	

	@Override
	public String toString() {
		String devolver = super.toString();
		return devolver;
	}

	public ArrayList<Aluno> getAlunos(){
		return this.alunos;
	}
	
	public ArrayList<Mensagem> getMensagens(){
		return this.mensagens;
	}

}
