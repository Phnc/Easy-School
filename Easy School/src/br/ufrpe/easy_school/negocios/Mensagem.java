package br.ufrpe.easy_school.negocios;

public class Mensagem {
	
	private String titulo;
	private String mensagem;
	private String resposta;
	
	public Mensagem(String titulo, String mensagem, String resposta) {
		super();
		this.setTitulo(titulo);
		this.mensagem = mensagem;
		this.resposta = resposta;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	
}
