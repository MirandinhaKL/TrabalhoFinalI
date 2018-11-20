package TesteBancoDeDados;

import java.time.Instant;
import java.time.LocalDate;
import model.Categoria;
import model.DAOCategoria;
import model.DAOMovimentacao;
import model.DAOTipoDeMovimentacao;
import model.Movimentacao;
import model.TipoDeMovimentacao;

/**
 * @author Mirandinha
 */
public class MovimentacaoTeste {

    public static void main(String[] args) {
//         ================ Validação do método adicionaMovimentacao no BD. ================  
        DAOTipoDeMovimentacao conectaTipoMovimentacao = new DAOTipoDeMovimentacao();
        TipoDeMovimentacao tipoDeMovimentacao = new TipoDeMovimentacao("Teste tipo");
        conectaTipoMovimentacao.adicionaTipoDeMovimentacao(tipoDeMovimentacao);
        conectaTipoMovimentacao.retornaUmTipo(tipoDeMovimentacao);

        DAOCategoria conectaCategoria = new DAOCategoria();
        Categoria categoria = new Categoria("teste categoria");
        conectaCategoria.adicionaCategoria(categoria);
        System.out.println(categoria.getIdCategoria());

        DAOMovimentacao conectaBD = new DAOMovimentacao();
        Movimentacao movimentacao = new Movimentacao(LocalDate.now(), 15023.00, "salário", 'S', tipoDeMovimentacao, categoria);

//        if (conectaBD.adicionaMovimentacao(movimentacao)) {
        conectaBD.adicionaMovimentacao(movimentacao);
//            System.out.println("Movimentação adicionada com sucesso!");
//        } else {
//            System.out.println("Movimentação NÃO adicionada!");
//        }
//        conectaBD.retornaListaDeMovimentacoes();
    }
}
