package model;

import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Mirandinha
 */
public class Movimentacao {

    private int idMovimentacao;
    private ObjectProperty<LocalDate> data;
    private DoubleProperty valor;
    private StringProperty descricao;
    private char pago;
    private ObjectProperty<TipoDeMovimentacao> tipo;
    private ObjectProperty<Categoria> categoria;
    
    private TipoDeMovimentacao tipoBD;
    private Categoria categoriaBD;
    

    public Movimentacao(int idMovimentacao, LocalDate data, double valor, String descricao, char pago, TipoDeMovimentacao tipo, Categoria categoria) {
        this.idMovimentacao = idMovimentacao;
        this.data = new SimpleObjectProperty<LocalDate>(data);
        this.valor = new SimpleDoubleProperty(valor);
        this.descricao = new SimpleStringProperty(descricao);
        this.pago = pago;
        this.tipo = new SimpleObjectProperty<TipoDeMovimentacao>(tipo);
        this.categoria = new SimpleObjectProperty<Categoria>(categoria);
    }

    public Movimentacao(TipoDeMovimentacao tipo, Categoria categoria, LocalDate data, double valor, String descricao, char pago) {
        this.tipo = new SimpleObjectProperty<TipoDeMovimentacao>(tipo);
        this.categoria = new SimpleObjectProperty<Categoria>(categoria);
        this.data = new SimpleObjectProperty<LocalDate>(data);
        this.valor = new SimpleDoubleProperty(valor);
        this.descricao = new SimpleStringProperty(descricao);
        this.pago = pago;
    }

    public Movimentacao(TipoDeMovimentacao tipo, Categoria categoria) {
        this.tipo = new SimpleObjectProperty<TipoDeMovimentacao>(tipo);
        this.categoria =new SimpleObjectProperty<Categoria>(categoria);
        this.tipoBD = tipo;
        this.categoriaBD = categoria;
    }

    public Movimentacao() {
    }

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public ObjectProperty<LocalDate> getDataProperty() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data.set(data);
    }
    
    public LocalDate getData(){
        return data.get();
    }

    public double getValor() {
        return valor.get();
    }

    public void setValor(double valor) {
        this.valor.set(valor);
    }

    public DoubleProperty valorProperty() {
        return valor;
    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public char getPago() {
        return pago;
    }

    public void setPago(char pago) {
        this.pago = pago;
    }

    public ObjectProperty<TipoDeMovimentacao> getTipoProperty() {
        return tipo;
    }

    public void setTipo(TipoDeMovimentacao tipo) {
        this.tipo.set(tipo);
    }
    
    public TipoDeMovimentacao getTipo(){
        return tipo.get();
    }

    public ObjectProperty<Categoria> getCategoriaProperty() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria.set(categoria);
    }
    
    public Categoria getCategoria(){
        return categoria.get();
    }

    public TipoDeMovimentacao getTipoBD() {
        return tipoBD;
    }

    public void setTipoBD(TipoDeMovimentacao tipoBD) {
        this.tipoBD = tipoBD;
    }

    public Categoria getCategoriaBD() {
        return categoriaBD;
    }

    public void setCategoriaBD(Categoria categoriaBD) {
        this.categoriaBD = categoriaBD;
    }
    
    
    public void exibeTodasMovimentacoes() {
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdMovimentacao());
        System.out.println("Data = " + getData());
        System.out.println("Descrição = " + getDescricao());
        System.out.println("Valor = R$" + getDescricao());
        System.out.println("Tipo =" + getTipoBD());
        System.out.println("Categoria" + getCategoriaBD());
    }
}