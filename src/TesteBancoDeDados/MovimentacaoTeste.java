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
//      ================ Validação do método adicionaMovimentacao no BD. ================  
        TipoDeMovimentacao tipoDeMovimentacao = new TipoDeMovimentacao();
        tipoDeMovimentacao.setIdTipoMovimentacao(1);
        System.out.println(tipoDeMovimentacao.getIdTipoMovimentacao());

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(1);
        System.out.println(categoria.getIdCategoria());

        DAOMovimentacao conectaBD = new DAOMovimentacao();
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setIdMovimentacao(160);
        movimentacao.setValor(159);
        movimentacao.setCategoriaBD(categoria);
        movimentacao.setData(LocalDate.now());
        movimentacao.setParaOfuturo('s');
        movimentacao.setDescricao("lalalalal");
        movimentacao.setTipoBD(tipoDeMovimentacao);

//      ================ Validação do método retorna lista de Movimentacao no BD. ================  

        conectaBD.retornaListaDeMovimentacoes();
    }
}
