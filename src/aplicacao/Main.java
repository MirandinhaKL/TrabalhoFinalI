/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import controller.TelaDeGraficosController;
import controller.TelaDeLoginController;
import controller.TelaInsereMovimentacaoController;
import controller.TelaPrincipalController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Mirandinha
 */
public class Main extends Application {

    private Stage primaryStage;
    private AnchorPane root;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Gerenciador de Finanças Pessoais");
        iniciaTelaDeLogin();
    }

    public void iniciaTelaDeLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/TelaDeLogin.fxml"));
            root = (AnchorPane) loader.load();
            TelaDeLoginController controller = loader.getController();
            controller.setMain(this);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exibeTelaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/TelaPrincipal.fxml"));
            AnchorPane telaPrincipal = (AnchorPane) loader.load();
            TelaPrincipalController controlador = loader.getController();
            controlador.setMain(this);
            Scene cena = new Scene(telaPrincipal);
            primaryStage.setScene(cena);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exibeTelaInsereMovimentacao() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/TelaInsereMovimentacao.fxml"));
            AnchorPane telaInsereMovimentacao = (AnchorPane) loader.load();
            TelaInsereMovimentacaoController controlador = loader.getController();
            controlador.setMain(this);
            Scene cena = new Scene(telaInsereMovimentacao);
            primaryStage.setScene(cena);
            primaryStage.setResizable(false);
            primaryStage.show();
            System.out.println("foi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exibeTelaDeGraficos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/TelaDeGraficos.fxml"));
            AnchorPane telaGeraGraficos = (AnchorPane) loader.load();
            TelaDeGraficosController controlador = loader.getController();
            controlador.setMain(this);
            Scene cena = new Scene(telaGeraGraficos);
            primaryStage.setScene(cena);
            primaryStage.setResizable(false);
            primaryStage.show();
            System.out.println("Gera gráficos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void mostraAlerta(AlertType tipoDeAlerta, String titulo, String cabecalho, String mensagem){
        Alert alerta = new Alert(tipoDeAlerta);
        alerta.initOwner(this.getPrimaryStage());
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
    
    public Stage getPrimaryStage(){
        return this.primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
