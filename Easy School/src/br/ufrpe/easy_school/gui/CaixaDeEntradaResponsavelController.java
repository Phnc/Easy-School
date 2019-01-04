package br.ufrpe.easy_school.gui;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.KeepPerson;
import br.ufrpe.easy_school.negocios.Mensagem;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class CaixaDeEntradaResponsavelController {
	
    @FXML
    private TableView<Mensagem> tblMsg;
    
    @FXML
    private TableColumn<Mensagem, String> tblTitulo;
    
    @FXML
    private TableView<Mensagem> tblMsg1;
    
    @FXML
    private TableColumn<Mensagem, String> tblTitulo1;
    
    @FXML
    private Button btnVoltar;

    @FXML
    private TextArea txtMsg;

    @FXML
    private Button btnResponder;
    
    @FXML
    void goBack(ActionEvent event) {
    	ScreenManager.getInstance().showPerfilResponsavel();
    }
    
    @FXML
    public void initialize() {
    	tblTitulo.setCellValueFactory(new PropertyValueFactory<Mensagem, String>("titulo"));
		tblMsg.setItems(getMsgs((Responsavel)KeepPerson.getInstance().getPessoa()));
		
		tblTitulo1.setCellValueFactory(new PropertyValueFactory<Mensagem, String>("titulo"));
		tblMsg1.setItems(getMsgsResp((Responsavel)KeepPerson.getInstance().getPessoa()));
		
    	tblMsg.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                Mensagem selecionada = tblMsg.getSelectionModel().getSelectedItem();
                if (selecionada != null) {
                	txtMsg.setText(selecionada.getMensagem());
                }
            }
        });
    	tblMsg1.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                Mensagem selecionada = tblMsg1.getSelectionModel().getSelectedItem();
                if (selecionada != null) {
                	txtMsg.setText(selecionada.getMensagem());
                }
            }
        });
    }
    
	private ObservableList<Mensagem> getMsgs(Responsavel a) {
		ObservableList<Mensagem> mensagens = FXCollections.observableArrayList();
		mensagens.addAll(a.getMensagens());
		
		return mensagens;
	}
	
	private ObservableList<Mensagem> getMsgsResp(Responsavel a) {
		ObservableList<Mensagem> mensagens = FXCollections.observableArrayList();
		for (Mensagem x : a.getMensagens() ) {
			if  (x.getResposta().equals(" "))
				mensagens.add(x);
		}
		return mensagens;
	}
	
    
}
