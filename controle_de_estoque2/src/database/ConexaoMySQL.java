package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/controle_estoque"; // Substitua pelo nome do seu banco de dados
    private static final String USUARIO = "root";  // Substitua pelo seu usuário MySQL
    private static final String SENHA = "Velocidade123*";  // Substitua pela sua senha MySQL

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: ", e);
        }
    }
}
