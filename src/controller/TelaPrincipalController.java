package controller;

import aplicacao.Main;
import java.awt.Color;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    private Categoria categoria3;
    private TipoDeMovimentacao tipoDeMovimentacao1;
    private TipoDeMovimentacao tipoDeMovimentacao2;
    private TipoDeMovimentacao tipoDeMovimentacao3;
    private Movimentacao movimentacao1;
    private Movimentacao movimentacao2;
    private Movimentacao movimentacao3;
    private LocalDate hoje;
    private double saldoAtual;
    private double receitaTotal;
    private double despesaTotal;
    //private DateTimeFormatter dataFormatada;
    private ObservableList<Movimentacao> movimentacaoObservable = FXCollections.observableArrayList();

    @FXML
    private Label labelTipo;

    @FXML
    private Label labelUltimaMovimentacao;

    @FXML
    private Label labelSaldoAtual;

    @FXML
    private Label labelSaldoPrevisto;

    @FXML
    private ComboBox<String> comboBoxMes;

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
        preencheComboBoxMes();
        criaTabela();
        carregaTabelaComDadosManuais();
        exibeUltimaMovimentacao();
        calculaSaldoAtual();
        calculaSaldoPrevisto();
        configuraLabelDoSaldoAtual();
        configuraLabelDoSaldoPrevisto();
    }

    @FXML
    void handleComboBox(ActionEvent event) {
        String mesSelecionado = comboBoxMes.getValue();
        System.out.println(mesSelecionado);
    }

    @FXML
    void handleButtonInserirMovimentacao(ActionEvent event) {
        main.mostrTelaInsereMovimentacao();
    }

    /**
     *  Configura a exibição da data para o formato Brasileiro.
     */
//    private DateTimeFormatter formataData() {
//        return dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//    }

    private void carregarTabelaComDadosDoBanco() {

    }

    private void criaTabela() {
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipoBD"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoriaBD"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tabelaMovimentacao.setItems(movimentacaoObservable);
    }

    private void carregaTabelaComDadosManuais() {
        categoria1 = new Categoria(20, "Salário");
        categoria2 = new Categoria(21, "Alimentação");
        categoria3 = new Categoria(22, "Passagens");
        tipoDeMovimentacao1 = new TipoDeMovimentacao(30, "Receita");
        tipoDeMovimentacao2 = new TipoDeMovimentacao(31, "Despesa");
        tipoDeMovimentacao3 = new TipoDeMovimentacao(32, "Despesa");
        movimentacao1 = new Movimentacao(1, LocalDate.of(2018, 06, 15), 800, "Câmara de Vereadores", 'S', tipoDeMovimentacao1, categoria1);
        movimentacao2 = new Movimentacao(2, LocalDate.of(2018, 10, 15), 200, "Restaurante Pingos", 'N', tipoDeMovimentacao2, categoria2);
        movimentacao3 = new Movimentacao(3, LocalDate.of(2018, 02, 05), 20, "Passagens de ônibus", 'S', tipoDeMovimentacao3, categoria3);
//        movimentacao1.exibeTodasMovimentacoes();
//        movimentacao2.exibeTodasMovimentacoes();
//        categoria1.exibeDadosCategoria();
//        categoria2.exibeDadosCategoria();
//        tipoDeMovimentacao1.exibeTiposDeMovimetacoes();
//        tipoDeMovimentacao2.exibeTiposDeMovimetacoes();
        movimentacaoObservable.add(movimentacao1);
        movimentacaoObservable.add(movimentacao2);
        movimentacaoObservable.add(movimentacao3);
    }

    public void preencheComboBoxMes() {
        comboBoxMes.getItems().removeAll(comboBoxMes.getItems());
        comboBoxMes.getItems().addAll("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro");
    }

    /**
     * Configura o label para exibir a última movimentação na tela.
     */
    public void exibeUltimaMovimentacao() {
        int tamanho = movimentacaoObservable.size();
        labelTipo.setText(movimentacaoObservable.get(tamanho - 1).exibeTipoDeMovimentacao());
        labelUltimaMovimentacao.setText(movimentacaoObservable.get(tamanho - 1).exibeValorDaMovimentacao());
    }

    /**
     * @param tipo - Informar se a movimentação é uma receita ou despesa.
     * @param ehNofuturo - Informar se a movimentação já aconteceu ou está
     * agendada.
     * @return somatório de todas as movimentações especificas realizadas.
     */
    public double calculaMovimentacao(String tipo, char ehNofuturo) {
        String tipoDeMovimentacao;
        char statusDaMovimentacao;
        double somatorioMovimentacoes = 0;
        for (int i = 0; i < movimentacaoObservable.size(); i++) {
            tipoDeMovimentacao = movimentacaoObservable.get(i).getTipoBD().getDescricaoBD();
            statusDaMovimentacao = movimentacaoObservable.get(i).getParaOfuturo();
            if (tipoDeMovimentacao.equalsIgnoreCase(tipo) && statusDaMovimentacao == ehNofuturo) {
                somatorioMovimentacoes = somatorioMovimentacoes + movimentacaoObservable.get(i).getValor();
            }
        }
        return somatorioMovimentacoes;
    }

    /**
     * @return Somatório das desepesas efetuadas.
     */
    public double calculoDaDespesaAtual() {
        return calculaMovimentacao("Despesa", 'N');
    }

    /**
     * @return Somatório das desepesas efetuadas + as planejadas.
     */
    public double calculaDaDespesaFutura() {
        return calculaMovimentacao("Despesa", 'S') + calculoDaDespesaAtual();
    }

    /**
     * @return Somatório das receitas efetuadas.
     */
    public double calculaDaReceitaAtual() {
        return calculaMovimentacao("Receita", 'N');
    }

    /**
     * @return Somatório das receitas efetuadas + as planejadas.
     */
    public double calculoDaReceitaFutura() {
        return calculaMovimentacao("Receita", 'S') + calculaDaReceitaAtual();
    }

    /**
     * @return Retorna o saldo atual das movimentações financeiras efetuadas.
     */
    public double calculaSaldoAtual() {
        return calculaDaReceitaAtual() - calculoDaDespesaAtual();
    }

    /**
     * @return Retorna o saldo atual das movimentações financeiras efetuadas +
     * as previstas.
     */
    public double calculaSaldoPrevisto() {
        return calculoDaReceitaFutura() - calculaDaDespesaFutura();
    }

    /**
     * Configura na tela principal a cor do saldo previsto exibido.
     */
    public void configuraLabelDoSaldoPrevisto() {
        labelSaldoPrevisto.setText("R$ " + String.valueOf(calculaSaldoPrevisto()));
        if (calculaSaldoPrevisto() < 0) {
            labelSaldoPrevisto.setStyle("-fx-text-fill: red");
        } else {
            labelSaldoPrevisto.setStyle("-fx-text-fill: green");
        }
    }

    /**
     * Configura na tela principal a cor do saldo atual exibido.
     */
    public void configuraLabelDoSaldoAtual() {
        labelSaldoAtual.setText("R$ " + String.valueOf(calculaSaldoAtual()));
        if (calculaSaldoAtual() < 0) {
            labelSaldoAtual.setStyle("-fx-text-fill: red");
        } else {
            labelSaldoAtual.setStyle("-fx-text-fill: green");
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
}
