package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Professor;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class PerfilDiretoriaController {

    @FXML
    private TableView<Aluno> tblAlunos;

    @FXML
    private TableColumn<Aluno, String> colAluno;

    @FXML
    private TableColumn<Aluno, String> colIdAluno;

    @FXML
    private TableColumn<?, ?> colResponsavelAluno;

    @FXML
    private TextField textNomeAluno;

    @FXML
    private TextField textIdAluno;

    @FXML
    private TextField textResponsavelAluno;

    @FXML
    private Button btnAlterarAluno;

    @FXML
    private Button btnRemoveAluno;

    @FXML
    private TableView<Professor> tblProfessores;

    @FXML
    private TableColumn<Professor, String> colProf;

    @FXML
    private TableColumn<Professor, String> colIdProf;

    @FXML
    private TextField textNomeProf;

    @FXML
    private TextField textIdProf;

    @FXML
    private ChoiceBox<Disciplina> choiceDisciplinaProf;

    @FXML
    private Button btnAlterarProf;

    @FXML
    private Button btnRemoveProf;

    @FXML
    private Button btnRemoveDisciplinaProf;

    @FXML
    private TableView<Responsavel> tblResponsaveis;

    @FXML
    private TableColumn<Responsavel, String> colResponsavel;

    @FXML
    private TableColumn<Responsavel, String> colIdResp;

    @FXML
    private TextField textNomeResp;

    @FXML
    private TextField textIdResp;

    @FXML
    private Button btnAlterarResp;

    @FXML
    private Button btnRemoveResp;

    @FXML
    private ChoiceBox<Aluno> choiceAlunosResp;

    @FXML
    private Button btnRemoveAlunoResp;

    @FXML
    private TableView<Disciplina> tblDisciplina;

    @FXML
    private TableColumn<Disciplina, String> colDisciplina;

    @FXML
    private TableColumn<Disciplina, String> colIdDisciplina;

    @FXML
    private TableColumn<Disciplina, Professor> colProfDisciplina;

    @FXML
    private TextField textNomeDisciplina;

    @FXML
    private TextField textIdDisciplina;

    @FXML
    private TextField textProfessorDisciplina;

    @FXML
    private Button btnAlterarDisciplina;

    @FXML
    private Button btnRemoveDisciplina;
    
    @FXML
    private ToggleGroup grupo;

    @FXML
    private RadioButton btnSelectAluno;

    @FXML
    private RadioButton btnSelectProf;

    @FXML
    private RadioButton btnSelectResp;

    @FXML
    private TextField textNomeCadastro;

    @FXML
    private TextField textIdCadastro;

    @FXML
    private TextField textSenhaCadastro;

    @FXML
    private Button btnCadastrar;
    
    @FXML
    public void initialize() {
    	//Tornando selecionável somente um radioButton na parte do cadastro de novos usuários
    	grupo = new ToggleGroup();
    	btnSelectAluno.setToggleGroup(grupo);
    	btnSelectProf.setToggleGroup(grupo);
    	btnSelectResp.setToggleGroup(grupo);
    	btnSelectAluno.setSelected(true);
    	
    	//Adicionando os itens na tableview da tab de alunos
    	tblAlunos.setItems(getAlunos());
    	colAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("name"));
    	colIdAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("id"));
    	
    	//adicionando os itens na tableview da tab de professores
    	tblProfessores.setItems(getProfessores());
    	colProf.setCellValueFactory(new PropertyValueFactory<Professor, String>("name"));
    	colIdProf.setCellValueFactory(new PropertyValueFactory<Professor, String>("id"));
    	
    	//adicionando os itens da tableview de responsaveis da tab de responsaveis
    	tblResponsaveis.setItems(getResponsaveis());
    	colResponsavel.setCellValueFactory(new PropertyValueFactory<Responsavel, String>("name"));
    	colIdResp.setCellValueFactory(new PropertyValueFactory<Responsavel, String>("id"));
    	
    	//adcicionando os itens da tableview de diciplinas na tab de disciplinas
    	tblDisciplina.setItems(getDisciplinas());
    	colDisciplina.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("nome"));
    	colIdDisciplina.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("id"));
    	colProfDisciplina.setCellValueFactory(new PropertyValueFactory<Disciplina, Professor>("professor"));
    }
    
    public ObservableList<Aluno> getAlunos(){
    	ObservableList<Aluno> lista = FXCollections.observableArrayList();
    	lista.addAll(EscolaFachada.getInstance().getAlunos());
    	return lista;
    }
    
    public ObservableList<Professor> getProfessores(){
    	ObservableList<Professor> lista = FXCollections.observableArrayList();
    	lista.addAll(EscolaFachada.getInstance().getProfessores());
    	return lista;
    }
    
    public ObservableList<Responsavel> getResponsaveis(){
    	ObservableList<Responsavel> lista = FXCollections.observableArrayList();
    	lista.addAll(EscolaFachada.getInstance().getResponsaveis());
    	return lista;
    }
    
    public ObservableList<Disciplina> getDisciplinas(){
    	ObservableList<Disciplina> disciplinas = FXCollections.observableArrayList();
    	disciplinas.addAll(EscolaFachada.getInstance().getDisciplinas());
    	return disciplinas;
    }
    
    public void cadastrar(ActionEvent event) {
    	if(!textNomeCadastro.getText().isEmpty() && textNomeCadastro.getText().length() > 0 && !textNomeCadastro.getText().equals("") && (!textIdCadastro.getText().isEmpty() && textIdCadastro.getText().length() > 0 && !textIdCadastro.getText().equals("")) && (!textSenhaCadastro.getText().isEmpty() && textSenhaCadastro.getText().length() > 0 && !textSenhaCadastro.getText().equals(""))) {
    		
    				if(btnSelectAluno.isSelected()) {
    					EscolaFachada.getInstance().cadastrarPessoa(new Aluno(textNomeCadastro.getText(), textIdCadastro.getText(), textSenhaCadastro.getText()));
    					tblAlunos.refresh();
    					textSenhaCadastro.setText(null);
    					textNomeCadastro.setText(null);
    					textIdCadastro.setText(null);
    					
    					Alert a = new Alert(AlertType.INFORMATION);
    					a.setTitle("Informação do cadastro");
    					a.setHeaderText("Cadastro realizado com sucesso");
    					a.setContentText(null);
    					a.show();
    				}
    				else if(btnSelectProf.isSelected()) {
    					EscolaFachada.getInstance().cadastrarPessoa(new Professor(textNomeCadastro.getText(), textIdCadastro.getText(), textSenhaCadastro.getText()));
    					tblProfessores.refresh();

    					textSenhaCadastro.setText(null);
    					textNomeCadastro.setText(null);
    					textIdCadastro.setText(null);
    					
    					Alert a = new Alert(AlertType.INFORMATION);
    					a.setTitle("Informação do cadastro");
    					a.setHeaderText("Cadastro realizado com sucesso");
    					a.setContentText(null);
    					a.show();
    				}
    				else if(btnSelectResp.isSelected()) {
    					EscolaFachada.getInstance().cadastrarPessoa(new Responsavel(textNomeCadastro.getText(), textIdCadastro.getText(), textSenhaCadastro.getText()));
    					tblResponsaveis.refresh();

    					textSenhaCadastro.setText(null);
    					textNomeCadastro.setText(null);
    					textIdCadastro.setText(null);
    					

    					Alert a = new Alert(AlertType.INFORMATION);
    					a.setTitle("Informação do cadastro");
    					a.setHeaderText("Cadastro realizado com sucesso");
    					a.setContentText(null);
    					a.show();
    				}
    			
    		
    	}
    	
    	else {
    		Alert a = new Alert(AlertType.ERROR);
    		a.setTitle("Cadastro não realizado");
    		a.setHeaderText("O cadastro não foi realizado com sucesso");
    		a.setContentText("Verifique se todos os campos estão preenchidos e tente novamente");
    		a.show();
    	}
    	
    	
    	initialize();
    	
    }

}
