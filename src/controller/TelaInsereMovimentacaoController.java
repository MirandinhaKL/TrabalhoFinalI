package controller;

import aplicacao.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mirandinha
 */
public class TelaInsereMovimentacaoController implements Initializable {

    public Main main;
    public Stage palco;

    @FXML
    private TextField labelValor;

    @FXML
    private ComboBox<?> comboBoxStatusMovimentacao;

    @FXML
    private ComboBox<?> comboBoxCategoria;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private RadioButton buttonRadioReceita;

    @FXML
    private RadioButton buttonRadioDespesa;
    
    @FXML
    private ToggleGroup toggleGroupTipo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggleGroupTipo = new ToggleGroup();
    }

    @FXML
    void handleButtonAdicionar(ActionEvent event) {
        main.mostraTelaPrincipal();
    }

    @FXML
    void handleButtonCancelar(ActionEvent event) {
        main.mostraTelaPrincipal();
    }
    
    @FXML
    void handleRadioGroupTipo(ActionEvent event){
        RadioButton radioSelecionado = (RadioButton)event.getSource();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
}
