package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.KeepPerson;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class PerfilResponsavelController {

    @FXML
    private ChoiceBox<Aluno> choiceAluno;

    @FXML
    private Button btnVerNotas;

    @FXML
    private Label lblNome;

    @FXML
    void mostrarAlunoSelecionado(ActionEvent event) {
    	
    }

    
    @FXML
    public void initialize(){
    	lblNome.setText("Seja bem-vindo(a), " + KeepPerson.getInstance().getPessoa().getName());
    	ObservableList<Aluno> lista = FXCollections.observableArrayList(((Responsavel)KeepPerson.getInstance().getPessoa()).getAlunos());
    	choiceAluno.setItems(lista);
    	
    			
    }
    
}
