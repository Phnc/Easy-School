package br.ufrpe.easy_school.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PerfilDiretoriaController {

    @FXML
    private TableView<?> tblAlunos;

    @FXML
    private TableColumn<?, ?> colAluno;

    @FXML
    private TableColumn<?, ?> colIdAluno;

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
    private TableView<?> tblProfessores;

    @FXML
    private TableColumn<?, ?> colProf;

    @FXML
    private TableColumn<?, ?> colIdProf;

    @FXML
    private TextField textNomeProf;

    @FXML
    private TextField textIdProf;

    @FXML
    private ChoiceBox<?> choiceDisciplinaProf;

    @FXML
    private Button btnAlterarProf;

    @FXML
    private Button btnRemoveProf;

    @FXML
    private Button btnRemoveDisciplinaProf;

    @FXML
    private TableView<?> tblResponsaveis;

    @FXML
    private TableColumn<?, ?> colResponsavel;

    @FXML
    private TableColumn<?, ?> colIdResp;

    @FXML
    private TextField textNomeResp;

    @FXML
    private TextField textIdResp;

    @FXML
    private Button btnAlterarResp;

    @FXML
    private Button btnRemoveResp;

    @FXML
    private ChoiceBox<?> choiceAlunosResp;

    @FXML
    private Button btnRemoveAlunoResp;

    @FXML
    private TableView<?> tblDisciplina;

    @FXML
    private TableColumn<?, ?> colDisciplina;

    @FXML
    private TableColumn<?, ?> colIdDisciplina;

    @FXML
    private TableColumn<?, ?> colProfDisciplina;

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

}
