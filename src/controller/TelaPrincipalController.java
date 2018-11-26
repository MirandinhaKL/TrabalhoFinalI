package controller;

import aplicacao.Main;
import java.awt.Color;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Categoria;
import model.DAOMovimentacao;
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
    private Movimentacao movimentacao;
    private double saldoAtual;
    private double receitaTotal;
    private double despesaTotal;
    private String mesSelecionado;
    private List<Movimentacao> listaDeMovimentacoes;
    private static DAOMovimentacao daoMovimentacao = new DAOMovimentacao();
    //private DateTimeFormatter dataFormatada;
    private ObservableList<Movimentacao> movimentacaoObservable;
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
        carregarTabelaComDadosDoBanco();
        exibeUltimaMovimentacao();
//        DAOMovimentacao dao = new DAOMovimentacao();
//        dao.retornaListaDeMovimentacoes();
//        calculaSaldoAtual();
//        calculaSaldoPrevisto();
//        configuraLabelDoSaldoAtual();
//        configuraLabelDoSaldoPrevisto();
    }

    @FXML
    void handleComboBox(ActionEvent event) {
        mesSelecionado = comboBoxMes.getValue();
        System.out.println(mesSelecionado);
    }

    @FXML
    void handleButtonInserirMovimentacao(ActionEvent event) {
        main.exibeTelaInsereMovimentacao();
    }

    @FXML
    void handleButtonGeraGraficos(ActionEvent event) {
        main.exibeTelaDeGraficos();
    }
    
    @FXML
    void handleButtonExcluir(ActionEvent event) {
        Movimentacao movimentacao = tabelaMovimentacao.getSelectionModel().getSelectedItem();
        if (movimentacao != null) {
            DAOMovimentacao conectaBD = new DAOMovimentacao();
            conectaBD.removeMovimentacao(movimentacao);
            carregarTabelaComDadosDoBanco();
        }else{
            String titulo = "Falha na exclusão...";
            String cabecalho = "Item não excluído!";
            String mensagem = "\"Por favor, selecione uma movimentação"
                    + " financeira na tabela.";
            main.mostraAlerta(Alert.AlertType.WARNING, titulo, cabecalho, mensagem);
        }
    }
    

    /**
     * Configura a exibição da data para o formato Brasileiro.
     */
//    private DateTimeFormatter formataData() {
//        return dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//    }
    
    
    public void carregarTabelaComDadosDoBanco() {
        daoMovimentacao = new DAOMovimentacao();
        listaDeMovimentacoes = daoMovimentacao.retornaListaDeMovimentacoes();
        movimentacaoObservable = FXCollections.observableArrayList(listaDeMovimentacoes);
        tabelaMovimentacao.setItems(movimentacaoObservable);
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    }

    private void criaTabela() {
        tabelaMovimentacao.setItems(movimentacaoObservable);
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
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
     * @param tipo - Informa se a movimentação é uma receita ou despesa.
     * @param ehNofuturo boolean = 0, se já aconteceu. 1, se a operação foi
     * agendada.
     * @return somatório de todas as movimentações especificas realizadas.
     */
    public double calculaMovimentacao(String tipo, boolean ehNofuturo) {
        String tipoDeMovimentacao;
        boolean statusDaMovimentacao;
        double somatorioMovimentacoes = 0;
        for (int i = 0; i < movimentacaoObservable.size(); i++) {
            tipoDeMovimentacao = movimentacaoObservable.get(i).getTipo().getDescricao();
            statusDaMovimentacao = movimentacaoObservable.get(i).getParaOfuturo(); //alterada
            if (tipoDeMovimentacao.equalsIgnoreCase(tipo) && (statusDaMovimentacao == ehNofuturo)) {
                somatorioMovimentacoes = somatorioMovimentacoes + movimentacaoObservable.get(i).getValor();
            }
        }
        return somatorioMovimentacoes;
    }

    /**
     * @return Somatório das desepesas efetuadas.
     */
    public double calculoDaDespesaAtual() {
        return calculaMovimentacao("Despesa", false);
    }

    /**
     * @return Somatório das desepesas efetuadas + as planejadas.
     */
    public double calculaDaDespesaFutura() {
        return calculaMovimentacao("Despesa", true) + calculoDaDespesaAtual();
    }

    /**
     * @return Somatório das receitas efetuadas.
     */
    public double calculaDaReceitaAtual() {
        return calculaMovimentacao("Receita", false);
    }

    /**
     * @return Somatório das receitas efetuadas + as planejadas.
     */
    public double calculoDaReceitaFutura() {
        return calculaMovimentacao("Receita", true) + calculaDaReceitaAtual();
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

    private int converteMes() {
        int numeroDoMes = 0;
        switch (mesSelecionado) {
            case "Janeiro":
                numeroDoMes = 1;
                break;
            case "Fevereiro":
                numeroDoMes = 2;
                break;
            case "Março":
                numeroDoMes = 3;
                break;
            case "Abril":
                numeroDoMes = 4;
                break;
            case "Maio":
                numeroDoMes = 5;
                break;
            case "Junho":
                numeroDoMes = 6;
                break;
            case "Julho":
                numeroDoMes = 7;
                break;
            case "Agosto":
                numeroDoMes = 8;
                break;
            case "Setembro":
                numeroDoMes = 9;
                break;
            case "Outubro":
                numeroDoMes = 10;
                break;
            case "Novembro":
                numeroDoMes = 11;
                break;
            case "Dezembro":
                numeroDoMes = 12;
                break;
        }
        return numeroDoMes;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }

}
