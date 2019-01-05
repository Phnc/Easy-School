package br.ufrpe.easy_school.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.easy_school.exceptions.DisciplinaJaExistenteException;
import br.ufrpe.easy_school.exceptions.DisciplinaNaoExistenteException;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;

public class RepositorioDisciplinas implements IRepositorioDisciplinas, Serializable {
	

	private static final long serialVersionUID = 942403986564552677L;

	private ArrayList<Disciplina> disciplinas;
	
	private static RepositorioDisciplinas instance;
	
	private RepositorioDisciplinas() {
		this.disciplinas = new ArrayList<Disciplina>(1);
	}
	
	
	public static RepositorioDisciplinas getInstance() {
		
		if(instance == null) {
			instance = carregarArquivosRepositorioDisciplinas();
			//instance = new RepositorioDisciplinas();
		}
		return instance;
	}

	@Override
	public void cadastrar(Disciplina disc) {
		// TODO Auto-generated method stub
		this.disciplinas.add(disc);

	}

	@Override
	public void cadastrar(String nome, Professor professor, String id) throws DisciplinaJaExistenteException{
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
	public Disciplina buscar(String id) throws DisciplinaNaoExistenteException {
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
	public void remover(String id) throws DisciplinaNaoExistenteException {
		// TODO Auto-generated method stub
		this.disciplinas.remove(this.buscar(id));

	}
	
	@Override
	public ArrayList<Disciplina> arrayDisc(Professor prof){
		ArrayList<Disciplina> devolver = new ArrayList<>();
		for(int i = 0; i <this.disciplinas.size(); i++) {
			if(this.disciplinas.get(i).getProfessor().equals(prof)) {
				devolver.add(this.disciplinas.get(i));
			}
		}
		return devolver;
	}
	
	private static RepositorioDisciplinas carregarArquivosRepositorioDisciplinas() {
		RepositorioDisciplinas localInstance = null;
		File in = new File("ArquivoBDDisciplinas.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			localInstance = (RepositorioDisciplinas) obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ois != null) {
				try {
					ois.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		return localInstance;
	}
	
	@Override
	public void salvarArquivosRepositorioDisciplinas() {
		File repos = new File("ArquivoBDDisciplinas.dat");
		ObjectOutputStream objectOut = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(repos);
			objectOut = new ObjectOutputStream(fos);
			objectOut.writeObject(instance);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(objectOut != null) {
				try {
					objectOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}




	@Override
	public ArrayList<Disciplina> getDisciplinas() {
		// TODO Auto-generated method stub
		return this.disciplinas;
	}


}




