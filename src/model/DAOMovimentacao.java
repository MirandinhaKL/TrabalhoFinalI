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
        //String sql = "insert into movimentacao(tipo, categoria) value (?,?);";
//        INSERT INTO movimentacao (tipo, categoria, valor, descricao, pago) VALUES(1, 2, 100, 'Teste', 's');
      String sql = "insert into movimentacao(tipo, categoria, valor, descricao, pago, data) value (?,?,?,?,?,?)";
      
        try {
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, move.getTipoBD().getIdTipoMovimentacao());
            stmt.setInt(2, 2);
            stmt.setInt(3, 1000);
            stmt.setString(4, "Teste 2");
            stmt.setString(5, "s");
            java.sql.Date data = java.sql.Date.valueOf(LocalDate.now());
            stmt.setDate(6, data);
            
            stmt.execute();
            stmt.close();
            conexao.close();
            
            
//        try {
//            PreparedStatement declaracao = conexao.prepareStatement(sql);
//            declaracao.setInt(1, move.getTipoBD().getIdTipoMovimentacao());
//            declaracao.setInt(2, move.getCategoriaBD().getIdCategoria());
//            declaracao.setDate(3, null);
//            declaracao.setDouble(4, 100);
//            declaracao.setString(5, move.getDescricao());
//            declaracao.setString(6, String.valueOf(move.getParaOfuturo()));
//            
//            System.out.println(move.getTipoBD().getIdTipoMovimentacao());
//            System.out.println(move.getCategoriaBD().getIdCategoria());
//            System.out.println(java.sql.Date.valueOf(move.getData()));
//            System.out.println(move.getValor());
//            System.out.println(move.getDescricao());
//            System.out.println(String.valueOf(move.getParaOfuturo()));
//            
////            System.out.println("Foi até aqui!");
//            declaracao.execute();
//            declaracao.close();
//            conexao.close();
//            return true;
//        } catch (SQLException excecao) {
//            excecao.getMessage().toString();
//            return false;
//        }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public List<Movimentacao> retornaListaDeMovimentacoes() {
        return null;
    }
}