package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.KeepPerson;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class NotasResponsavelController {
	
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
	 
    @FXML
    void goBack(ActionEvent event) {
    	ScreenManager.getInstance().showPerfilResponsavel();
    }
    
    

    public void iniciarTabela(Aluno a) {
    	lblName.setText(a.getName());
    	columnDisc.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("nome"));
    	columnNota1.setCellValueFactory(new PropertyValueFactory<Disciplina, Double>("Nota1"));
    	columnNota2.setCellValueFactory(new PropertyValueFactory<Disciplina, Double>("Nota2"));
    	columnNota3.setCellValueFactory(new PropertyValueFactory<Disciplina, Double>("Nota3"));
    	columnNota4.setCellValueFactory(new PropertyValueFactory<Disciplina, Double>("Nota4"));
    	columnFaltas.setCellValueFactory(new PropertyValueFactory<Disciplina, Integer>("faltas"));    	
    	tableDisc.setItems(getDisciplinas(a));
    }
    
    @FXML
    public void initialize() {
    			
    }

	private ObservableList<Disciplina> getDisciplinas(Aluno a) {
		ObservableList<Disciplina> disciplinas = FXCollections.observableArrayList();
		disciplinas.addAll(a.getDisciplinas());
		
		return disciplinas;
	}
	
    
    
    
}
