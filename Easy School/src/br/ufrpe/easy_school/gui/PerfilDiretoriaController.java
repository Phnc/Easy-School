package br.ufrpe.easy_school.gui;

import javafx.fxml.FXML;
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
    private TextField textNome;

    @FXML
    private TextField textId;

    @FXML
    private TextField textResponsavel;

}
