/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import controller.TelaDeLoginController;
import controller.TelaPrincipalController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
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

    public void mostraTelaPrincipal() {
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
