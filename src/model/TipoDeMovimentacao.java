package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Mirandinha
 */
public class TipoDeMovimentacao {

    private int idTipoMovimentacao;
   // private StringProperty descricao;
    private String descricao;

    public TipoDeMovimentacao(int idMovimentacao, String descricao) {
        this.idTipoMovimentacao = idMovimentacao;
       // this.descricao = new SimpleStringProperty(descricao);
        this.descricao = descricao;
    }

    public TipoDeMovimentacao() {

    }

    public TipoDeMovimentacao(int idMovimentacao) {
        this.idTipoMovimentacao = idMovimentacao;
    }

    public TipoDeMovimentacao(String descricao) {
      //  this.descricao = new SimpleStringProperty(descricao);
        this.descricao = descricao;
    }

    public int getIdTipoMovimentacao() {
        return idTipoMovimentacao;
    }

    public void setIdTipoMovimentacao(int idMovimentacao) {
        this.idTipoMovimentacao = idMovimentacao;
    }

//    public StringProperty descricaoProperty() {
//        return descricao;
//    }

//    public String getDescricao() {
//        return descricao.get();
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao.set(descricao);
//    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void exibeTiposDeMovimetacoes() {
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdTipoMovimentacao());
        System.out.println("Descrição= " + getDescricao());
    }

//    @Override
//    public String toString() {
//        return "TipoDeMovimentacao{" + "idTipoMovimentacao=" + idTipoMovimentacao + ", descricao=" + descricao + ", descricaoBD=" + descricaoBD + '}';
//    }
    @Override
    public String toString() {
        return getDescricao();
    }
}
