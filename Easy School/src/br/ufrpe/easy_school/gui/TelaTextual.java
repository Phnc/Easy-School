package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.IEscola;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;

public class TelaTextual {

	public void executaOperacoes() {
		IEscola fachada = EscolaFachada.getInstance();
		fachada.cadastrarPessoa(new Aluno("Paulo", "1010", "1010"));
		fachada.cadastrarPessoa(new Professor("Leandro Marques", "1234", "12345"));
		fachada.cadastrarDisciplina(new Disciplina("Programação 2", (Professor)fachada.buscar("1234"), "1472"));
		fachada.addDisciplina("1010", "1472");
		fachada.mudarNota((Professor)fachada.buscar("1234"), "1472", "1010", 1, 9);
		fachada.marcarFalta((Professor)fachada.buscar("1234"), "1472", "1010");
		System.out.println((Aluno)fachada.buscar("1010"));
		
	}
	
}
