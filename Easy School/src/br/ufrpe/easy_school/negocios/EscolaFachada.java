package br.ufrpe.easy_school.negocios;

import java.util.ArrayList;

import br.ufrpe.easy_school.dados.RepositorioDisciplinas;
import br.ufrpe.easy_school.dados.RepositorioPessoas;
import br.ufrpe.easy_school.exceptions.DisciplinaJaExistenteException;
import br.ufrpe.easy_school.exceptions.DisciplinaNaoExistenteException;
import br.ufrpe.easy_school.exceptions.PessoaNaoExistenteException;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Pessoa;
import br.ufrpe.easy_school.negocios.beans.Professor;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EscolaFachada implements IEscola{
	
	private CadastroDisciplinas disciplinas;
	private CadastroPessoas pessoas;
	
	
	private static IEscola instance;
	
	private EscolaFachada() {
		this.disciplinas = new CadastroDisciplinas(RepositorioDisciplinas.getInstance());
		this.pessoas = new CadastroPessoas(RepositorioPessoas.getInstance());
	}
	
	public static IEscola getInstance() {
		if(instance == null) {
			instance = new EscolaFachada();
		}
		return instance;
	}



	@Override
	public void cadastrarPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		try {
			this.pessoas.cadastrar(pessoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.setTitle("Pessoa já cadastrada");
			a.show();
		}
		
	}

	

	@Override
	public void removerPessoa(String id) {
		// TODO Auto-generated method stub
		this.pessoas.remover(id);
		
	}

	@Override
	public void mudarNota(Professor prof, String idDisc, String idAluno, int unidade, double nota) {
		// TODO Auto-generated method stub
		try {
			this.pessoas.mudarNota(prof, idDisc, idAluno, unidade, nota);
		} catch (PessoaNaoExistenteException e) {
			// TODO Auto-generated catch block
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.setTitle("Pessoa não existe");
			a.show();
		}
		
	}

	@Override
	public boolean efetuarLogin(String id, String password) {
		// TODO Auto-generated method stub
		try {
			return this.pessoas.efetuarLogin(id, password);
		} catch (PessoaNaoExistenteException e) {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.setTitle("Pessoa não existe");
			a.show();
			return false;
		}
		
	}

	@Override
	public void cadastrarDisciplina(Disciplina disciplina) {
		// TODO Auto-generated method stub
		try {
			this.disciplinas.cadastrar(disciplina);
		} catch (DisciplinaJaExistenteException e) {
			// TODO Auto-generated catch block
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.setTitle("Disciplina já cadastrada");
			a.show();
		}
		
	}

	@Override
	public Pessoa buscar(String id) {
		// TODO Auto-generated method stub
		
		try {
			return this.pessoas.buscar(id);
		} catch (PessoaNaoExistenteException e) {
			// TODO Auto-generated catch block
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.setTitle("Pessoa não existe");
			a.show();
			return null;
		}
	}

	@Override
	public void addAluno(String idAluno, String idResponsavel) {
		// TODO Auto-generated method stub
		try {
			this.pessoas.addAluno(idAluno, idResponsavel);
		} catch (PessoaNaoExistenteException e) {
			// TODO Auto-generated catch block
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.setTitle("Pessoa não existe");
			a.show();
		}
		
	}

	@Override
	public Disciplina buscarDisciplina(String id) {
		// TODO Auto-generated method stub
		try {
			return this.disciplinas.buscar(id);
		} catch (DisciplinaNaoExistenteException e) {
			// TODO Auto-generated catch block
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.setTitle("Disciplina não existente");
			a.show();
		}
		return null;
	}

	@Override
	public void removerDisciplina(String id) {
		// TODO Auto-generated method stub
		try {
			this.disciplinas.remover(id);
		} catch (DisciplinaNaoExistenteException e) {
			// TODO Auto-generated catch block
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.setTitle("Disciplina não existente");
			a.show();
		}
		
	}

	@Override
	public void addDisciplina(String idAluno, String idDisc) {
		// TODO Auto-generated method stubs
		Disciplina d = this.buscarDisciplina(idDisc);
		try {
			this.pessoas.addDisciplina(idAluno, d);
		} catch (PessoaNaoExistenteException e) {
			// TODO Auto-generated catch block
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.setTitle("Pessoa não existe");
			a.show();
		}
		
	}

	@Override
	public void marcarFalta(Professor prof, String idDisc, String idAluno) {
		// TODO Auto-generated method stub
		try {
			this.pessoas.marcarFalta(prof, idDisc, idAluno);
		} catch (PessoaNaoExistenteException e) {
			// TODO Auto-generated catch block
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.setTitle("Pessoa não existe");
			a.show();
		}
		
	}
	
	@Override
	public ArrayList<Disciplina> arrayDisc(Professor prof){
		return this.disciplinas.arrayDisc(prof);
	}

	public ArrayList<Aluno> alunosDisc(Disciplina disc){
		return this.pessoas.alunosDisc(disc);
	}

	@Override
	public ArrayList<Aluno> getAlunos() {
		// TODO Auto-generated method stub
		return this.pessoas.getAlunos();
	}

	@Override
	public ArrayList<Professor> getProfessores() {
		// TODO Auto-generated method stub
		return this.pessoas.getProfessores();
	}
	
	@Override
	public ArrayList<Responsavel> getResponsaveis(){
		return this.pessoas.getResponsaveis();
	}
	
	@Override
	public ArrayList<Disciplina> getDisciplinas(){
		return this.disciplinas.getDisciplinas();
	}

	@Override
	public ArrayList<Responsavel> responsaveisAluno(Aluno aluno) {
		return this.pessoas.responsaveisAluno(aluno);
	}

	@Override
	public void salvarSistema() {
		this.disciplinas.repositorio.salvarArquivosRepositorioDisciplinas();
		this.pessoas.repositorio.salvarArquivosRepositorioPessoas();
		
	}

}
