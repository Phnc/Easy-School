package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.KeepPerson;
import br.ufrpe.easy_school.negocios.Mensagem;
import br.ufrpe.easy_school.negocios.beans.Diretoria;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MessageSceneController {
	
    @FXML
    private TextArea textMensagem;

    @FXML
    private TextField txtTitulo;
    
    @FXML
    private Label lblMsg;
    
    @FXML
    private Button btnBack;

    @FXML
    private Button btnSend;
    
    @FXML
    void sendMessage(ActionEvent event) {
    	Mensagem m;
	    	Diretoria d =((Diretoria)EscolaFachada.getInstance().buscar("admin"));
	    	Responsavel r;
	    	if(txtTitulo.getText() != null && !txtTitulo.getText().equals("") && txtTitulo.getText().length() > 0) {
	    		if(textMensagem.getText() != null && !textMensagem.getText().equals("") && textMensagem.getText().length() > 0) {
	    			r = (Responsavel) KeepPerson.getInstance().getPessoa();
	    			m = new Mensagem(txtTitulo.getText(), textMensagem.getText(), " ", r);
	    			d.addMensagem(m);
	    			r.addMensagem(m);
	    			if(d.getMensagens().contains(m) && r.getMensagens().contains(m)) {
	    	    		Alert a = new Alert(AlertType.INFORMATION);
	    	        	a.setTitle("Confirmação da mensagem");
	    	        	a.setHeaderText("");
	    	        	a.setContentText("Mensagem enviada com sucesso!");
	    	        	a.show();
	    	        	ScreenManager.getInstance().showPerfilResponsavel();
	    	    	}
	    		}
	    	}
	    	else {
	    		Alert a = new Alert(AlertType.WARNING);
	    		a.setTitle("Campos vazios");
	    		a.setContentText("Todos os campos são obrigatórios!");
	    		a.setHeaderText("");
	    		a.show();
	    	}
    }
    
    @FXML
    void goBack(ActionEvent event) {
    	ScreenManager.getInstance().showPerfilResponsavel();
    }
    
    @FXML
    public void initialize() {
    	
    	textMensagem.setWrapText(true);
    	
    }

}
