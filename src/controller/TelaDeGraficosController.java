package controller;

import aplicacao.Main;
import java.net.URL;
import javafx.scene.control.ComboBox;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaDeGraficosController implements Initializable {

    private Main main;
    private Stage palco;

    @FXML
    private Pane painelCategoria;

    @FXML
    private ComboBox<?> comboBoxMensal;

    @FXML
    private Pane painelAnual;

    @FXML
    private ComboBox<?> comboBoxAnual;

    @FXML
    private PieChart chartPizza;

    @FXML
    void handleReceitaXdespesa(ActionEvent event) {
        painelCategoria.setVisible(false);
        painelAnual.setVisible(true);
    }

    @FXML
    void handleDespesaPorCategoria(ActionEvent event) {
        painelAnual.setVisible(false);
        painelCategoria.setVisible(true);
    }

    @FXML
    void handleComboBoxAnual(ActionEvent event) {

    }

    @FXML
    void handleComboBoxMensal(ActionEvent event) {

    }

    @FXML
    void handleButtonVoltarMensal(ActionEvent event) {
        main.exibeTelaPrincipal();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
}
