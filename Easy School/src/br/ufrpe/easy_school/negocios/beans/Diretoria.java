package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.Mensagem;

public class Diretoria extends Pessoa{

	public Diretoria(String name, String id, String password) {
		super(name, id, password);
		this.mensagens = new ArrayList<Mensagem>();
		// TODO Auto-generated constructor stub
	}
	
	private ArrayList<Mensagem> mensagens;

	public ArrayList<Mensagem> getMensagens() {
		return mensagens;
	}

}
