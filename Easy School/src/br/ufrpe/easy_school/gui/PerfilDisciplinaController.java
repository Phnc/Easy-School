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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class PerfilDisciplinaController {
	Aluno selecionado;
	
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
    private TextField txtNota2;

    @FXML
    private TextField txtNota4;

    @FXML
    private TextField txtNota3;

    @FXML
    private TextField txtNota1;
    
    @FXML
    private Label lblAluno;
    
    @FXML
    private Button btnSalvar;
    
    @FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnMarcarFalta;
    
    @FXML
    private Button btnRemoverFalta;
    
    @FXML
    void voltar(ActionEvent event) {
    	KeepDisciplina.getInstance().setDisciplina(null);
    	ScreenManager.getInstance().showPerfilProfessor();
    }

    @FXML
    void addFaltas(ActionEvent event) {
    	selecionado.getDisciplina(KeepDisciplina.getInstance().getDisciplina()).marcarFalta();
    	tblAlunos.refresh();
    }
    
    @FXML
    void removerFalta(ActionEvent event) {
    	selecionado.getDisciplina(KeepDisciplina.getInstance().getDisciplina()).removerFalta();
    	tblAlunos.refresh();
    }

    @FXML
    void salvarStatus() {
    	if(txtNota1.getText() != null && !txtNota1.getText().isEmpty()) {
    		double nota = Double.parseDouble(txtNota1.getText());
    		if(nota >=0 && nota <= 10) {
    			selecionado.getDisciplina(KeepDisciplina.getInstance().getDisciplina()).mudarNota(1, Double.parseDouble(txtNota1.getText()));
    		}
    		
    	}
    	
    	if(txtNota2.getText() != null && !txtNota2.getText().isEmpty()) {
    		double nota = Double.parseDouble(txtNota2.getText());
    		if(nota >=0 && nota <= 10) {
    			selecionado.getDisciplina(KeepDisciplina.getInstance().getDisciplina()).mudarNota(2, Double.parseDouble(txtNota2.getText()));
    		}
    		
    	}
    	
    	if(txtNota3.getText() != null && !txtNota3.getText().isEmpty()) {
    		double nota = Double.parseDouble(txtNota3.getText());
    		if(nota >=0 && nota <= 10) {
    			selecionado.getDisciplina(KeepDisciplina.getInstance().getDisciplina()).mudarNota(3, Double.parseDouble(txtNota3.getText()));
    		}
    		
    	}
    	
    	if(txtNota4.getText() != null && !txtNota4.getText().isEmpty()) {
    		double nota = Double.parseDouble(txtNota4.getText());
    		if(nota >=0 && nota <= 10) {
    			selecionado.getDisciplina(KeepDisciplina.getInstance().getDisciplina()).mudarNota(4, Double.parseDouble(txtNota4.getText()));
    		}
    		
    	}
    	
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
    	
    	tblAlunos.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                selecionado = tblAlunos.getSelectionModel().getSelectedItem();
                lblAluno.setText(selecionado.getName());
            }
        });
    }
    
    public ObservableList<Aluno> getAlunos() {
		ObservableList<Aluno> alunos = FXCollections.observableArrayList();
		alunos.addAll(EscolaFachada.getInstance().alunosDisc(KeepDisciplina.getInstance().getDisciplina()));
		
		return alunos;
	}

}
