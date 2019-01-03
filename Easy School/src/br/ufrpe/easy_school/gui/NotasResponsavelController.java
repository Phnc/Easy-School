package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.KeepPerson;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class NotasResponsavelController {
	
	public Responsavel a;
	
	@FXML
    private Label lblName;

    @FXML
    private TableView<Disciplina> tableDisc;

    @FXML
    private TableColumn<Disciplina, String> columnDisc;

    @FXML
    private TableColumn<Disciplina, Double> columnNota1;

    @FXML
    private TableColumn<Disciplina, Double> columnNota2;

    @FXML
    private TableColumn<Disciplina, Double> columnNota3;

    @FXML
    private TableColumn<Disciplina, Double> columnNota4;
    
    @FXML
    private TableColumn<Disciplina, Integer> columnFaltas;
    
    @FXML
    private Button btnLogout;
    
    @FXML
    private Button btnVoltar;

    @FXML
    void logout(ActionEvent event) {
    	KeepPerson.getInstance().setPessoa(null);
    	ScreenManager.getInstance().showCena1();
    }
	 
    
    
}
