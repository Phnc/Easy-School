package br.ufrpe.easy_school.negocios.beans;

import java.util.ArrayList;

public class Responsavel {
	//Um responsavel pode ter mais de um filho, por isso um arraylist
	//O arrayList de reclamacoes representa mensagens enviadas pelos professores
	//O arraylist de notificacoes representa mensagens da diretoria
	
	
	private ArrayList<Aluno> filhos;
	private ArrayList<String> reclamacoes;
	private ArrayList<String> notificacoes;

}
