package br.ufrpe.easy_school.gui;

import java.io.IOException;

import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.KeepDisciplina;
import br.ufrpe.easy_school.negocios.KeepPerson;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class PerfilProfessorController {


		
    @FXML
    private Label lblNomeProf;

    @FXML
    private ChoiceBox<Disciplina> choiceDisc;

    @FXML
    private Button btnGoDisc;
    
    @FXML
    private Button btnSair;

    @FXML
    void sair(ActionEvent event) {
    	KeepPerson.getInstance().setPessoa(null);
    	ScreenManager.getInstance().showCena1();
    	
    }

    @FXML
    void showDisc(ActionEvent event) {
    	KeepDisciplina.getInstance().setDisciplina(choiceDisc.getValue());
    	ScreenManager.getInstance().showDisc();
		  
    }
    
    @FXML
    public void initialize() {
    	lblNomeProf.setText("Bem vindo(a), " + KeepPerson.getInstance().getPessoa().getName() + "!");
    	ObservableList<Disciplina> opcoes = FXCollections.observableArrayList(EscolaFachada.getInstance().arrayDisc((Professor) KeepPerson.getInstance().getPessoa()));
    	choiceDisc.setItems(opcoes);
    }

}
