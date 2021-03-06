package br.ufrpe.easy_school.gui;

import java.io.IOException;

import br.ufrpe.easy_school.negocios.Mensagem;
import br.ufrpe.easy_school.negocios.beans.Aluno;
import br.ufrpe.easy_school.negocios.beans.Pessoa;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ScreenManager {

	private static ScreenManager instance;
    private Stage mainStage;


    private Scene cena1;
    private Scene perfilAluno;
    private Scene perfilProfessor;
    private Scene perfilDisc;
    private Scene perfilResponsavel;
    private Scene perfilDiretoria;
    private Scene msgScene;
    private Scene mensagens;


    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }

        return instance;
    }

    private ScreenManager() {

        try {


            HBox testPane = FXMLLoader.load(getClass().getResource(
              "/br/ufrpe/easy_school/gui/Scene1.fxml"));
            this.cena1 = new Scene(testPane);




        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;

        mainStage.setWidth(718);
        mainStage.setHeight(735);
    }


    public void showCena1(){
    	this.mainStage.setScene(cena1);
    	this.mainStage.show();
    }

    public void showPerfilAluno(){

    	HBox scene;
		try {
			scene = FXMLLoader.load(getClass().getResource(
			        "/br/ufrpe/easy_school/gui/PerfilAluno.fxml"));
			this.perfilAluno = new Scene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



    	this.mainStage.setScene(perfilAluno);
    	this.mainStage.show();
    }

    public void showPerfilProfessor(){

    	HBox scene;
		try {
			scene = FXMLLoader.load(getClass().getResource(
			        "/br/ufrpe/easy_school/gui/PerfilProfessor.fxml"));
			this.perfilProfessor = new Scene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



    	this.mainStage.setScene(perfilProfessor);
    	this.mainStage.show();
    }

    public void showDisc() {
    	HBox scene;
    	try {
			scene = FXMLLoader.load(getClass().getResource(
			        "/br/ufrpe/easy_school/gui/PerfilDisciplina.fxml"));
			this.perfilDisc = new Scene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.mainStage.setScene(perfilDisc);
    	this.mainStage.show();
    }

    public void showPerfilResponsavel() {
    	HBox scene;

    	try {
    		scene = FXMLLoader.load(getClass().getResource("/br/ufrpe/easy_school/gui/PerfilResponsavel.fxml"));
    		this.perfilResponsavel = new Scene(scene);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	this.mainStage.setScene(perfilResponsavel);
    	this.mainStage.show();
    }

    public void showMessageScene() {
    	HBox scene;
    	try {
			scene = FXMLLoader.load(getClass().getResource(
			        "/br/ufrpe/easy_school/gui/MessageScene.fxml"));
			this.msgScene = new Scene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.mainStage.setScene(msgScene);
    	this.mainStage.show();
    }

	public void showPerfilDiretoria() {
		HBox scene;
    	try {
			scene = FXMLLoader.load(getClass().getResource(
			        "/br/ufrpe/easy_school/gui/PerfilDiretoria.fxml"));
			this.perfilDiretoria = new Scene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.mainStage.setScene(perfilDiretoria);
    	this.mainStage.show();

	}

    public void showNotasResponsavel (Aluno x) {
    	 try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/ufrpe/easy_school/gui/NotasResponsavel.fxml"));
             Parent root = (Parent) loader.load();
             NotasResponsavelController secController = loader.getController();
             secController.iniciarTabela(x);
          	 this.mainStage.setScene(new Scene(root));
        	 this.mainStage.show();
         } catch (IOException e) {
             e.printStackTrace();
         }

    }
    
    
    public void showMensagens () {
    	HBox scene;
    	try {
			scene = FXMLLoader.load(getClass().getResource("/br/ufrpe/easy_school/gui/Mensagens.fxml"));
			this.mensagens = new Scene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.mainStage.setScene(mensagens);
    	this.mainStage.show();
    }
    
    public void showResposta(Mensagem x) {
   	 try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/ufrpe/easy_school/gui/Resposta.fxml"));
            Parent root = (Parent) loader.load();
            RespostaController secController = loader.getController();
            secController.iniciarTxt(x);
         	 this.mainStage.setScene(new Scene(root));
       	 this.mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

   }
    
    
    public void showEnviarMensagemDiretoria(Pessoa x) {
   	 try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/ufrpe/easy_school/gui/EnviarMensagemDiretoria.fxml"));
            Parent root = (Parent) loader.load();
            EnviarMensagemDiretoriaController secController = loader.getController();
            secController.iniciar_Receptor(x);
         	 this.mainStage.setScene(new Scene(root));
       	 this.mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

   }

}
