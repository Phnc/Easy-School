package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class AddResponsavelWindowController {

	Aluno aluno;
	
	@FXML
	private Label lblNome;
	
    @FXML
    private ChoiceBox<Responsavel> choiceResponsavel;

    @FXML
    private Button btnAddResponsavel;

    @FXML
    private Button btnClose;
    
    
    void setAluno(Aluno a) {
    	this.aluno = a;
    }
    
    @FXML
    void initialize() {
    	choiceResponsavel.setItems(getResponsaveis());
    	Platform.runLater(() -> {

            lblNome.setText(aluno.getName());

        });
    }
    
    public ObservableList<Responsavel> getResponsaveis(){
    	ObservableList<Responsavel> lista = FXCollections.observableArrayList(EscolaFachada.getInstance().getResponsaveis());
    	return lista;
    }
    
    
    @FXML
    void adicionarResponsavel(ActionEvent event) {
    	if(choiceResponsavel.getValue() != null && !choiceResponsavel.getValue().getAlunos().contains(aluno)) {
    		choiceResponsavel.getValue().addAluno(aluno);
    		EscolaFachada.getInstance().salvarSistema();
    		Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
    		
    	}
    	else if(choiceResponsavel.getValue() == null){
    		Alert a = new Alert(AlertType.WARNING);
    		a.setTitle("Operação não realizada");
    		a.setHeaderText("SELECIONE UM RESPONSAVEL");
    		a.setContentText("");
    		a.show();
    	}
    	else if(choiceResponsavel.getValue().getAlunos().contains(aluno)){
    		Alert a = new Alert(AlertType.WARNING);
    		a.setTitle("Operação não realizada");
    		a.setHeaderText("O responsável selecionado já tem este aluno como dependente");
    		a.setContentText("");
    		a.show();
    	}
    }
    
    @FXML
    void fechar(ActionEvent event) {
    	Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    

}