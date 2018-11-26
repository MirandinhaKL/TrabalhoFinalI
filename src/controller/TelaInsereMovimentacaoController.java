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
    private List<Categoria> listaDeCategorias;
    private ObservableList<Categoria> categoriaObservable;

    @FXML
    private TextField labelValor;

    @FXML
    private ComboBox comboBoxStatusMovimentacao;

    @FXML
    private ComboBox comboBoxCategoria;

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

        categoria = new Categoria();
        categoria.setIdCategoria(1);
        categoria.setDescricao(categoriaRetornada);
        DAOCategoria conectaCateogoria = new DAOCategoria();
        conectaCateogoria.adicionaCategoria(categoria);

        tipoDeMovimentacao = new TipoDeMovimentacao();
        tipoDeMovimentacao.setIdTipoMovimentacao(1);
        tipoDeMovimentacao.setDescricao(radioBtnTipoMovimentacao);
        DAOTipoDeMovimentacao conectaTipo = new DAOTipoDeMovimentacao();
        conectaTipo.adicionaTipoDeMovimentacao(tipoDeMovimentacao);

        DAOMovimentacao conectaDBMovimentacao = new DAOMovimentacao();
        movimentacao = new Movimentacao();
        movimentacao.setIdMovimentacao(1);
        movimentacao.setValor(Double.parseDouble(labelValor.getText()));
        movimentacao.setParaOfuturo(converteComboBoxStatus()); // ver se funciona
        movimentacao.setData(dataSelecionada);
        movimentacao.setDescricao(labelDescricao.getText());
        movimentacao.setTipo(tipoDeMovimentacao);
        movimentacao.setCategoria(categoria);
        
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
        System.out.println("Verificando radioButton " + radioBtnTipoMovimentacao);
    }

    public void preencheComboBoxStatus() {
        comboBoxStatusMovimentacao.getItems().removeAll(comboBoxCategoria.getItems());
        comboBoxStatusMovimentacao.getItems().addAll("Já efetuada", "Agendada");
    }

    @FXML
    void handleComboBoxStatusMovimentacao(ActionEvent event) {
        statusRetornado = comboBoxStatusMovimentacao.getValue().toString(); //adicionei o toString
        converteComboBoxStatus();
        System.out.println(statusRetornado);
    }

    public boolean converteComboBoxStatus() {
        if (statusRetornado.equalsIgnoreCase("Já efetuada")) {
            return false;
        } else if (statusRetornado.equalsIgnoreCase("Agendada")) {
            return true;
        }
        return false;
    }

    @FXML
    void handleDataPicker(ActionEvent event) {
        dataSelecionada = dataPicker.getValue();
        System.out.println(dataSelecionada);
    }

    @FXML
    void handleComboBoxCategoria(ActionEvent event) {
        categoriaRetornada = comboBoxCategoria.getValue().toString();
        System.out.println(categoriaRetornada);
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
