package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Mirandinha
 */
public class Categoria {

    private int idCategoria;
    //private StringProperty descricao;
    private String descricao;

    public Categoria() {

    }

    public Categoria(String descricao) {
        //   this.descricao = new SimpleStringProperty(descricao);
        this.descricao = descricao;
    }

    public Categoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(int idCategoria, String descricao) {
        this.idCategoria = idCategoria;
//        this.descricao = new SimpleStringProperty(descricao);
        this.descricao = descricao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

//    public StringProperty getDescricaoProperty() {
//        return descricao;
//    }

//    public String getDescricao() {
//        return descricao.get();
//    }

//    public void setDescricao(String descricao) {
//        this.descricao.set(descricao);
//    }

//    Adicionado para o Banco de Dados funcionar corretamente.
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricaoBD) {
        this.descricao = descricaoBD;
    }
    public void exibeDadosCategoria() {
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdCategoria());
       // System.out.println("Descrição= " + getDescricaoProperty());
        System.out.println("Descrição= " + getDescricao());
    }

//    @Override
//    public String toString() {
//        return "Categoria{" + "idCategoria=" + idCategoria + ", descricao=" + descricao + ", descricaoBD=" + descricaoBD + '}';
//    }
    @Override
    public String toString() {
        return getDescricao();
    }
}
