package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.KeepPerson;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Professor;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Scene1Controller {
	

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtId;

    @FXML
    private Button btnLogin;

    @FXML
    void realizarLogin(ActionEvent event) {
    	if(txtId.getText().isEmpty() || txtSenha.getText().isEmpty()) {
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
        			txtId.setText(null);
        			txtSenha.setText(null);
        			ScreenManager.getInstance().showPerfilAluno();
        		}
        		
        		if(EscolaFachada.getInstance().buscar(txtId.getText()) instanceof Professor) {
        			KeepPerson.getInstance().setPessoa((Professor) EscolaFachada.getInstance().buscar(txtId.getText()));
        			txtId.setText(null);
        			txtSenha.setText(null);
        			ScreenManager.getInstance().showPerfilProfessor();
        		}
        		
        		if(EscolaFachada.getInstance().buscar(txtId.getText()) instanceof Responsavel) {
        			KeepPerson.getInstance().setPessoa((Responsavel) EscolaFachada.getInstance().buscar(txtId.getText()));
        			txtId.setText(null);
        			txtSenha.setText(null);
        			ScreenManager.getInstance().showPerfilResponsavel();
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
