/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Main;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private ObservableList<Movimentacao> movimentacaoObservable;
    private List<Movimentacao> listaDeMovimentacoes;
            
    @FXML
    private TableView<Movimentacao> tabelaMovimentacao;
    
    @FXML
    private TableColumn<Movimentacao, LocalDate> colunaData;

    @FXML
    private TableColumn<TipoDeMovimentacao, String> colunaTipo;

    @FXML
    private TableColumn<Categoria, String> colunaCategoria;

    @FXML
    //private TableColumn<Movimentacao, double> colunaValor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void carregarTabelaComDadosDoBanco(){
        
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
}
