package br.ufrpe.easy_school.negocios;

import br.ufrpe.easy_school.dados.RepositorioAluno;
import br.ufrpe.easy_school.dados.RepositorioDisciplina;
import br.ufrpe.easy_school.dados.RepositorioProfessor;
import br.ufrpe.easy_school.dados.RepositorioResponsavel;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RepositorioAluno repositorioAluno = RepositorioAluno.getInstance();
		RepositorioProfessor repositorioProfessor = RepositorioProfessor.getInstance();
		RepositorioDisciplina repositorioDisciplina = RepositorioDisciplina.getInstance();
		RepositorioResponsavel repositorioResponsavel = RepositorioResponsavel.getInstance();
		
		Diretoria diretoriaTeste = new Diretoria("teste12", "0000", "00001", repositorioAluno, repositorioProfessor, repositorioDisciplina, repositorioResponsavel);
		
		diretoriaTeste.menuTeste();

	}

}
