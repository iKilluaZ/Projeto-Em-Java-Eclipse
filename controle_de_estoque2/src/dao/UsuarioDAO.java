package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.ConexaoMySQL;

public class UsuarioDAO {

    // Método para cadastrar um novo usuário no banco de dados
    public boolean cadastrarUsuario(String username, String senha) {
        String sql = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";

        try (Connection conn = ConexaoMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, senha);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        }
    }

    // Método para autenticar um usuário no banco de dados
    public boolean autenticar(String username, String senha) {
        String sql = "SELECT senha FROM usuarios WHERE nome = ?";

        try (Connection conn = ConexaoMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaCorreta = rs.getString("senha");
                return senhaCorreta.equals(senha);  // Verifica se a senha é correta
            }
        } catch (SQLException e) {
            System.out.println("Erro ao autenticar usuário: " + e.getMessage());
        }

        return false;
    }
}
