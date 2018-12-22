package br.ufrpe.easy_school.negocios;

public class Mensagem {
	
	private String mensagem;
	private String resposta;
	
	public Mensagem(String mensagem, String resposta) {
		super();
		this.mensagem = mensagem;
		this.resposta = resposta;
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
