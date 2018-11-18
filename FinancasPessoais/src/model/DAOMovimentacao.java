package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * @author Mirandinha
 */
public class DAOMovimentacao {

    private Connection conexao;

    /**
     * Classe construtora que cria a conexão com o banco de dados.
     */
    public DAOMovimentacao() {
        this.conexao = new ConexaoBancoDeDados().getConexao();
    }

    public boolean adicionaMovimentacao(Movimentacao move) {
        String sql = "insert into movimentacao(tipo, categoria) value (?,?);";
        //String sql = "insert into movimentacao(tipo, categoria, data, valor, descricao, pago) value (?,?,?,?,?,?);";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, move.getTipo().getIdTipoMovimentacao());
            declaracao.setInt(2, move.getCategoria().getIdCategoria());
//            declaracao.setDate(3, java.sql.Date.valueOf(move.getData()));
//            declaracao.setDouble(4, move.getValor());
//            declaracao.setString(5, move.getDescricao());
//            declaracao.setString(6, String.valueOf(move.getPago()));
            System.out.println("Foi até aqui!");
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (SQLException excecao) {
            excecao.getMessage().toString();
            return false;
        }
    }

//    public List<Movimentacao> retornaListaDeMovimentacoes() {
//        List<Movimentacao> listaDeMovimentacoes = new ArrayList<>();
//        String sql = "select * from movimentacao;";
//        try {
//            PreparedStatement declaracao = conexao.prepareStatement(sql);
//            ResultSet consultaBD = declaracao.executeQuery();
//            while (consultaBD.next()) {
//                Movimentacao movimentacao = new Movimentacao();
//                TipoDeMovimentacao tipoMovimentacao = new TipoDeMovimentacao();
//                Categoria categoria = new Categoria();
//                movimentacao.setIdMovimentacao(consultaBD.getInt("id"));
//                tipoMovimentacao.setIdTipoMovimentacao(consultaBD.getInt("tipo"));
//                categoria.setIdCategoria(consultaBD.getInt("categoria"));
//                movimentacao.setData(consultaBD.getDate("data").toLocalDate());
//                movimentacao.setValor(consultaBD.getDouble("valor"));
//                movimentacao.setDescricao(consultaBD.getString("descricao"));
//                movimentacao.setPago(consultaBD.getString("pago").charAt(0));
//               
//                //Obtendo os dados completos do TipoDeMovimentação
//               // DAOTipoDeMovimentacao tipoDao = new TipoDeMovimentacao();
//                
//            }
//        } catch (Exception e) {
//        }
//    }
}
