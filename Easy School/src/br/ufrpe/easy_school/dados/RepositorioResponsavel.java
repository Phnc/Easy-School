package br.ufrpe.easy_school.dados;

import java.util.ArrayList;


import br.ufrpe.easy_school.negocios.beans.Responsavel;

public class RepositorioResponsavel {
	
	private static RepositorioResponsavel instance;
	private ArrayList<Responsavel> responsaveis;
	
	private RepositorioResponsavel() {
		this.responsaveis = new ArrayList<Responsavel>(1);
	}
	
	
	public void addResponsavel(Responsavel resp) {
		this.responsaveis.add(resp);
	}
	
	public void removerResponsavel(Responsavel resp) {
		this.responsaveis.remove(resp);
	}
	
	
	
	
	public static RepositorioResponsavel getInstance() {
		if(instance == null) {
			instance = new RepositorioResponsavel();
		}
		return instance;
	}
	
	
	public Responsavel acessarResponsavel(String id) {
		for(int i = 0; i < this.responsaveis.size(); i++) {
			if(this.responsaveis.get(i).getId().equals(id)) {
				return this.responsaveis.get(i);
			}
		}
		
		return null;
	}
	
	
	
	public boolean existe(String id) {
		boolean existe = false;
		for(int i = 0; i < this.responsaveis.size(); i++) {
			if(this.responsaveis.get(i).getId().equals(id)) {
				existe = true;
			}
			
		}
		return existe;
	}
	
	

}
