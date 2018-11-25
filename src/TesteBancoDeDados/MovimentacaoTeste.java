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
 * @author Mirandinha //
 */
//public class MovimentacaoTeste {

//    public static void main(String[] args) {
//      ================ Validação do método adicionaMovimentacao no BD. ================  
//        TipoDeMovimentacao tipoDeMovimentacao = new TipoDeMovimentacao();
//        tipoDeMovimentacao.setIdTipoMovimentacao(5);
//        tipoDeMovimentacao.setDescricao("Tentativa 24");
//        DAOTipoDeMovimentacao tipo = new DAOTipoDeMovimentacao();
//        //tipo.retornaUmTipo(tipoDeMovimentacao);
//        tipo.adicionaTipoDeMovimentacao(tipoDeMovimentacao);
//        System.out.println(tipoDeMovimentacao.getIdTipoMovimentacao());
//        System.out.println(tipoDeMovimentacao.getDescricao());
//
//        Categoria categoria = new Categoria();
//        categoria.setIdCategoria(2);
//        DAOCategoria cate = new DAOCategoria();
//        cate.retornaUmaCategoria(categoria);
//        System.out.println(categoria.getIdCategoria());
//        System.out.println(categoria.getDescricao());
//
//        DAOMovimentacao conectaBD = new DAOMovimentacao();
//        Movimentacao movimentacao = new Movimentacao();
//        movimentacao.setIdMovimentacao(125);
//        movimentacao.setValor(3);
//        movimentacao.setCategoria(categoria);
//        movimentacao.setData(LocalDate.now());
//        movimentacao.setParaOfuturo("s");
//        movimentacao.setDescricao("após Property");
//        movimentacao.setTipo(tipoDeMovimentacao);
//        
//        if (conectaBD.adicionaMovimentacao(movimentacao)) {
//            System.out.println("Movimentação adicionada com sucesso.");
//        } else{
//            System.out.println("Movimentação não adicionada.");
//        }
//
//      ================ Validação do método retorna lista de Movimentacao no BD. ================  

//        DAOMovimentacao conectaBanco = new DAOMovimentacao();
//        List<Movimentacao> listaMovimentacao = conectaBanco.retornaListaDeMovimentacoes();
//        if (listaMovimentacao != null) {
//            System.out.println("Listagem das movimentações:");
//            for (int i = 0; i < listaMovimentacao.size(); i++) {
//                listaMovimentacao.get(i).exibeTodasMovimentacoes();
//            }
//        } else {
//            System.out.println("Lista nula");
//        }
//    }

//      ================ Validação do método retorna remove Movimentacao no BD. ================  
//        DAOMovimentacao conectaBD = new DAOMovimentacao();
//        Movimentacao movimentacao = new Movimentacao();
//        movimentacao.setIdMovimentacao(16);
//        if (conectaBD.removeMovimentacao(movimentacao)) {
//            System.out.println("Movimentação removida com sucesso.");
//        } else{
//            System.out.println("Movimentação NÃO removida!");
//        }
//}
//}
