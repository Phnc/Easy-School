package br.ufrpe.easy_school.negocios;

import br.ufrpe.easy_school.dados.IRepositorioDisciplinas;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;

public class CadastroDisciplinas {
	
	IRepositorioDisciplinas repositorio;

	public CadastroDisciplinas(IRepositorioDisciplinas instanciaRepositorio) {
		super();
		this.repositorio = instanciaRepositorio;
	}
	
	public void cadastrar(Disciplina d) {
		if(d == null) {
			//exception
		}
		else {
			if(!this.existe(d.getId())) {
				this.repositorio.cadastrar(d);
			}
		}
		
		
		
	}
	
	public void cadastrar(String nome, Professor professor, String id) {
		Disciplina temp = new Disciplina(nome, professor, id);
		this.cadastrar(temp);
		
	}
	
	
	public void descadastrar(String id) {
		Disciplina d = this.buscar(id);
		if(d == null) {
			//disciplina nao cadastrada exception
		}
		else {
			this.repositorio.remover(id);;
		}
	}
	
	public Disciplina buscar(String id) {
		return this.repositorio.buscar(id);
	}
	
	public boolean existe(String id) {
		return this.repositorio.existe(id);
	}
	
	public void remover(String id) {
		this.repositorio.remover(id);
	}
	

}
