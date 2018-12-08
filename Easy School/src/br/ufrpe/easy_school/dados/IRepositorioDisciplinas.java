package br.ufrpe.easy_school.dados;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;

public interface IRepositorioDisciplinas {
	
	void cadastrar(Disciplina disc);
	
	
	void cadastrar(String nome, Professor professor, String id);
		
	Disciplina buscar(String id);
	
	boolean existe(String id);
	
	void remover(String id);
	
	ArrayList<String> arrayDisc(Professor prof);
	

}
