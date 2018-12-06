package br.ufrpe.easy_school.negocios;

import br.ufrpe.easy_school.negocios.beans.Pessoa;

public class KeepPerson {

	public static KeepPerson instance;
	private Pessoa pessoa;
	
	private KeepPerson() {
		// TODO Auto-generated constructor stub
	}
	
	public static KeepPerson getInstance() {
        if (instance == null) {
            instance = new KeepPerson();
        } 
        
        return instance; 
    }

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}
