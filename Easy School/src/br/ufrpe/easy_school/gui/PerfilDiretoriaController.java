package br.ufrpe.easy_school.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PerfilDiretoriaController {

    @FXML
    private TableView<?> tblAlunos;

    @FXML
    private TableColumn<?, ?> colAluno;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colResponsavel;

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
    private TableColumn<?, ?> colAluno1;

    @FXML
    private TableColumn<?, ?> colId1;

    @FXML
    private TableColumn<?, ?> colResponsavel1;

    @FXML
    private TableColumn<?, ?> colResponsavel11;

    @FXML
    private TableColumn<?, ?> colId11;

    @FXML
    private TextField textNomeProf;

    @FXML
    private TextField textIdProf;

    @FXML
    private ChoiceBox<?> choiceAddDisciplina;

    @FXML
    private Button btnAddDisciplina;

    @FXML
    private Button btnAlterarProf;

}
