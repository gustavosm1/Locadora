package testes;

import entidades.Categoria;
import persistencia.CategoriaDAO;
/**
 *
 * @author gustavo dos santos machado
 */
public class TesteCategoria {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setNome("Ação");
        categoria.setTipo('F'); // F - Filme J - Jogo
        
        //CategoriaDAO.inserir(categoria);
        // categoria.setId(1);
        // System.out.println(CategoriaDAO.alterar(categoria));
         System.out.println(CategoriaDAO.excluir(1));
        //System.out.println(CategoriaDAO.listar());
    }
}