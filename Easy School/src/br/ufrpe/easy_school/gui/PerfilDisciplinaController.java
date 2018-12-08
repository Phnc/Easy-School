package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.KeepDisciplina;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PerfilDisciplinaController {
	
    @FXML
    private TableView<Aluno> tblAlunos;

    @FXML
    private TableColumn<Aluno, String> colAluno;

    @FXML
    private TableColumn<Aluno, Number> colNota1;

    @FXML
    private TableColumn<Aluno, Number> colNota2;

    @FXML
    private TableColumn<Aluno, Number> colNota3;

    @FXML
    private TableColumn<Aluno, Number> colNota4;

    @FXML
    private TableColumn<Aluno, Number> colFaltas;

    @FXML
    void addFaltas(ActionEvent event) {

    }

    @FXML
    void changeNota1(ActionEvent event) {

    }

    @FXML
    void changeNota2(ActionEvent event) {

    }

    @FXML
    void changeNota3(ActionEvent event) {

    }

    @FXML
    void changeNota4(ActionEvent event) {

    }
    
    @FXML
    public void initialize() {
    	
    	colAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("name"));
    	
    	colNota1.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getDisciplina(KeepDisciplina.getInstance().getDisciplina()).getNota1()));
    	colNota2.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getDisciplina(KeepDisciplina.getInstance().getDisciplina()).getNota2()));
    	colNota3.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getDisciplina(KeepDisciplina.getInstance().getDisciplina()).getNota3()));
    	colNota4.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getDisciplina(KeepDisciplina.getInstance().getDisciplina()).getNota4()));
    	
    	colFaltas.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getDisciplina(KeepDisciplina.getInstance().getDisciplina()).getFaltas()));
    	
    	
    	tblAlunos.setItems(getAlunos());
    }
    
    public ObservableList<Aluno> getAlunos() {
		ObservableList<Aluno> alunos = FXCollections.observableArrayList();
		alunos.addAll(EscolaFachada.getInstance().alunosDisc(KeepDisciplina.getInstance().getDisciplina()));
		
		return alunos;
	}

}
