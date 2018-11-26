package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mirandinha
 */
public class DAOTipoDeMovimentacao {

    private Connection conexao;

    /**
     * Classe construtora que cria a conexão com o banco de dados.
     */
    public DAOTipoDeMovimentacao() {
        this.conexao = new ConexaoBancoDeDados().getConexao();
    }

    public boolean adicionaTipoDeMovimentacao(TipoDeMovimentacao novaMovimentacao) {
        String sql = "insert into tipos_movimentacao(descricao) values(?);";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            declaracao.setString(1, novaMovimentacao.getDescricao());
            declaracao.execute();
            System.out.println("DAOTIPO ADICIONADO = " + novaMovimentacao.getDescricao());
            final ResultSet resultado = declaracao.getGeneratedKeys();
            if (resultado.next()) {
                final int ultimoId = resultado.getInt(1);
            }
            declaracao.close();
            conexao.close();
            return true;
        } catch (SQLException excecao) {
            System.out.println(  excecao.getMessage());
            excecao.getMessage();
            return false;
        }
    }

    public boolean atualizaTipoDeMovimentacao(TipoDeMovimentacao tipo) {
        String sql = "update tipos_movimentacao set descricao = ? where id = ?;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setString(1, tipo.getDescricao());
            declaracao.setInt(2, tipo.getIdTipoMovimentacao());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (Exception excecao) {
            excecao.getMessage();
            return false;
        }
    }

    public boolean removeTipoDeMovimentação(TipoDeMovimentacao tipo) {
        String sql = "delete from tipos_movimentacao where id = ?;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, tipo.getIdTipoMovimentacao());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (Exception excecao) {
            excecao.getMessage();
            return false;
        }
    }

    public boolean apagaTodosOsTipoDeMovimentação(TipoDeMovimentacao tipo) {
        String sql = "delete from tipos_movimentacao;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (Exception excecao) {
            excecao.getMessage();
            return false;
        }
    }

    public List<TipoDeMovimentacao> retornaListaDosTiposDeMovimentaoes() {
        List<TipoDeMovimentacao> listaDeTiposDeMovimentacoes = new ArrayList<>();
        String sql = "select * from tipos_movimentacao;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet consultaBD = declaracao.executeQuery();
            while (consultaBD.next()) {
                TipoDeMovimentacao tipo = new TipoDeMovimentacao();
                tipo.setIdTipoMovimentacao(consultaBD.getInt("id"));
                tipo.setDescricao(consultaBD.getString("descricao"));
                listaDeTiposDeMovimentacoes.add(tipo);
            }
            declaracao.close();
            consultaBD.close();
            conexao.close();
        } catch (Exception excecao) {
            excecao.printStackTrace();
            System.out.println("Erro! Lista não retornada!");
            return null;
        }
        return listaDeTiposDeMovimentacoes;
    }

    public TipoDeMovimentacao retornaUmTipo(TipoDeMovimentacao tipo) {
        String sql = "select * from tipos_movimentacao where id=?;";
        TipoDeMovimentacao tipoRetornado = new TipoDeMovimentacao();
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, tipo.getIdTipoMovimentacao());
            ResultSet consultaBD = declaracao.executeQuery();
            if (consultaBD.next()) {
                tipo.setDescricao(consultaBD.getString("descricao"));
                tipoRetornado = tipo;
                System.out.println("CLASSE DAO TIPO RETORNADO" + tipoRetornado);
            }
        } catch (Exception excecao) {
            excecao.getMessage();
        }
        return tipoRetornado;
    }
}
