package br.ufrpe.easy_school.gui;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import br.ufrpe.easy_school.negocios.EscolaFachada;
import br.ufrpe.easy_school.negocios.KeepPerson;
import br.ufrpe.easy_school.negocios.Mensagem;
import br.ufrpe.easy_school.negocios.beans.Diretoria;
import br.ufrpe.easy_school.negocios.beans.Pessoa;
import br.ufrpe.easy_school.negocios.beans.Responsavel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MensagensController {
	
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
    private TextArea txtMsg1;

    @FXML
    private Button btnResponder;
    
    @FXML
    void goBack(ActionEvent event) {
     	if (KeepPerson.getInstance().getPessoa() instanceof Responsavel) {
     		ScreenManager.getInstance().showPerfilResponsavel();
     	}
     	if (KeepPerson.getInstance().getPessoa() instanceof Diretoria) {
     		ScreenManager.getInstance().showPerfilDiretoria();
     	}
    }
    
    @FXML
    void responder(ActionEvent event) {
    	Mensagem selecionada = null;
    	Mensagem tabela1 = tblMsg.getSelectionModel().getSelectedItem();
    	Mensagem tabela2 = tblMsg1.getSelectionModel().getSelectedItem();
    	if (tabela1 != null && tabela1.getResposta() == " ") {
    		selecionada = tabela1;
    	}
    	else if (tabela2 != null && tabela2.getResposta() == " ") {
    		selecionada = tabela2;
    	}
        if (selecionada != null && !(selecionada.getPessoa().equals(KeepPerson.getInstance().getPessoa()))) {
        	ScreenManager.getInstance().showResposta(selecionada);
        }
    }
    @FXML
    public void initialize() {
    	// Quando a tabela estiver vazia
    	tblMsg.setPlaceholder(new Label("Você não tem mensagens aqui."));
    	tblMsg1.setPlaceholder(new Label("Você não tem mensagens aqui."));
    	if (KeepPerson.getInstance().getPessoa() instanceof Responsavel) {
	    	tblTitulo.setCellValueFactory(new PropertyValueFactory<Mensagem, String>("titulo"));
			tblMsg.setItems(getEnviadasResponsavel((Responsavel)KeepPerson.getInstance().getPessoa()));
			tblTitulo1.setCellValueFactory(new PropertyValueFactory<Mensagem, String>("titulo"));
			tblMsg1.setItems(getRecebidasResponsavel((Responsavel)KeepPerson.getInstance().getPessoa()));
    	}
     	if (KeepPerson.getInstance().getPessoa() instanceof Diretoria) {
	    	tblTitulo.setCellValueFactory(new PropertyValueFactory<Mensagem, String>("titulo"));
			tblMsg.setItems(getEnviadasDiretoria((Diretoria)KeepPerson.getInstance().getPessoa()));
			tblTitulo1.setCellValueFactory(new PropertyValueFactory<Mensagem, String>("titulo"));
			tblMsg1.setItems(getRecebidasDiretoria((Diretoria)KeepPerson.getInstance().getPessoa()));
    	}
    	tblMsg.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                Mensagem selecionada = tblMsg.getSelectionModel().getSelectedItem();
                if (selecionada != null) {
                	txtMsg.setText(selecionada.getMensagem());
                	txtMsg1.setText(selecionada.getResposta());
                }
            }
        });
    	tblMsg1.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                Mensagem selecionada = tblMsg1.getSelectionModel().getSelectedItem();
                if (selecionada != null) {
                	txtMsg.setText(selecionada.getMensagem());
                  	txtMsg1.setText(selecionada.getResposta());
                }
            }
        });
    }
    
    private ObservableList<Mensagem> getEnviadasResponsavel(Responsavel a) {
		ObservableList<Mensagem> mensagens = FXCollections.observableArrayList();
		for (Mensagem x : a.getMensagens() ) {
			if  (x.getPessoa().equals(a))
				mensagens.add(x);
		}
		return mensagens;
	}
	
	private ObservableList<Mensagem> getEnviadasDiretoria(Diretoria a) {
		ObservableList<Mensagem> mensagens = FXCollections.observableArrayList();
		for (Mensagem x : a.getMensagens() ) {
			if  (x.getPessoa().equals(a))
				mensagens.add(x);
		}
		return mensagens;
	}
	
	private ObservableList<Mensagem> getRecebidasResponsavel(Responsavel a) {
		ObservableList<Mensagem> mensagens = FXCollections.observableArrayList();
		for (Mensagem x : a.getMensagens() ) {
			if  (!x.getPessoa().equals(a))
				mensagens.add(x);
		}
		return mensagens;
	}
	
	private ObservableList<Mensagem> getRecebidasDiretoria(Diretoria a) {
		ObservableList<Mensagem> mensagens = FXCollections.observableArrayList();
		for (Mensagem x : a.getMensagens() ) {
			if  (!x.getPessoa().equals(a))
				mensagens.add(x);
		}
		return mensagens;
	}
	
    
}
