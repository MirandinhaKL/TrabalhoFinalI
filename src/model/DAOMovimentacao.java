package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mirandinha
 */
public class DAOMovimentacao {

    private Connection conexao;

    /**
     * Classe construtora que cria a conexão com o banco de dados.
     */
    public DAOMovimentacao() {
        this.conexao = ConexaoBancoDeDados.getConexao();
    }

    public boolean adicionaMovimentacao(Movimentacao move) {
        String sql = "insert into movimentacao(tipo, categoria, datas, valor, descricao, pago) value (?,?,?,?,?,?)";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, move.getTipo().getIdTipoMovimentacao());
            System.out.println("id categoria = " + move.getCategoria().getIdCategoria());
            declaracao.setInt(2, move.getCategoria().getIdCategoria());
            System.out.println("id tipo = " + move.getTipo().getIdTipoMovimentacao());
            declaracao.setDate(3, Date.valueOf(move.getData()));
            System.out.println("data = " + java.sql.Date.valueOf(move.getData()));
            declaracao.setDouble(4, move.getValor());
            System.out.println("valor = " + move.getValor());
            declaracao.setString(5, move.getDescricao());
            System.out.println("descrição = " + move.getDescricao());
            declaracao.setBoolean(6, move.getParaOfuturo());
            System.out.println("operação para o futuro: " + String.valueOf(move.getParaOfuturo()));
            System.out.println("Foi até aqui!");
            declaracao.execute();
            declaracao.close();
            conexao.close();

        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public List<Movimentacao> retornaListaDeMovimentacoes() {
        List<Movimentacao> listaRetornada = new ArrayList<>();
        String sql = "select * from movimentacao;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet consultaBD = declaracao.executeQuery();
            while (consultaBD.next()) {
                Movimentacao movimentacao = new Movimentacao();
                TipoDeMovimentacao tipoMovimentacao = new TipoDeMovimentacao();
                Categoria categoria = new Categoria();

                movimentacao.setIdMovimentacao(consultaBD.getInt("id"));
                tipoMovimentacao.setIdTipoMovimentacao(consultaBD.getInt("id"));
                categoria.setIdCategoria(consultaBD.getInt("id"));

                movimentacao.setData(consultaBD.getDate("data").toLocalDate());
                movimentacao.setValor(consultaBD.getDouble("valor"));
                movimentacao.setDescricao(consultaBD.getString("descricao"));
                movimentacao.setParaOfuturo(consultaBD.getBoolean("pago"));

                //Obtendo os dados completos do TipoDeMovimentação
                DAOTipoDeMovimentacao tipoMovimentacaoDao = new DAOTipoDeMovimentacao();
                tipoMovimentacao = tipoMovimentacaoDao.retornaUmTipo(tipoMovimentacao);

                //Obtendo os dados completos da Categoria.
                DAOCategoria categoriaDAO = new DAOCategoria();
                categoria = categoriaDAO.retornaUmaCategoria(categoria);

                movimentacao.setCategoria(categoria);
                movimentacao.setTipo(tipoMovimentacao);
                listaRetornada.add(movimentacao);
            }
            declaracao.close();
            conexao.close();
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRetornada;
    }

    public boolean removeMovimentacao(Movimentacao movimentacao) {
        String sql = "Delete FROM movimentacao WHERE id = ?;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, movimentacao.getIdMovimentacao());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
