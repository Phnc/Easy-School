package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.KeepPerson;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Diretoria;
import br.ufrpe.easy_school.negocios.beans.Professor;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class Scene1Controller {
	

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtId;

    @FXML
    private Button btnLogin;
    
    @FXML
    void initialize() {
    	txtId.setOnKeyPressed(event -> {
    		   if(event.getCode() == KeyCode.ENTER){
    			     login();
    			   }
    			});
    	
    	txtSenha.setOnKeyPressed(event ->{
    		if(event.getCode() == KeyCode.ENTER) {
    			login();
    		}
    	});
    }

    @FXML
    void realizarLogin(ActionEvent event) {
    	
    	login();

    }
    
    void login() {
    	if(txtId.getText().isEmpty() || txtSenha.getText().isEmpty() || txtId.getText().equals(null) || txtSenha.getText().equals(null)) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Campos vazios");
    		alert.setHeaderText("Algum dos campos esta vazio");
    		alert.setContentText("Todos os campos sao obrigatorios");
    		alert.show();
    	}
    	else {
    		if(EscolaFachada.getInstance().efetuarLogin(txtId.getText(), txtSenha.getText())) {
        		//verificar instanceof e
        		//chamar a cena dedicada a cada tipo de usuário
        		if(EscolaFachada.getInstance().buscar(txtId.getText()) instanceof Aluno) {
        			KeepPerson.getInstance().setPessoa((Aluno) EscolaFachada.getInstance().buscar(txtId.getText()));
        			txtId.setText("");
        			txtSenha.setText("");
        			ScreenManager.getInstance().showPerfilAluno();
        		}
        		
        		if(EscolaFachada.getInstance().buscar(txtId.getText()) instanceof Professor) {
        			KeepPerson.getInstance().setPessoa((Professor) EscolaFachada.getInstance().buscar(txtId.getText()));
        			txtId.setText("");
        			txtSenha.setText("");
        			ScreenManager.getInstance().showPerfilProfessor();
        		}
        		
        		if(EscolaFachada.getInstance().buscar(txtId.getText()) instanceof Responsavel) {
        			KeepPerson.getInstance().setPessoa((Responsavel) EscolaFachada.getInstance().buscar(txtId.getText()));
        			txtId.setText("");
        			txtSenha.setText("");
        			ScreenManager.getInstance().showPerfilResponsavel();
        		}
        		
        		if(EscolaFachada.getInstance().buscar(txtId.getText()) instanceof Diretoria) {
        			KeepPerson.getInstance().setPessoa((Diretoria) EscolaFachada.getInstance().buscar(txtId.getText()));
        			txtId.setText("");
        			txtSenha.setText("");
        			ScreenManager.getInstance().showPerfilDiretoria();
        		}
        		
    		}
    		else {
    			Alert alert = new Alert(AlertType.WARNING);
        		alert.setTitle("Login");
        		alert.setHeaderText("Login nao realizado");
        		alert.setContentText("Login ou senha incorretas");
        		alert.show();
    		}
    	}
    }


}
