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
    	
    	Diretoria d =((Diretoria)EscolaFachada.getInstance().buscar("admin"));
    	Mensagem m = new Mensagem(txtTitulo.getText(), textMensagem.getText(), " ");
    	d.addMensagem(m);
    	Responsavel r = (Responsavel) KeepPerson.getInstance().getPessoa();
    	r.addMensagem(m);
    	
    	Alert a = new Alert(AlertType.INFORMATION);
    	a.setTitle("Confirmação da mensagem");
    	a.setHeaderText("");
    	a.setContentText("Mensagem enviada com sucesso!");
    	a.show();
    	ScreenManager.getInstance().showPerfilResponsavel();
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
