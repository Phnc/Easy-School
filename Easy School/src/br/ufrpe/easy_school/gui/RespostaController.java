package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.KeepPerson;
import br.ufrpe.easy_school.negocios.Mensagem;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Diretoria;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class RespostaController {
	private Mensagem a;
	@FXML
    private Button btnVoltar;

    @FXML
    private Button btnResponder;

    @FXML
    private TextArea textResp;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextArea textMsg;

    @FXML
    private Label lblTitulo1;
    
    
    @FXML
    void goBack(ActionEvent event) {
    	ScreenManager.getInstance().showMensagens();
    }
    
    
    @FXML 
    public void iniciarTxt(Mensagem a) {
    	this.a = a;
    	if (a != null) {
    		lblTitulo.setText(a.getTitulo());
    		textMsg.setText(a.getMensagem());
    	}
    }
    
    @FXML
    public void enviarResposta() {
    	if (KeepPerson.getInstance().getPessoa() instanceof Responsavel) {
			Mensagem b = new Mensagem(a.getTitulo(), a.getMensagem(),a.getResposta(), a.getPessoa());
			b.setResposta(textResp.getText());
			Responsavel r = (Responsavel) KeepPerson.getInstance().getPessoa();
	    	Diretoria d = (Diretoria) a.getPessoa();
	    	r.removeMensagem(a);
	    	d.removeMensagem(a);
	    	d.addMensagem(b);
			r.addMensagem(b);
			Alert a = new Alert(AlertType.INFORMATION);
	    	a.setTitle("Confirmação da mensagem");
	    	a.setHeaderText("");
	    	a.setContentText("Resposta enviada com sucesso!");
	    	a.show();
			ScreenManager.getInstance().showMensagens();
  		}
    	if (KeepPerson.getInstance().getPessoa() instanceof Diretoria) {
			Mensagem b = new Mensagem(a.getTitulo(), a.getMensagem(),a.getResposta(), a.getPessoa());
			b.setResposta(textResp.getText());
			Responsavel r = (Responsavel) a.getPessoa();
	    	Diretoria d = (Diretoria) KeepPerson.getInstance().getPessoa();
	    	r.removeMensagem(a);
	    	d.removeMensagem(a);
			d.addMensagem(b);
			r.addMensagem(b);
			Alert a = new Alert(AlertType.INFORMATION);
	    	a.setTitle("Confirmação da mensagem");
	    	a.setHeaderText("");
	    	a.setContentText("Resposta enviada com sucesso!");
	    	a.show();
			ScreenManager.getInstance().showMensagens();
  		}
    }
    
    
    
    
}
