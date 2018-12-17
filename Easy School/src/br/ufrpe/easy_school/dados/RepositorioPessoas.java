package br.ufrpe.easy_school.dados;

import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.beans.Aluno;
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
		this.carregarArquivosRepositorioPessoas();
		if(instance == null) {
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
	public void salvarArquivoRepositorioPessoas() {
		File repos = new File("ArquivoBDPessoas.dat");
		ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(repos)));		
		this.ordenarPorOrdemAlfabetica();
		objectOut.writeObject(this.getInstance());
		objectOut.close();
	}

	@Override
	public void carregarArquivosRepositorioPessoas() {
		File repos = new File("ArquivoBDPessoas.dat");
		ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(repos)));
		this.instance = ((this.getClass()) o)objectIn.readObject();
		objectIn.close();
	}


	

}