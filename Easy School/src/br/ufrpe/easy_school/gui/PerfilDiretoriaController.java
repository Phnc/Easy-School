package br.ufrpe.easy_school.gui;

import java.io.IOException;
import java.util.ArrayList;

import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Disciplina;
import br.ufrpe.easy_school.negocios.beans.Pessoa;
import br.ufrpe.easy_school.negocios.beans.Professor;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PerfilDiretoriaController {
	
	Aluno alunoTabela;
	Professor profTabela;
	Responsavel respTabela;
	Disciplina discTabela;
	
	boolean isShowing = false;

    @FXML
    private TableView<Aluno> tblAlunos;

    @FXML
    private TableColumn<Aluno, String> colAluno;

    @FXML
    private TableColumn<Aluno, String> colIdAluno;


    @FXML
    private TextField textNomeAluno;

    @FXML
    private TextField textIdAluno;

    @FXML
    private ChoiceBox<Responsavel> choiceResponsavelAluno;
    
    @FXML
    private Button btnRemoveResponsavelAluno;
    
    @FXML
    private Button btnAdicionarResponsavelAluno;

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
    private ComboBox<Disciplina> choiceDisciplinaProf;

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
    private Button btnMudarProfessorDisc;
    
    @FXML
    private Button btnLogout1;
    
    @FXML
    private Button btnLogout2;
    
    @FXML
    private Button btnLogout3;
    
    @FXML
    private Button btnLogout4;
    
    @FXML
    private Button btnLogout5;
    
    @FXML
    private Button btnLogout6;
    
    @FXML
    private TextField idCadastroDisc;
    
    @FXML
    private TextField nomeCadastroDisc;
    
    @FXML
    private TextField idProfessorCadastroDisc;
    
    @FXML
    private Button btnCadastrarDisciplina;
    
    @FXML
    private Button btnRemoveDisciplinaAluno;
    
    @FXML
    private ChoiceBox<Disciplina> choiceDisciplinaAluno;
    
    @FXML
    private Button btnAddDisciplinaAluno;
    
    @FXML
    public void addDisciplinaAluno(ActionEvent event) {
    	if (alunoTabela != null) {
			try {
				FXMLLoader fxloader = new FXMLLoader(
						getClass().getResource("/br/ufrpe/easy_school/gui/AddDisciplinaAlunoWindow.fxml"));
				Parent root = (Parent) fxloader.load();
				AddDisciplinaAlunoWindowController controller = fxloader
						.<AddDisciplinaAlunoWindowController>getController();
				controller.setAluno(alunoTabela);

				Stage stage = new Stage();
				stage.setTitle("Adicionar um Responsável");
				stage.setScene(new Scene(root, 603, 400));

				stage.show();

			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
    }
    
    @FXML
    public void removerDisciplinaAluno(ActionEvent event) {
    	if(alunoTabela != null && choiceDisciplinaAluno.getValue() != null) {
    		ArrayList<Disciplina> list = alunoTabela.getDisciplinas();
    		for(int i = 0; i < list.size(); i++) {
    			if(list.get(i).equals(choiceDisciplinaAluno.getValue())) {
    				list.remove(i);
    			}
    		}
    		choiceDisciplinaAluno.getSelectionModel().clearSelection();
    		ObservableList<Disciplina> lista = FXCollections.observableArrayList(alunoTabela.getDisciplinas());
    		choiceDisciplinaAluno.setItems(lista);
    	}
    	else {
    		Alert a = new Alert(AlertType.WARNING);
    		a.setTitle("Opera��o n�o realizada");
    		a.setHeaderText("Campos inv�lidos");
    		a.setContentText("Selecione pelo menos um aluno e uma disciplina e tente novamente");
    		a.show();
    	}
    }
    
    
    @FXML
    public void cadastrarDisciplina(ActionEvent event) {
    	
    	
    	if((idCadastroDisc.getText() != null && idCadastroDisc.getText().length() > 0 && !idCadastroDisc.getText().equals("")) && (nomeCadastroDisc.getText() != null && nomeCadastroDisc.getText().length() > 0 && !nomeCadastroDisc.getText().equals("")) && (idProfessorCadastroDisc.getText() != null && idProfessorCadastroDisc.getText().length() > 0 && !idProfessorCadastroDisc.getText().equals(""))) {
    		Pessoa p = EscolaFachada.getInstance().buscar(idProfessorCadastroDisc.getText());
    		
    		if(p != null && p instanceof Professor) {
    			Disciplina d = EscolaFachada.getInstance().buscarDisciplina(idCadastroDisc.getText());
    			if(d != null) {
    				Alert a = new Alert(AlertType.WARNING);
    				a.setTitle("Opera��o n�o realizada");
    				a.setHeaderText("Disciplina j� cadastrada");
    				a.setContentText("A disciplina com o presente id j� foi cadastrada");
    				a.show();
    			}
    			else {
    				Disciplina nova = new Disciplina(nomeCadastroDisc.getText(), (Professor) p, idCadastroDisc.getText());
    				EscolaFachada.getInstance().cadastrarDisciplina(nova);
    				tblDisciplina.refresh();
    				Alert a = new Alert(AlertType.INFORMATION);
    				a.setTitle("Status da opera��o");
    				a.setHeaderText("O cadastro foi feito com sucesso");
    				a.show();
    				
    			}
    		}
    		else {
    			Alert a = new Alert(AlertType.WARNING);
    			a.setTitle("Opera��o n�o realizada");
    			a.setHeaderText("Professor inv�lido");
    			a.setContentText("Digite um id de professor v�lido e tente novamente");
    			a.show();
    		}
    	}
    	
    	else {
    		Alert a = new Alert(AlertType.WARNING);
    		a.setTitle("Não foi possível realizar o cadastro");
    		a.setHeaderText("Os campos sao obrigatórios");
    		a.setContentText("Verifique se os campos digitados são válidos e tente novamente");
    		a.show();
    	}
    	
    	nomeCadastroDisc.setText(null);
    	idCadastroDisc.setText(null);
    	idProfessorCadastroDisc.setText(null);
    	initialize();
    }
    
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
    	
    	choiceDisciplinaProf.setOnMouseClicked((MouseEvent event) -> {
    		if(event.getButton().equals(MouseButton.PRIMARY)) {
    			if(tblProfessores.getSelectionModel().getSelectedItem()  != null) {
    				
    				if((EscolaFachada.getInstance().arrayDisc(profTabela).size() > 0) && (EscolaFachada.getInstance().arrayDisc(profTabela) != null)){
    					choiceDisciplinaProf.setItems(FXCollections.observableArrayList(EscolaFachada.getInstance().arrayDisc(profTabela)));
    		
    				}
                   	
                }
    		}
    		
    	});
    	
    	tblAlunos.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                alunoTabela = tblAlunos.getSelectionModel().getSelectedItem();
                textNomeAluno.setText(alunoTabela.getName());
                textIdAluno.setText(alunoTabela.getId());
                choiceResponsavelAluno.setDisable(false);
                
                ObservableList<Responsavel> list = FXCollections.observableArrayList(EscolaFachada.getInstance().responsaveisAluno(alunoTabela));
                
                choiceResponsavelAluno.setItems(list);
                ObservableList<Disciplina> listaDisc = FXCollections.observableArrayList(((Aluno)EscolaFachada.getInstance().buscar(alunoTabela.getId())).getDisciplinas());
                choiceDisciplinaAluno.setItems(listaDisc);
              
            }
        });
    	
    	tblProfessores.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
            	profTabela = tblProfessores.getSelectionModel().getSelectedItem();
                textNomeProf.setText(profTabela.getName());
                textIdProf.setText(profTabela.getId());                          
            }
        });
    	
    	tblResponsaveis.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
            	respTabela = tblResponsaveis.getSelectionModel().getSelectedItem();
                textNomeResp.setText(respTabela.getName());
                textIdResp.setText(respTabela.getId());
                ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList(respTabela.getAlunos());
                choiceAlunosResp.setItems(listaAlunos);
            }
        });
    	
    	

    	
    	tblDisciplina.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                discTabela = tblDisciplina.getSelectionModel().getSelectedItem();
                textNomeDisciplina.setText(discTabela.getNome());
                textIdDisciplina.setText(discTabela.getId());
                if(discTabela.getProfessor() != null) {
                	textProfessorDisciplina.setText(discTabela.getProfessor().getId());
                }
                else {
                	textProfessorDisciplina.setText("Nenhum");
                }
            }
        });
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
    	
    	EscolaFachada.getInstance().salvarSistema();
    	initialize();
    	
    }
    
    @FXML
    void addResponsavel(ActionEvent event) {	
    	if(isShowing == false && tblAlunos.getSelectionModel().getSelectedItem() != null) {
			
		    try {
		    	FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/br/ufrpe/easy_school/gui/AddResponsavelWindow.fxml"));
		        Parent root = (Parent) fxloader.load();
		        AddResponsavelWindowController controller = fxloader.<AddResponsavelWindowController>getController();
		        controller.setAluno(alunoTabela);
		        
		        Stage stage = new Stage();
		        stage.setTitle("Adicionar um Responsável");
		        stage.setScene(new Scene(root, 400, 250));
		        
		        
		        
		        stage.show();
		        isShowing = true;
		        stage.setOnHiding( evento -> {
		        	isShowing = false;
		        	
		        });
		        EscolaFachada.getInstance().salvarSistema();
		    }
		    catch (IOException e) {
		        e.printStackTrace();
		    }
    	}
    }
    
    
    @FXML
    void removeResponsavelAluno(ActionEvent event) {
    	
    	if(choiceResponsavelAluno.getValue() != null && choiceResponsavelAluno.getValue().getAlunos().contains(alunoTabela)) {
    		choiceResponsavelAluno.getValue().removerAluno(alunoTabela);
    		choiceResponsavelAluno.setValue(null);
    		tblAlunos.getSelectionModel().clearSelection();
    		choiceResponsavelAluno.setDisable(true);
    		EscolaFachada.getInstance().salvarSistema();
    	}
    	else {
    		Alert a = new Alert(AlertType.WARNING);
    		a.setHeaderText("Selecione um Responsável");
    		a.show();
    	}
    }
    
    
    @FXML
    void alterarDadosAluno(ActionEvent event) {
    	if((textNomeAluno.getText() != null && textNomeAluno.getText().length() > 0 && !textNomeAluno.getText().equals("")) && (textIdAluno.getText() != null && textIdAluno.getText().length() > 0 && !textIdAluno.getText().equals(""))) {
    		alunoTabela.setName(textNomeAluno.getText());
    		alunoTabela.setId(textIdAluno.getText());
    		tblAlunos.refresh();
    		EscolaFachada.getInstance().salvarSistema();
    	}
    	else {
    		Alert a = new Alert(AlertType.WARNING);
    		a.setTitle("Operação não realizada");
    		a.setHeaderText("Não foi possível alterar os dados do Aluno");
    		a.setContentText("Verifique se os campos possuem informações válidas e tente novamente");
    	}
    }
    
    @FXML
    void removerAluno(ActionEvent event) {
    	if (alunoTabela != null && tblAlunos.getSelectionModel().getSelectedItem() != null) {
    		tblAlunos.getItems().remove(alunoTabela);
			EscolaFachada.getInstance().removerPessoa(alunoTabela.getId());
			alunoTabela = null;
			textNomeAluno.clear();
			textIdAluno.clear();
			tblAlunos.getSelectionModel().clearSelection();
			tblAlunos.refresh();
			EscolaFachada.getInstance().salvarSistema();
		}
    }
    
    @FXML
    void alterarDadosProfessor(ActionEvent event) {
    	if((textNomeProf.getText() != null && textNomeProf.getText().length() > 0 && !textNomeProf.getText().equals("")) && (textIdProf.getText() != null && textIdProf.getText().length() > 0 && !textIdProf.getText().equals(""))) {
    		profTabela.setName(textNomeProf.getText());
    		profTabela.setId(textIdProf.getText());
    		tblProfessores.refresh();
    		EscolaFachada.getInstance().salvarSistema();
    	}
    	else {
    		Alert a = new Alert(AlertType.WARNING);
    		a.setTitle("Operação não realizada");
    		a.setHeaderText("Não foi possível alterar os dados do Professor");
    		a.setContentText("Verifique se os campos possuem informações válidas e tente novamente");
    	}
    }
    
    @FXML
    void removerProfessor(ActionEvent event) {
    	if (profTabela != null) {
    		tblProfessores.getItems().remove(profTabela);
			EscolaFachada.getInstance().removerPessoa(profTabela.getId());
			profTabela = null;
			textNomeProf.clear();
			textIdProf.clear();
			tblProfessores.getSelectionModel().clearSelection();
			tblProfessores.refresh();
			EscolaFachada.getInstance().salvarSistema();
		}
    }


    
    @FXML
    void removerDisciplinaProfessor(ActionEvent event) {
    	if(choiceDisciplinaProf.getValue() != null && choiceDisciplinaProf.getValue().getProfessor().equals(profTabela)) {
    		choiceDisciplinaProf.getValue().removerProfessor();
    		choiceDisciplinaProf.getSelectionModel().clearSelection();
    		choiceDisciplinaProf.getItems().clear();
    		tblProfessores.getSelectionModel().clearSelection();
    		tblDisciplina.refresh();
    		EscolaFachada.getInstance().salvarSistema();
    	}
    	
    }
    
    @FXML
    void alterarDadosResponsavel(ActionEvent event) {
    	if((textNomeResp.getText() != null && textNomeResp.getText().length() > 0 && !textNomeResp.getText().equals("")) && (textIdResp.getText() != null && textIdResp.getText().length() > 0 && !textIdResp.getText().equals(""))) {
    		respTabela.setName(textNomeResp.getText());
    		respTabela.setId(textIdResp.getText());
    		tblResponsaveis.refresh();
    		EscolaFachada.getInstance().salvarSistema();
    	}
    	else {
    		Alert a = new Alert(AlertType.WARNING);
    		a.setTitle("Operação não realizada");
    		a.setHeaderText("Não foi possível alterar os dados do Responsável");
    		a.setContentText("Verifique se os campos possuem informações válidas e tente novamente");
    	}
    }
    
    @FXML
    void removerResponsavel(ActionEvent event) {
    	if (respTabela != null) {
    		tblResponsaveis.getItems().remove(respTabela);
			EscolaFachada.getInstance().removerPessoa(respTabela.getId());
			respTabela = null;
			textNomeResp.clear();
			textIdResp.clear();
			tblResponsaveis.getSelectionModel().clearSelection();
			tblResponsaveis.refresh();
			EscolaFachada.getInstance().salvarSistema();
		}
    }
    
    @FXML
    void alterarDadosDisciplina(ActionEvent event) {
    	if(tblDisciplina.getSelectionModel().getSelectedItem() != null && (!textNomeDisciplina.getText().isEmpty()) && (!textIdDisciplina.getText().isEmpty())) {
    		Disciplina temp = tblDisciplina.getSelectionModel().getSelectedItem();
    		ArrayList<Aluno> lista = EscolaFachada.getInstance().alunosDisc(discTabela);
    		
    		if(lista.size() > 0 && lista != null) {
    			
    			for(int i = 0; i < lista.size(); i++) {

    					lista.get(i).getDisciplina(temp).setNome(textNomeDisciplina.getText());	
    					Disciplina temp2 = new Disciplina(textNomeDisciplina.getText(), temp.getProfessor(), temp.getId());
    					lista.get(i).getDisciplina(temp2).setId(textIdDisciplina.getText());
    			
    			}
    			//discTabela.setNome(textNomeDisciplina.getText());
    			//discTabela.setId(textIdDisciplina.getText());
    			tblDisciplina.getSelectionModel().getSelectedItem().setId(textIdDisciplina.getText());
    			tblDisciplina.getSelectionModel().getSelectedItem().setNome(textNomeDisciplina.getText());
    			
    			discTabela = null;
    	    	tblDisciplina.getSelectionModel().clearSelection();
    			tblDisciplina.refresh();
    			textNomeDisciplina.setText(null);
    			textIdDisciplina.setText(null);
    			textProfessorDisciplina.setText(null);
    		}
    	}
    	else {
    		Alert a = new Alert(AlertType.WARNING);
    		a.setTitle("Operação não realizada");
    		a.setHeaderText("Não foi possível alterar os dados da Disciplina");
    		a.setContentText("Verifique se os campos possuem informações válidas e tente novamente");
    		a.show();
    	}
    	EscolaFachada.getInstance().salvarSistema();
    }
    
    @FXML
    void removerDisciplina(ActionEvent event) {
    	if (discTabela != null) {
    		tblDisciplina.getItems().remove(discTabela);
			EscolaFachada.getInstance().removerDisciplina(discTabela.getId());
			discTabela = null;
			tblDisciplina.getSelectionModel().clearSelection();
			tblDisciplina.refresh();
		}
    	EscolaFachada.getInstance().salvarSistema();
    }
    
    @FXML
    void alterarProfessorDisciplina(ActionEvent event) {
    	if(textProfessorDisciplina.getText() != null && EscolaFachada.getInstance().getProfessores().contains(EscolaFachada.getInstance().buscar(textProfessorDisciplina.getText())) && discTabela != null && tblDisciplina.getSelectionModel().getSelectedItem() != null) {
    		ArrayList<Aluno> lista = EscolaFachada.getInstance().alunosDisc(discTabela);
    		Professor p = (Professor) EscolaFachada.getInstance().buscar(textProfessorDisciplina.getText());
        	for(int i = 0; i < lista.size(); i++) {
        		lista.get(i).getDisciplina(discTabela).setProfessor(p);
        	
        	}
        	tblDisciplina.getSelectionModel().getSelectedItem().setProfessor(p);
    	}
    	discTabela = null;
    	tblDisciplina.getSelectionModel().clearSelection();
    	tblDisciplina.refresh();
    	EscolaFachada.getInstance().salvarSistema();
    }
    
    
    @FXML
    void logout(ActionEvent event) {
    	ScreenManager.getInstance().showCena1();
    }
    
    @FXML
    void mensagens(ActionEvent event) {
    	ScreenManager.getInstance().showMensagens();
    }
    
    
    @FXML
    void enviarMensagem(ActionEvent event) {
    	if (tblResponsaveis.getSelectionModel().getSelectedItem() != null) {
    		ScreenManager.getInstance().showEnviarMensagemDiretoria(tblResponsaveis.getSelectionModel().getSelectedItem());
    	}
    	EscolaFachada.getInstance().salvarSistema();
    }
    
    
    @FXML
    void removerAlunoResponsavel(ActionEvent event) {
    	if(choiceAlunosResp.getValue() != null && tblResponsaveis.getSelectionModel().getSelectedItem() != null) {
    		respTabela.removerAluno(choiceAlunosResp.getValue());
    		choiceAlunosResp.getSelectionModel().clearSelection();
    		choiceAlunosResp.getItems().clear();
    		tblResponsaveis.getSelectionModel().clearSelection();
    		tblResponsaveis.refresh();
    		
    	}
    	else {
    		Alert a = new Alert(AlertType.WARNING);
    		a.setTitle("Operação não realizada");
    		a.setHeaderText("A operaçãon não foi realizada pois nenhum aluno válido foi selecionado.");
    		a.setContentText("Selecione um aluno válido e tente novamente");
    		a.show();
    	}
    	EscolaFachada.getInstance().salvarSistema();
    	
    }
}
