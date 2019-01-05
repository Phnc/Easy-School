package br.ufrpe.easy_school.negocios;

import java.util.ArrayList;

import br.ufrpe.easy_school.dados.IRepositorioDisciplinas;
import br.ufrpe.easy_school.exceptions.DisciplinaJaExistenteException;
import br.ufrpe.easy_school.exceptions.DisciplinaNaoExistenteException;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CadastroDisciplinas {
	
	IRepositorioDisciplinas repositorio;

	/*
	 * Adicionar this.repositorio.salvarArquivoRepositorioDisciplinas() ao final de todos os métodos.
	 */
	
	public CadastroDisciplinas(IRepositorioDisciplinas instanciaRepositorio) {
		super();
		this.repositorio = instanciaRepositorio;
	}
	
	public void cadastrar(Disciplina d) throws DisciplinaJaExistenteException{
		if(d == null) {
			//exception
		}
		else {
			if(!this.existe(d.getId())) {
				this.repositorio.cadastrar(d);
				this.repositorio.salvarArquivosRepositorioDisciplinas();
			}
			else if(this.existe(d.getId())) {
				Alert a = new Alert(AlertType.WARNING);
				a.setContentText("A disciplina com o presente id já foi cadastrada");
				a.setTitle("Disciplina já cadastrada");
				a.show();
			}
		}
	}
	
	public void cadastrar(String nome, Professor professor, String id) throws DisciplinaJaExistenteException {
		Disciplina temp = new Disciplina(nome, professor, id);
		this.cadastrar(temp);
		this.repositorio.salvarArquivosRepositorioDisciplinas();
		
	}
	
	
	public void descadastrar(String id) throws DisciplinaNaoExistenteException {
		Disciplina d = this.buscar(id);
		if(d == null) {
			//disciplina nao cadastrada exception
		}
		else {
			this.repositorio.remover(id);;
			this.repositorio.salvarArquivosRepositorioDisciplinas();
		}
	}
	
	public Disciplina buscar(String id) throws DisciplinaNaoExistenteException {
		return this.repositorio.buscar(id);
	}
	
	public boolean existe(String id) {
		return this.repositorio.existe(id);
	}
	
	public void remover(String id) throws DisciplinaNaoExistenteException {
		this.repositorio.remover(id);
		this.repositorio.salvarArquivosRepositorioDisciplinas();
	}
	
	public ArrayList<Disciplina> arrayDisc(Professor prof){
		return this.repositorio.arrayDisc(prof);
	}

	public ArrayList<Disciplina> getDisciplinas() {
		// TODO Auto-generated method stub
		return this.repositorio.getDisciplinas();
	}
}


