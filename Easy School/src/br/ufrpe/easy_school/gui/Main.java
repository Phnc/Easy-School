package br.ufrpe.easy_school.gui;
	
import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.IEscola;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ScreenManager.getInstance().setMainStage(primaryStage);
			ScreenManager.getInstance().showCena1();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		IEscola fachada = EscolaFachada.getInstance();
		fachada = EscolaFachada.getInstance();
        fachada.cadastrarPessoa(new Aluno("Paulo", "1010", "1010"));
        fachada.cadastrarPessoa(new Aluno("Guilherme", "0412", "0412"));
        fachada.cadastrarPessoa(new Professor("Leandro Marques", "1234", "12345"));
		fachada.cadastrarDisciplina(new Disciplina("Programação 2", (Professor)fachada.buscar("1234"), "1472"));
		fachada.cadastrarPessoa(new Professor("Rodrigo Souza", "6789", "6789"));
		fachada.cadastrarDisciplina(new Disciplina("Algoritmos e Estrutura de Dados", (Professor)fachada.buscar("6789"), "4040"));
		fachada.addDisciplina("1010", "4040");
		fachada.addDisciplina("1010", "1472");
		
		fachada.mudarNota((Professor)fachada.buscar("1234"), "1472", "1010", 1, 9);
		fachada.mudarNota((Professor)fachada.buscar("1234"), "1472", "1010", 2, 10);
		fachada.mudarNota((Professor)fachada.buscar("1234"), "1472", "1010", 3, 8.5);
		fachada.mudarNota((Professor)fachada.buscar("1234"), "1472", "1010", 4, 9.5);
		
		fachada.mudarNota((Professor)fachada.buscar("6789"), "4040", "1010", 1, 9);
		fachada.mudarNota((Professor)fachada.buscar("6789"), "4040", "1010", 2, 10);
		fachada.mudarNota((Professor)fachada.buscar("6789"), "4040", "1010", 3, 8.5);
		fachada.mudarNota((Professor)fachada.buscar("6789"), "4040", "1010", 4, 9.5);
		launch(args);
	}
}
