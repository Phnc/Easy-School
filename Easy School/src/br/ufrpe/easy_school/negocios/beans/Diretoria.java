package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.Mensagem;

public class Diretoria extends Pessoa{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7034555301643669115L;
	private ArrayList<Mensagem> mensagens;
	
	public Diretoria(String name, String id, String password) {
		super(name, id, password);
		this.mensagens = new ArrayList<Mensagem>(1);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Mensagem> getMensagens() {
		return mensagens;
	}
	
	public void addMensagem(Mensagem m) {
		this.mensagens.add(m);
	}
	
	public void removeMensagem(Mensagem mensagem) {
		this.mensagens.remove(mensagem);
	}
}
