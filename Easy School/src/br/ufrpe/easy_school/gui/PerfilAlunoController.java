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

public class PerfilAlunoController {
	
	
	public Aluno a;

	@FXML
    private Label lblName;

    @FXML
    private TableView<Disciplina> tableDisc;

    @FXML
    private TableColumn<Disciplina, String> columnDisc;

    @FXML
    private TableColumn<Disciplina, Number> columnNota1;

    @FXML
    private TableColumn<Disciplina, Number> columnNota2;

    @FXML
    private TableColumn<Disciplina, Number> columnNota3;

    @FXML
    private TableColumn<Disciplina, Number> columnNota4;
    
    @FXML
    private Button btnLogout;

    @FXML
    void logout(ActionEvent event) {
    	KeepPerson.getInstance().setPessoa(null);
    	ScreenManager.getInstance().showCena1();
    }
    
    
    @FXML 
    private void initialize() {
    	

        this.a = (Aluno) KeepPerson.getInstance().getPessoa();
    	
    	lblName.setText(a.getName());
    	columnDisc.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("nome"));
    	columnNota1.setCellValueFactory(new PropertyValueFactory<Disciplina, Number>("Nota1"));
    	columnNota2.setCellValueFactory(new PropertyValueFactory<Disciplina, Number>("Nota2"));
    	columnNota3.setCellValueFactory(new PropertyValueFactory<Disciplina, Number>("Nota3"));
    	columnNota4.setCellValueFactory(new PropertyValueFactory<Disciplina, Number>("Nota4"));
    	
    	tableDisc.setItems(getDisciplinas(a));

        

    }
    
    

	private ObservableList<Disciplina> getDisciplinas(Aluno a) {
		ObservableList<Disciplina> disciplinas = FXCollections.observableArrayList();
		disciplinas.addAll(a.getDisciplinas());
		
		return disciplinas;
	}
	
	

}
