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

//    private int idMovimentacao;
//    private ObjectProperty<LocalDate> data;
//    private DoubleProperty valor;
//    private StringProperty descricao;
//    private StringProperty paraOfuturo;
//    private ObjectProperty<TipoDeMovimentacao> tipo;
//    private ObjectProperty<Categoria> categoria;
    private int idMovimentacao;
    private LocalDate data;
    private double valor;
    private String descricao;
    private boolean paraOfuturo;
    private TipoDeMovimentacao tipo;
    private Categoria categoria;

//    public Movimentacao(TipoDeMovimentacao tipo, Categoria categoria, LocalDate data, double valor, String descricao, String pago) {
//        this.tipo = new SimpleObjectProperty<TipoDeMovimentacao>(tipo);
//        this.categoria = new SimpleObjectProperty<Categoria>(categoria);
//        this.data = new SimpleObjectProperty<LocalDate>(data);
//        this.valor = new SimpleDoubleProperty(valor);
//        this.descricao = new SimpleStringProperty(descricao);
//        this.paraOfuturo = new SimpleStringProperty(pago);
//    }
    public Movimentacao(TipoDeMovimentacao tipo, Categoria categoria, LocalDate data, double valor, String descricao, boolean pago) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.paraOfuturo = pago;
    }

//    public Movimentacao(int idMovimentacao, TipoDeMovimentacao tipo, Categoria categoria, LocalDate data, double valor, String descricao, String pago) {
//        this.idMovimentacao = idMovimentacao;
//        this.tipo = new SimpleObjectProperty<TipoDeMovimentacao>(tipo);
//        this.categoria = new SimpleObjectProperty<Categoria>(categoria);
//        this.data = new SimpleObjectProperty<LocalDate>(data);
//        this.valor = new SimpleDoubleProperty(valor);
//        this.descricao = new SimpleStringProperty(descricao);
//        this.paraOfuturo = new SimpleStringProperty(pago);
//  }
    
    public Movimentacao(int idMovimentacao, TipoDeMovimentacao tipo, Categoria categoria, LocalDate data, double valor, String descricao, boolean pago) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.paraOfuturo = pago;
    }

    public Movimentacao() {
        super();
    }

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

//    public ObjectProperty<LocalDate> dataProperty() {
//        return data;
//    }
//
//    public LocalDate getData() {
//        return data.get();
//    }
//
//    public void setData(LocalDate data) {
//        this.data.set(data);
//    }
//
//    public DoubleProperty valorProperty() {
//        return valor;
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
//    public StringProperty descricaoProperty() {
//        return descricao;
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
//    public StringProperty paraOfuturoProperty() {
//        return paraOfuturo;
//    }
//
//    public String getParaOfuturo() {
//        return paraOfuturo.get();
//    }
//
//    public void setParaOfuturo(String paraOfuturo) {
//        this.paraOfuturo.set(paraOfuturo);
//    }
//
//    public ObjectProperty<TipoDeMovimentacao> tipoProperty() {
//        return tipo;
//    }
//
//    public TipoDeMovimentacao getTipo() {
//        return tipo.get();
//    }
//
//    public void setTipo(TipoDeMovimentacao tipo) {
//        this.tipo.set(tipo);
//    }
//
//    public ObjectProperty<Categoria> categoriaProperty() {
//        return categoria;
//    }
//
//    public Categoria getCategoria() {
//        return categoria.get();
//    }
//
//    public void setCategoria(Categoria categoria) {
//        this.categoria.set(categoria);
//    }

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

    public boolean getParaOfuturo() {
        return paraOfuturo;
    }

    public void setParaOfuturo(boolean paraOfuturo) {
        this.paraOfuturo = paraOfuturo;
    }

    public TipoDeMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeMovimentacao tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    public void exibeTodasMovimentacoes() {
        System.out.println("=========================== ");
        System.out.println("ID = " + getIdMovimentacao());
        System.out.println("Data = " + getData());
        System.out.println("Descrição = " + getDescricao());
        System.out.println("Valor = R$ " + getValor());
        System.out.println("Tipo = " + getTipo().getDescricao());
        System.out.println("Categoria = " + getCategoria().getDescricao());
        System.out.println("Status da operação = " + getParaOfuturo());
    }

    public String exibeTipoDeMovimentacao() {
        return getTipo().getDescricao();
    }

    public String exibeValorDaMovimentacao() {
        return "R$ " + String.valueOf(getValor());
    }
}
