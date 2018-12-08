package br.ufrpe.easy_school.dados;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;

public class RepositorioDisciplinas implements IRepositorioDisciplinas {
	
	private ArrayList<Disciplina> disciplinas;
	
	private static RepositorioDisciplinas instance;
	
	private RepositorioDisciplinas() {
		this.disciplinas = new ArrayList<Disciplina>(1);
	}
	
	
	public static RepositorioDisciplinas getInstance() {
		if(instance == null) {
			instance = new RepositorioDisciplinas();
		}
		return instance;
	}

	@Override
	public void cadastrar(Disciplina disc) {
		// TODO Auto-generated method stub
		this.disciplinas.add(disc);

	}

	@Override
	public void cadastrar(String nome, Professor professor, String id) {
		// TODO Auto-generated method stub
		Disciplina temp = new Disciplina(nome, professor, id);
		this.cadastrar(temp);

	}



	@Override
	public Disciplina buscar(String id) {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).getId().equals(id)) {
				return this.disciplinas.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean existe(String id) {
		// TODO Auto-generated method stub
		boolean retorno = false;
		for(int i = 0; i < this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).getId().equals(id)) {
				retorno = true;
			}
		}
		return retorno;
	}



	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub
		this.disciplinas.remove(this.buscar(id));

	}
	
	@Override
	public ArrayList<String> arrayDisc(Professor prof){
		ArrayList<String> devolver = new ArrayList<>();
		for(int i = 0; i <this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).getProfessor().equals(prof)) {
				devolver.add(this.disciplinas.get(i).getId());
			}
		}
		return devolver;
	}



}
