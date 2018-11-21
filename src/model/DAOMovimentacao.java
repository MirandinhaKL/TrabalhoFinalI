package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
        String sql = "insert into movimentacao(categoria, tipo, valor, descricao, pago, datas) value (?,?,?,?,?,?)";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, move.getCategoriaBD().getIdCategoria());
            declaracao.setInt(2, move.getTipoBD().getIdTipoMovimentacao());
            declaracao.setDouble(3, move.getValor());
            declaracao.setString(4, move.getDescricao());
            declaracao.setString(5, String.valueOf(move.getParaOfuturo()));
            declaracao.setDate(6, java.sql.Date.valueOf(move.getData()));
            System.out.println(move.getTipoBD().getIdTipoMovimentacao());
            System.out.println(move.getCategoriaBD().getIdCategoria());
            System.out.println(java.sql.Date.valueOf(move.getData()));
            System.out.println(move.getValor());
            System.out.println(move.getDescricao());
            System.out.println(String.valueOf(move.getParaOfuturo()));
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
        List<Movimentacao> listaDeMovimentacoes = new ArrayList<>();
        String sql = "select * from movimentacao;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet consultaBD = declaracao.executeQuery();
            while (consultaBD.next()) {
                Movimentacao movimentacao = new Movimentacao();
                TipoDeMovimentacao tipoMovimentacao = new TipoDeMovimentacao();
                Categoria categoria = new Categoria();
                
                movimentacao.setIdMovimentacao(consultaBD.getInt("id"));
                tipoMovimentacao.setIdTipoMovimentacao(consultaBD.getInt("tipo"));
                categoria.setIdCategoria(consultaBD.getInt("categoria"));
                
                movimentacao.setData(consultaBD.getDate("datas").toLocalDate());
                movimentacao.setValor(consultaBD.getDouble("valor"));
                movimentacao.setDescricao(consultaBD.getString("descricao"));
                movimentacao.setParaOfuturo(consultaBD.getString("pago").charAt(0));
               
                //Obtendo os dados completos do TipoDeMovimentação
                DAOTipoDeMovimentacao tipoMovimentacaoDao = new DAOTipoDeMovimentacao();
                tipoMovimentacao = tipoMovimentacaoDao.retornaUmTipo(tipoMovimentacao);
                
                //Obtendo os dados completos da Categoria.
                DAOCategoria categoriaDAO = new DAOCategoria();
                categoria = categoriaDAO.retornaUmaCategoria(categoria);
                
                movimentacao.setCategoriaBD(categoria);
                movimentacao.setTipoBD(tipoMovimentacao);
                listaDeMovimentacoes.add(movimentacao);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getMessage());
            Logger.getLogger(DAOMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listaDeMovimentacoes;
    }
}
