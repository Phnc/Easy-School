package br.ufrpe.easy_school.negocios;

import br.ufrpe.easy_school.negocios.beans.Disciplina;

public class KeepDisciplina {
	
	/**
	 * Esta classe serve para manter uma referência para a disciplina selecionada pelo professor em seu perfil
	 */
	
	public static KeepDisciplina instance;
	private Disciplina disciplina;
	
	private KeepDisciplina() {
		// TODO Auto-generated constructor stub
	}
	
	public static KeepDisciplina getInstance() {
        if (instance == null) {
            instance = new KeepDisciplina();
        } 
        
        return instance; 
    }

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disc) {
		this.disciplina = disc;
	}

}
