package br.ufrpe.easy_school.negocios;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Mensagem {
	
	private String titulo;
	private String mensagem;
	private String resposta;
	
	public Mensagem(String titulo, String mensagem, String resposta) {
		super();
		this.setTitulo(titulo);
		this.setMensagem(mensagem);
		this.resposta = resposta;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo != null && titulo.length() > 0 && !titulo.equals("")) {
			this.titulo = titulo;
		}
		else {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText("O t�tulo da sua mensagem n�o pode ser vazio");
			a.show();
		}
		
	}
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		if(mensagem != null && mensagem.length() > 0 && !mensagem.equals("")) {
			this.mensagem = mensagem;
		}
		else {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText("A sua mensagem n�o pode ser vazia");
			a.show();
		}
		
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		if(resposta != null && resposta.length() > 0 && !resposta.equals("")) {
			this.resposta = resposta;
		}
		else {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText("Sua resposta n�o pode ser vazia");
			a.show();
		}
	}
	
	@Override 
	public String toString() {
		
		String s = "";
		s += "Titulo " + this.titulo + "\n";
		s += "Mensagem " + this.mensagem + "\n";
		s += "Resposta: " + this.resposta + "\n";
		return s;
	}
	
}
