/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    // Parâmetros de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/firstroom";
    private static final String USUARIO = "root";
    private static final String SENHA = "salvador";

    // Método para retornar uma conexão com o banco de dados
    public static Connection getConnection() {
        try {
            // Carregar o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Estabelecer a conexão com o banco
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: ", e);
        }
    }

    // Método para fechar a conexão (opcional)
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão: ", e);
        }
    }
}
