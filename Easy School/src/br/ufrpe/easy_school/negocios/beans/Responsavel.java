package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.Mensagem;

import java.io.Serializable;

public class Responsavel extends Pessoa implements Serializable{
	

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
		devolver += "Alunos: ";
		devolver += "\n";
		for(int i = 0; i < this.alunos.size(); i++) {
			devolver += "\n";
			devolver += this.alunos.get(i);
		}
		return devolver;
	}

	public ArrayList<Aluno> getAlunos(){
		return this.alunos;
	}
	
	public ArrayList<Mensagem> getMensagens(){
		return this.mensagens;
	}

}
