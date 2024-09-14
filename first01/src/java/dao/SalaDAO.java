/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;




import Models.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {
    private Connection connection;

    public SalaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // Método para inserir uma nova sala no banco de dados (Create)
    public void inserirSala(Sala sala) {
        String sql = "INSERT INTO sala (nome, capacidade) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, sala.getNome());
            stmt.setInt(2, sala.getCapacidade());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para listar todas as salas (Read)
    public List<Sala> listarSalas() {
        String sql = "SELECT * FROM sala";
        List<Sala> salas = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Sala sala = new Sala();
                sala.setId(rs.getInt("id"));
                sala.setNome(rs.getString("nome"));
                sala.setCapacidade(rs.getInt("capacidade"));
                salas.add(sala);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salas;
    }

    // Método para buscar uma sala pelo ID (Read)
    public Sala buscarSalaPorId(int id) {
        String sql = "SELECT * FROM sala WHERE id = ?";
        Sala sala = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                sala = new Sala();
                sala.setId(rs.getInt("id"));
                sala.setNome(rs.getString("nome"));
                sala.setCapacidade(rs.getInt("capacidade"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sala;
    }

    // Método para atualizar uma sala (Update)
    public void atualizarSala(Sala sala) {
        String sql = "UPDATE sala SET nome = ?, capacidade = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, sala.getNome());
            stmt.setInt(2, sala.getCapacidade());
            stmt.setInt(3, sala.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para excluir uma sala pelo ID (Delete)
    public void excluirSala(int id) {
        String sql = "DELETE FROM sala WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
