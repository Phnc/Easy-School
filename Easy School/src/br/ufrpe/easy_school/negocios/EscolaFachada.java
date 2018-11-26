package br.ufrpe.easy_school.negocios;

import br.ufrpe.easy_school.dados.RepositorioDisciplinas;
import br.ufrpe.easy_school.dados.RepositorioPessoas;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Pessoa;
import br.ufrpe.easy_school.negocios.beans.Professor;

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
		this.pessoas.cadastrar(pessoa);
		
	}

	

	@Override
	public void removerPessoa(String id) {
		// TODO Auto-generated method stub
		this.pessoas.remover(id);
		
	}

	@Override
	public void mudarNota(Professor prof, String idDisc, String idAluno, int unidade, double nota) {
		// TODO Auto-generated method stub
		this.pessoas.mudarNota(prof, idDisc, idAluno, unidade, nota);
		
	}

	@Override
	public void efetuarLogin(String id, String password) {
		// TODO Auto-generated method stub
		this.pessoas.efetuarLogin(id, password);
		
	}

	@Override
	public void cadastrarDisciplina(Disciplina disciplina) {
		// TODO Auto-generated method stub
		this.disciplinas.cadastrar(disciplina);
		
	}

	@Override
	public Pessoa buscar(String id) {
		// TODO Auto-generated method stub
		
		return this.pessoas.buscar(id);
	}

	@Override
	public void addAluno(String idAluno, String idResponsavel) {
		// TODO Auto-generated method stub
		this.pessoas.addAluno(idAluno, idResponsavel);
		
	}

	@Override
	public Disciplina buscarDisciplina(String id) {
		// TODO Auto-generated method stub
		return this.disciplinas.buscar(id);
	}

	@Override
	public void removerDisciplina(String id) {
		// TODO Auto-generated method stub
		this.disciplinas.remover(id);
		
	}

	@Override
	public void addDisciplina(String idAluno, String idDisc) {
		// TODO Auto-generated method stubs
		Disciplina d = this.buscarDisciplina(idDisc);
		this.pessoas.addDisciplina(idAluno, d);
		
	}

	@Override
	public void marcarFalta(Professor prof, String idDisc, String idAluno) {
		// TODO Auto-generated method stub
		this.pessoas.marcarFalta(prof, idDisc, idAluno);
		
	}

	

}
