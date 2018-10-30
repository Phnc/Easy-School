package br.ufrpe.easy_school.negocios.beans;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String aux1;
		String aux2;
		boolean auxBool;
		
		//teste metodos da classe Diretoria
		//Diretoria é basicamente um controlador e como os repositorios ainda não foram implementados, eu não implementei os metódos que os utilizam
		Diretoria diretor = new Diretoria("Paulo", "7853");
		
		
		//sinta-se livre para testar com qualquer entrada
		System.out.println("Digite login da diretoria:");
		aux1 = sc.nextLine();
		System.out.println("Digite a senha da diretoria");
		aux2 = sc.nextLine();
		
		sc.close();
		
		auxBool = diretor.login(aux1, aux2);
		
		System.out.println(auxBool);
		
		
		//instanciando um professor para testar disciplinas e alunos
		Professor professor = new Professor("Joao", "joao12", "4458");
		
		
		//instanciando uma disciplina
		Disciplina disc = new Disciplina(professor, "Arte", "5976");
		
		
		//novo aluno
		Aluno aluno = new Aluno("Guilherme", "4589", "8846");
		
		//adicionando uma nova disciplina ao arraylist de disciplinas do aluno
		aluno.addDisciplina(disc);
		
		//imprimindo as notas do aluno na disciplina (por enquanto todas sao 0)
		System.out.println(aluno.getDisciplinas().get(0).toString());
		
		//agora  o professor modificou a nota da unidade 0 (primeira unidade) 
		professor.modificarNota(aluno, 0, 7.0);
		
		//professor adiciona também uma falta ao aluno
		professor.marcarFalta(aluno);
		
		//impressao das caracteristicas do aluno
		System.out.println(aluno.getDisciplinas().get(0).toString());
		
		//criando um novo responsável associado ao Aluno 'aluno'
		Responsavel responsa = new Responsavel("Vania", "4298", "45782");
		responsa.addAluno(aluno);
		
		//toString do responsavel mostrando as notas e faltas dos filhos
		System.out.println(responsa.toString());
		
		
		
		
		

	}

}
