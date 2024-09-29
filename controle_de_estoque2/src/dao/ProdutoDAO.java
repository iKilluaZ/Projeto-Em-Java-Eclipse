package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.ConexaoMySQL;
import view.Produto;

public class ProdutoDAO {

    // Método para adicionar um produto no banco de dados
    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produtos (identificacao, nome_produto, preco, estoque_atual) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produto.getIdentificacao());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());

            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    // Método para consultar todos os produtos no banco de dados
    public List<Produto> consultarProdutos() {
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = ConexaoMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("identificacao");
                String nome = rs.getString("nome_produto");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("estoque_atual");

                Produto produto = new Produto(id, nome, preco, quantidade);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar produtos: " + e.getMessage());
        }

        return produtos;
    }
}
