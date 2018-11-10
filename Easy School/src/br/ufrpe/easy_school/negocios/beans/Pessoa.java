package br.ufrpe.easy_school.negocios.beans;

public abstract class Pessoa {
	
	private String name;
	private String id;
	private String password;
	
	public Pessoa(String name, String id, String password) {
		super();
		this.setName(name);
		this.setId(id);
		this.setPassword(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(verificarString(name)) {
			this.name = name;
		}
		else {
			//exception
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(verificarString(id)) {
			this.id = id;
		}
		else {
			//exception
		}
	}

	@SuppressWarnings("unused")
	private String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		if(verificarString(password)) {
			this.password = password;
		}
		else {
			//throw exception
		}
		
	}

	public boolean verificarString(String str) {
		boolean retornar = false;
		if(str != null && !str.isEmpty()) {
			retornar = true;
		}
		return retornar;
	}
	
	public boolean login(String id, String password) {
		
		
		if (id != null && password != null && (id.length() > 1 && password.length() > 1)) {
			if (this.id.equals(id) && this.password.equals(password)) {
				return true;
			} else {
				return false;
			} 
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	@SuppressWarnings("unused")
	private boolean equals(Pessoa outro) {
		if(this.getName().equals(outro.getName()) && this.getId().equals(outro.getId())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	

	@Override
	public String toString() {
		StringBuffer helper = new StringBuffer();
		helper.append("Nome: " + this.name + "\n");
		helper.append("Id: " + this.id + "\n");
		return String.format("%s", helper);
	}
	
	
	

}
