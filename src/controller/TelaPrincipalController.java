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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Categoria;
import model.Movimentacao;
import model.TipoDeMovimentacao;

/**
 * FXML Controller class
 *
 * @author Mirandinha
 */
public class TelaPrincipalController implements Initializable {

    private Main main;
    private Stage palco;
    private List<Movimentacao> listaDeMovimentacoes;
    private Categoria categoria1;
    private Categoria categoria2;
    private TipoDeMovimentacao tipoDeMovimentacao1;
    private TipoDeMovimentacao tipoDeMovimentacao2;
    private Movimentacao movimentacao1;
    private Movimentacao movimentacao2;
    private LocalDate hoje;
    private double saldoAtual;
    private ObservableList<Movimentacao> movimentacaoObservable = FXCollections.observableArrayList();
    private ObservableList<String> mesesDoAno = FXCollections.observableArrayList(
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    );
           
    @FXML
    private ComboBox comboBoxMes;

    @FXML
    private TableView<Movimentacao> tabelaMovimentacao;

    @FXML
    private TableColumn<Movimentacao, LocalDate> colunaData;

    @FXML
    private TableColumn<TipoDeMovimentacao, String> colunaTipo;

    @FXML
    private TableColumn<Categoria, String> colunaCategoria;

    @FXML
    private TableColumn<Movimentacao, Long> colunaValor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // preencheComboBoxMes();
        carregaTabelaComDadosManuais();
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tabelaMovimentacao.setItems(movimentacaoObservable);
    }

    private void carregarTabelaComDadosDoBanco() {

    }

    private void carregaTabelaComDadosManuais() {
        categoria1 = new Categoria(20, "Salário");
        categoria2 = new Categoria(21, "Alimentação");
        tipoDeMovimentacao1 = new TipoDeMovimentacao(30, "Receita");
        tipoDeMovimentacao2 = new TipoDeMovimentacao(31, "Despesa");
        hoje = LocalDate.now();
        movimentacao1 = new Movimentacao(1, hoje, 1200.00, "Câmara de Vereadores", 'S', tipoDeMovimentacao1, categoria1);
        movimentacao2 = new Movimentacao(2, hoje, 450.00, "Restaurante Pingos", 'N', tipoDeMovimentacao2, categoria2);
//        movimentacao1.exibeTodasMovimentacoes();
//        movimentacao2.exibeTodasMovimentacoes();
//        categoria1.exibeDadosCategoria();
//        categoria2.exibeDadosCategoria();
//        tipoDeMovimentacao1.exibeTiposDeMovimetacoes();
//        tipoDeMovimentacao2.exibeTiposDeMovimetacoes();
        movimentacaoObservable.add(movimentacao1);
        movimentacaoObservable.add(movimentacao2);
    }

    @FXML
    void handleButtonInserirMovimentacao(ActionEvent event) {
        main.mostrTelaInsereMovimentacao();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
    
    public void preencheComboBoxMes(){
     comboBoxMes = new ComboBox(mesesDoAno);
    
    }
}
 