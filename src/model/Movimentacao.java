package model;

import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.ObjectProperty;
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.beans.property.SimpleObjectProperty;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;

/**
 * @author Mirandinha
 */
public class Movimentacao {

    private int idMovimentacao;
    private TipoDeMovimentacao tipoBD;
    private Categoria categoriaBD;
    private LocalDate data;
    private double valor;
    private String descricao;
    private char paraOfuturo;

//    private ObjectProperty<LocalDate> data;
//    private DoubleProperty valor;
//    private StringProperty descricao;
//    private char pago;
//    private ObjectProperty<TipoDeMovimentacao> tipo;
//    private ObjectProperty<Categoria> categoria;
    public Movimentacao(int idMovimentacao, LocalDate data, double valor, String descricao, char pago, int tipo, int categoria) {
        super();
        this.idMovimentacao = idMovimentacao;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.paraOfuturo = pago;
    }
    
    

    public Movimentacao(LocalDate data, double valor, String descricao, char pago, TipoDeMovimentacao tipo, Categoria categoria) {
        super();
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.paraOfuturo = pago;
        this.tipoBD = tipo;
        this.categoriaBD = categoria;
    }

    public Movimentacao(int id, LocalDate data, double valor, String descricao, char pago) {
        super();
        this.idMovimentacao = id;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.paraOfuturo = pago;
    }

    public Movimentacao(TipoDeMovimentacao tipo, Categoria categoria, LocalDate data, double valor, String descricao, char pago) {
        super();
        this.tipoBD = tipo;
        this.categoriaBD = categoria;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.paraOfuturo = pago;
    }

//    public Movimentacao(int idMovimentacao, LocalDate data, double valor, String descricao, char pago, TipoDeMovimentacao tipo, Categoria categoria) {
//        this.idMovimentacao = idMovimentacao;
//        this.data = new SimpleObjectProperty<LocalDate>(data);
//        this.valor = new SimpleDoubleProperty(valor);
//        this.descricao = new SimpleStringProperty(descricao);
//        this.pago = pago;
//        this.tipo = new SimpleObjectProperty<TipoDeMovimentacao>(tipo);
//        this.categoria = new SimpleObjectProperty<Categoria>(categoria);
//    }
//
    public Movimentacao() {
        super();
    }

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getParaOfuturo() {
        return paraOfuturo;
    }

    public void setParaOfuturo(char paraOfuturo) {
        this.paraOfuturo = paraOfuturo;
    }

//    public ObjectProperty<LocalDate> getDataProperty() {
//        return data;
//    }
//
//    public void setData(LocalDate data) {
//        this.data.set(data);
//    }
//    
//    public LocalDate getData(){
//        return data.get();
//    }
//
//    public double getValor() {
//        return valor.get();
//    }
//
//    public void setValor(double valor) {
//        this.valor.set(valor);
//    }
//
//    public DoubleProperty valorProperty() {
//        return valor;
//    }
//
//    public String getDescricao() {
//        return descricao.get();
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao.set(descricao);
//    }
//
//    public StringProperty descricaoProperty() {
//        return descricao;
//    }
//
//    public char getPago() {
//        return pago;
//    }
//
//    public void setPago(char pago) {
//        this.pago = pago;
//    }
//
//    public ObjectProperty<TipoDeMovimentacao> getTipoProperty() {
//        return tipo;
//    }
//
//    public void setTipo(TipoDeMovimentacao tipo) {
//        this.tipo.set(tipo);
//    }
//    
//    public TipoDeMovimentacao getTipo(){
//        return tipo.get();
//    }
//
//    public ObjectProperty<Categoria> getCategoriaProperty() {
//        return categoria;
//    }
//
//    public void setCategoria(Categoria categoria) {
//        this.categoria.set(categoria);
//    }
//    
//    public Categoria getCategoria(){
//        return categoria.get();
//    }
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
        System.out.println("Valor = R$ " + getValor());
        System.out.println("Tipo = " + getTipoBD().getDescricaoBD());
        System.out.println("Categoria = " + getCategoriaBD().getDescricaoBD());
    }

    public String exibeTipoDeMovimentacao() {
        return getTipoBD().getDescricaoBD();
    }

    public String exibeValorDaMovimentacao() {
        return "R$ " + String.valueOf(getValor());
    }
}
