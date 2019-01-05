package br.ufrpe.easy_school.negocios;

import java.io.Serializable;

import br.ufrpe.easy_school.negocios.beans.Pessoa;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Mensagem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7919072713528533823L;
	private String titulo;
	private String mensagem;
	private String resposta;
	private final Pessoa pessoa;
	
	public Mensagem(String titulo, String mensagem, String resposta, Pessoa p) {
		super();
		this.setTitulo(titulo);
		this.setMensagem(mensagem);
		this.resposta = resposta;
		this.pessoa = p;
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
			a.setContentText("O título da sua mensagem não pode ser vazio");
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
			a.setContentText("A sua mensagem não pode ser vazia");
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
			a.setContentText("Sua resposta não pode ser vazia");
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	
}
