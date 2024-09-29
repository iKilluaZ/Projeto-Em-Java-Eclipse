package view;

import dao.UsuarioDAO;
import dao.ProdutoDAO;
import java.util.List;

public class Sistema {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    // Método para cadastrar um novo usuário
    public boolean cadastrarUsuario(String username, String senha) {
        return usuarioDAO.cadastrarUsuario(username, senha);
    }

    // Método para autenticar um usuário
    public boolean autenticar(String username, String senha) {
        return usuarioDAO.autenticar(username, senha);
    }

    // Método para adicionar um produto ao estoque
    public void adicionarProduto(Produto produto) {
        produtoDAO.adicionarProduto(produto);
    }

    // Método para consultar todos os produtos cadastrados
    public String consultarProdutos() {
        List<Produto> produtos = produtoDAO.consultarProdutos();
        StringBuilder sb = new StringBuilder();
        if (produtos.isEmpty()) {
            return "Nenhum produto cadastrado.";
        }
        for (Produto p : produtos) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}
