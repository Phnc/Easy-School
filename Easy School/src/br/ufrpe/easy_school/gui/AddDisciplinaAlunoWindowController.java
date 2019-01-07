package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
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

public class AddDisciplinaAlunoWindowController {

	Aluno aluno;
	
	public void setAluno(Aluno a) {
		this.aluno = a;
	}
	
	@FXML
	private Label lblNome;
	
	@FXML
	private Button btnAdd;
	
	@FXML
	private Button btnFechar;
	
	@FXML
	private ChoiceBox<Disciplina> choiceDisc;
	
	@FXML
	public void initialize() {
		choiceDisc.setItems(getDisciplinas());
		Platform.runLater(() -> {

            lblNome.setText(aluno.getName());

        });
	}
	
	@FXML
	public void addDisciplina(ActionEvent event) {
		if(choiceDisc.getValue() != null && !aluno.getDisciplinas().contains(choiceDisc.getValue())) {
			aluno.addDisciplina(choiceDisc.getValue());
			EscolaFachada.getInstance().salvarSistema();
			Stage stage = (Stage) btnFechar.getScene().getWindow();
			stage.close();
		}
		else if(choiceDisc.getValue() != null && aluno.getDisciplinas().contains(choiceDisc.getValue())) {
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("Operação não realizada");
			a.setHeaderText("O aluno selecionado já tem esta disciplina associada a ele");
			a.show();
		}
		
		else if(choiceDisc.getValue() == null) {
			Alert a = new Alert(AlertType.WARNING);
			a.setTitle("Operação não realizada");
			a.setHeaderText("Selecione uma disciplina e tente novamente");
			a.show();
		}
	}
	
	
	public ObservableList<Disciplina> getDisciplinas(){
		ObservableList<Disciplina> lista = FXCollections.observableArrayList(EscolaFachada.getInstance().getDisciplinas());
		return lista;
	}
	
	@FXML
	public void fechar(ActionEvent event) {
		Stage stage = (Stage) btnFechar.getScene().getWindow();
		stage.close();
	}
}
