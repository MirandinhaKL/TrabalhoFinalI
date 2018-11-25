package controller;

import aplicacao.Main;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Categoria;
import model.DAOCategoria;
import model.DAOMovimentacao;
import model.DAOTipoDeMovimentacao;
import model.Movimentacao;
import model.TipoDeMovimentacao;

/**
 * FXML Controller class
 *
 * @author Mirandinha
 */
public class TelaInsereMovimentacaoController implements Initializable {

    public Main main;
    public Stage palco;
    public LocalDate dataSelecionada;
    private Movimentacao movimentacao;
    private TipoDeMovimentacao tipoDeMovimentacao;
    private Categoria categoria;
    private String radioBtnTipoMovimentacao;
    private String statusRetornado;
    private String categoriaRetornada;

    @FXML
    private TextField labelValor;

    @FXML
    private ComboBox<String> comboBoxStatusMovimentacao;

    @FXML
    private ComboBox<String> comboBoxCategoria;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private RadioButton buttonRadioReceita;

    @FXML
    private RadioButton buttonRadioDespesa;

    @FXML
    private ToggleGroup toggleGroupTipo;

    @FXML
    private TextField labelDescricao;

    /**
     * Initializes the controller class.
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggleGroupTipo = new ToggleGroup();
        preencheComboBoxStatus();
        preencheComboBoxCategoria();
    }

    @FXML
    void handleButtonAdicionar(ActionEvent event) {
        movimentacao = new Movimentacao();
        tipoDeMovimentacao = new TipoDeMovimentacao();
        categoria = new Categoria();

        tipoDeMovimentacao.setIdTipoMovimentacao(700);
        tipoDeMovimentacao.setDescricao(radioBtnTipoMovimentacao);

        categoria.setIdCategoria(700);
        categoria.setDescricao(categoriaRetornada);

        DAOTipoDeMovimentacao conectaTipo = new DAOTipoDeMovimentacao();
        conectaTipo.adicionaTipoDeMovimentacao(tipoDeMovimentacao);
        DAOCategoria conectaCateogoria = new DAOCategoria();
        conectaCateogoria.adicionaCategoria(categoria);

        movimentacao.setIdMovimentacao(700);
        movimentacao.setValor(Double.parseDouble(labelValor.getText()));
        movimentacao.setParaOfuturo(true); // ver se funciona
        movimentacao.setData(dataSelecionada);
        movimentacao.setDescricao(labelDescricao.getText());
        movimentacao.setTipo(tipoDeMovimentacao);
        movimentacao.setCategoria(categoria);

        DAOMovimentacao conectaDBMovimentacao = new DAOMovimentacao();
        conectaDBMovimentacao.adicionaMovimentacao(movimentacao);

        main.exibeTelaPrincipal();
    }

    @FXML
    void handleButtonCancelar(ActionEvent event) {
        main.exibeTelaPrincipal();
    }

    @FXML
    void handleRadioGroupTipo(ActionEvent event) {
        RadioButton radioSelecionado = (RadioButton) event.getSource();
        radioBtnTipoMovimentacao = radioSelecionado.getText();
        System.out.println(radioBtnTipoMovimentacao);
    }

    @FXML
    void handleComboBoxStatusMovimentacao(ActionEvent event) {
        statusRetornado = comboBoxStatusMovimentacao.getValue();
        System.out.println(statusRetornado);
    }

    @FXML
    void handleDataPicker(ActionEvent event) {
        dataSelecionada = dataPicker.getValue();
        System.out.println(dataSelecionada);
    }

    @FXML
    void handleComboBoxCategoria(ActionEvent event) {
        categoriaRetornada = comboBoxCategoria.getValue();
        System.out.println(categoriaRetornada);
    }

    public void preencheComboBoxStatus() {
        comboBoxStatusMovimentacao.getItems().removeAll(comboBoxStatusMovimentacao.getItems());
        comboBoxStatusMovimentacao.getItems().addAll("Já efetuada", "Agendada");
    }

    public Character converteParaCharOStatus() {
        System.out.println(statusRetornado);
        if (statusRetornado.equalsIgnoreCase("Já efetuada")) {
            return 'n';
        } else if (statusRetornado.equalsIgnoreCase("Agendada")) {
            return 's';
        }
        return null;
    }

    public void preencheComboBoxCategoria() {
        comboBoxCategoria.getItems().removeAll(comboBoxCategoria.getItems());
        comboBoxCategoria.getItems().addAll("Alimentação", "Educação", "Esporte",
                "Lazer", "Moradia", "Outros", "Presentes", "Roupas", "Salário",
                "Saúde", "Transporte", "Viagem");
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
}
