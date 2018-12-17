package br.ufrpe.easy_school.dados;

import java.io.File;
import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;

public class RepositorioDisciplinas implements IRepositorioDisciplinas, Serializable {
	
	private ArrayList<Disciplina> disciplinas;
	
	private static RepositorioDisciplinas instance;
	
	private RepositorioDisciplinas() {
		this.disciplinas = new ArrayList<Disciplina>(1);
	}
	
	
	public static RepositorioDisciplinas getInstance() {
		this.carregarArquivosRepositorioDisciplinas();
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

	public void ordenarPorOrdemAlfabetica() {
		/*
		 * CRIAR MÉTODO DE ORDENAÇÃO POR ORDEM ALFABÉTICA.
		 */
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
	
	@Override
	public void salvarArquivosRepositorioDisciplinas() {
		File repos = new File("ArquivoBDDisciplinas.dat");
		ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(repos)));		
		this.ordenarPorOrdemAlfabetica();
		objectOut.writeObject(this.getInstance());
		objectOut.close();
	}

	@Override
	public void carregarArquivosRepositorioDisciplinas() {
		File repos = new File("ArquivoBDDisciplinas.dat");
		ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(repos)));
		this.instance = ((this.getClass()) o)objectIn.readObject();
		objectIn.close();
	}


}
