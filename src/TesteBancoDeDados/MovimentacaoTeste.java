package TesteBancoDeDados;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import model.Categoria;
import model.DAOCategoria;
import model.DAOMovimentacao;
import model.DAOTipoDeMovimentacao;
import model.Movimentacao;
import model.TipoDeMovimentacao;

/**
 * @author Mirandinha
 */
//public class MovimentacaoTeste {
//
//    public static void main(String[] args) {
////      ================ Validação do método adicionaMovimentacao no BD. ================  
//        TipoDeMovimentacao tipoDeMovimentacao = new TipoDeMovimentacao();
//        tipoDeMovimentacao.setIdTipoMovimentacao(2);
//        DAOTipoDeMovimentacao tipo = new DAOTipoDeMovimentacao();
//        tipo.retornaUmTipo(tipoDeMovimentacao);
//        System.out.println(tipoDeMovimentacao.getIdTipoMovimentacao());
//        System.out.println(tipoDeMovimentacao.getDescricaoBD());
//
//        Categoria categoria = new Categoria();
//        categoria.setIdCategoria(2);
//        DAOCategoria cate = new DAOCategoria();
//        cate.retornaUmaCategoria(categoria);
//        System.out.println(categoria.getIdCategoria());
//        System.out.println(categoria.getDescricaoBD());
//
//        DAOMovimentacao conectaBD = new DAOMovimentacao();
//        Movimentacao movimentacao = new Movimentacao();
//        movimentacao.setIdMovimentacao(125);
//        movimentacao.setValor(21.15);
//        movimentacao.setCategoriaBD(categoria);
//        movimentacao.setData(LocalDate.now());
//        movimentacao.setParaOfuturo('s');
//        movimentacao.setDescricao("deu certo!!!");
//        movimentacao.setTipoBD(tipoDeMovimentacao);
//        
//        if (conectaBD.adicionaMovimentacao(movimentacao)) {
//            System.out.println("Movimentação adicionada com sucesso.");
//        } else{
//            System.out.println("Movimentação não adicionada.");
//        }
//
//////      ================ Validação do método retorna lista de Movimentacao no BD. ================  
////
//////        DAOMovimentacao conectaBanco = new DAOMovimentacao();
//////        List<Movimentacao> listaMovimentacao = conectaBanco.retornaListaDeMovimentacoes();
//////        conectaBanco.retornaListaDeMovimentacoes();
//    }
//}
