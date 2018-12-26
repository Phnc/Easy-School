package br.ufrpe.easy_school.gui;

import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class AddResponsavelWindowController {

    @FXML
    private ChoiceBox<Responsavel> choiceResponsavel;

    @FXML
    private Button btnAddResponsavel;

    @FXML
    private Button btnClose;

}