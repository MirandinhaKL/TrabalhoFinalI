package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Mirandinha
 */
public class Categoria {

    private int idCategoria;
    private StringProperty descricao;
    private String descricaoBD;

    public Categoria() {
       
    }
    
    public Categoria(String descricao){
        this.descricao = new SimpleStringProperty(descricao);
        this.descricaoBD = descricao;
    }
    
    public Categoria(int idCategoria){
        this.idCategoria = idCategoria;
    }

    public Categoria(int idCategoria, String descricao) {
        this.idCategoria = idCategoria;
        this.descricao = new SimpleStringProperty(descricao);
        this.descricaoBD = descricao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }
    
    public StringProperty getDescricaoProperty(){
        return descricao;
    }

    //Adicionado para o Banco de Dados funcionar corretamente.
    
    public String getDescricaoBD() {
        return descricaoBD;
    }

    public void setDescricaoBD(String descricaoBD) {
        this.descricaoBD = descricaoBD;
    }
    
     public void exibeDadosCategoria(){
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdCategoria());
        System.out.println("Descrição= " + getDescricaoBD());
    }
}
