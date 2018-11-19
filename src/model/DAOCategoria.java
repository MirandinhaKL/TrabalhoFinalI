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
public class DAOCategoria {

    private Connection conexao;

    /**
     * Classe construtora que cria a conexão com o banco de dados.
     */
    public DAOCategoria() {
        this.conexao = new ConexaoBancoDeDados().getConexao();
    }

    public boolean adicionaCategoria(Categoria novaCategoria) {
        String sql = "insert into categoria(descricao) values(?);";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setString(1, novaCategoria.getDescricaoBD());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (SQLException excecao) {
            excecao.getMessage();
            return false;
        }
    }

    public boolean atualizaCategoria(Categoria categoria) {
        String sql = "update categoria set descricao = ? where id = ?;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setString(1, categoria.getDescricaoBD());
            declaracao.setInt(2, categoria.getIdCategoria());
            declaracao.execute();
            declaracao.close();;
            conexao.close();
            return true;
        } catch (Exception excecao) {
            excecao.getMessage();
            return false;
        }
    }

    public boolean removeCategoria(Categoria categoria) {
        String sql = "delete from categoria where id = ?;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, categoria.getIdCategoria());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (SQLException excecao) {
            excecao.getMessage();
            return false;
        }
    }

    public boolean removeTodasAsCategorias() {
        String sql = "delete from categoria;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (SQLException excecao) {
            excecao.getMessage();
            return false;
        }
    }

    public List<Categoria> retornaListaDeCategorias() {
        List<Categoria> listaDeCategorias = new ArrayList<>();
        String sql = "select * from categoria;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet consultaBD = declaracao.executeQuery();
            while (consultaBD.next()) {
                Categoria itemCategoria = new Categoria();
                itemCategoria.setIdCategoria(consultaBD.getInt("id"));
                itemCategoria.setDescricaoBD(consultaBD.getString("descricao"));
                listaDeCategorias.add(itemCategoria);
            }
            declaracao.close();
            consultaBD.close();;
            conexao.close();
        } catch (Exception excecao) {
            excecao.printStackTrace();;
            System.out.println("Erro! Lista não retornada!");
            return null;
        }
        return listaDeCategorias;
    }
    
    public Categoria retornaUmaCategoria(Categoria categoria){
        String sql = "select * from categoria where id=?;";
        Categoria retornaCategoria = new Categoria();
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, categoria.getIdCategoria());
            ResultSet consultaBD = declaracao.executeQuery();
            System.out.println("categoira retoranda");
            if (consultaBD.next()) {
                categoria.setDescricaoBD(consultaBD.getString("descricao"));
                retornaCategoria = categoria;
            }
        } catch (Exception excecao) {
            excecao.getMessage();
        }
        return retornaCategoria;
    }
}
