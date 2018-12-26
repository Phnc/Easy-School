package br.ufrpe.easy_school.dados;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Diretoria;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Pessoa;
import br.ufrpe.easy_school.negocios.beans.Professor;
import br.ufrpe.easy_school.negocios.beans.Responsavel;


public class RepositorioPessoas implements IRepositorioPessoas, Serializable{
	
	private ArrayList<Pessoa> pessoas;

	
	
	private static RepositorioPessoas instance;
	
	private RepositorioPessoas() {
		this.pessoas = new ArrayList<Pessoa>(1);
	}
	
	public static RepositorioPessoas getInstance() {
		if(instance == null) {
			//RepositorioPessoas.instance.carregarArquivosRepositorioPessoas();
			instance = new RepositorioPessoas();
		}
		return instance;
	}

	@Override
	public void cadastrar(Pessoa pessoa) {

		this.pessoas.add(pessoa);
		
	}

	@Override
	public void cadastrar(String nome, String id, String password) {
		// TODO Auto-generated method stub
		Pessoa temp = new Pessoa(nome, id, password);
		this.cadastrar(temp);
		
	}

	@Override
	public Pessoa buscar(String id) {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.pessoas.size(); i++) {
			if(this.pessoas.get(i).getId().equals(id)) {
				
				if(this.pessoas.get(i) instanceof Aluno) {
					return (Aluno)this.pessoas.get(i);
				}
				
				if(this.pessoas.get(i) instanceof Professor) {
					return (Professor)this.pessoas.get(i);
				}
				
				if(this.pessoas.get(i) instanceof Responsavel) {
					return (Responsavel)this.pessoas.get(i);
				}
				
				if(this.pessoas.get(i) instanceof Diretoria) {
					return (Diretoria)this.pessoas.get(i);
				}
				
				
			}
		}
		
		return null;
	}

	@Override
	public boolean existe(String id) {
		// TODO Auto-generated method stub
		boolean retorno = false;
		for(int i = 0; i < this.pessoas.size(); i++) {
			if(this.pessoas.get(i).getId().equals(id)) {
				retorno = true;
				break;
			}
		}
		return retorno;
	}

	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub
		this.pessoas.remove(this.buscar(id));
		
	}

	public void ordenarPorOrdemAlfabetica() {
		/*
		 * CRIAR MÉTODO DE ORDENAÇÃO POR ORDEM ALFABETICA;
		 */
	}
	
	@Override
	public ArrayList<Aluno> alunosDisc(Disciplina disc) {
		// TODO Auto-generated method stub
		ArrayList<Aluno> alunos = new ArrayList<>();
		
		for(int i = 0; i < this.pessoas.size(); i++) {
			
			if(this.pessoas.get(i) instanceof Aluno && ((Aluno) this.pessoas.get(i)).cursa(disc)) {
				
					alunos.add((Aluno) this.pessoas.get(i));
				
			}
			
		}
		return alunos;
	}

	
	@Override
	public void salvarArquivosRepositorioPessoas() {
		File repos = new File("ArquivoBDPessoas.dat");
		ObjectOutputStream objectOut;
		try {
			objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(repos)));
			this.ordenarPorOrdemAlfabetica();
			objectOut.writeObject(RepositorioDisciplinas.getInstance());
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	public void carregarArquivosRepositorioPessoas() {
		File repos = new File("ArquivoBDPessoas.dat");
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(repos)));
			RepositorioPessoas.instance = (RepositorioPessoas)objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public ArrayList<Aluno> getAlunos() {
		// TODO Auto-generated method stub
		ArrayList<Aluno> alunos = new ArrayList<>();
		for(int i = 0; i < this.pessoas.size(); i++) {
			if(this.pessoas.get(i) instanceof Aluno) {
				alunos.add((Aluno) this.pessoas.get(i));
			}
		}
		return alunos;
	}
	
	@Override
	public ArrayList<Professor> getProfessores(){
		ArrayList<Professor> lista = new ArrayList<>();
		for(int i = 0; i < this.pessoas.size(); i++) {
			if(this.pessoas.get(i) instanceof Professor) {
				lista.add((Professor) this.pessoas.get(i));
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Responsavel> getResponsaveis() {
		// TODO Auto-generated method stub
		ArrayList<Responsavel> lista = new ArrayList<>();
		for(int i = 0; i < this.pessoas.size(); i++) {
			if(this.pessoas.get(i) instanceof Responsavel) {
				lista.add((Responsavel) this.pessoas.get(i));
			}
		}
		return lista;
		
	}

	@Override
	public ArrayList<Responsavel> responsaveisAluno(Aluno aluno) {
		ArrayList<Responsavel> lista = new ArrayList<>();
		for(int i = 0; i < this.pessoas.size(); i++) {
			if(this.pessoas.get(i) instanceof Responsavel) {
				if(((Responsavel)this.pessoas.get(i)).getAlunos().contains(aluno)) {
					lista.add((Responsavel) this.pessoas.get(i));
				}
			}
		}
		return lista;
	}

}
