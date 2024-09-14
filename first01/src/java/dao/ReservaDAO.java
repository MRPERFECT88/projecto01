/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;




import Models.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    private Connection connection;

    public ReservaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // Método para inserir uma nova reserva
    public void inserirReserva(Reserva reserva) {
        String sql = "INSERT INTO reserva (usuario_id, sala_id, data_reserva, hora_inicio, hora_fim) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, reserva.getUsuario().getId()); // Assumindo que Usuario tem um método getId()
            stmt.setInt(2, reserva.getSala().getId());    // Assumindo que Sala tem um método getId()
            stmt.setDate(3, reserva.getDataReserva());
            stmt.setTime(4, reserva.getHoraInicio());
            stmt.setTime(5, reserva.getHoraFim());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir reserva: ", e);
        }
    }

    // Método para listar todas as reservas
    public List<Reserva> listarReservas() {
        String sql = "SELECT * FROM reserva";
        List<Reserva> reservas = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setUsuario(new UsuarioDAO().buscarUsuarioPorId(rs.getInt("usuario_id"))); // Acesso ao DAO de Usuario
                reserva.setSala(new SalaDAO().buscarSalaPorId(rs.getInt("sala_id")));          // Acesso ao DAO de Sala
                reserva.setDataReserva(rs.getDate("data_reserva"));
                reserva.setHoraInicio(rs.getTime("hora_inicio"));
                reserva.setHoraFim(rs.getTime("hora_fim"));
                
                reservas.add(reserva);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar reservas: ", e);
        }
        return reservas;
    }

    // Método para buscar uma reserva por ID
    public Reserva buscarReservaPorId(int id) {
        String sql = "SELECT * FROM reserva WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setUsuario(new UsuarioDAO().buscarUsuarioPorId(rs.getInt("usuario_id"))); // Acesso ao DAO de Usuario
                reserva.setSala(new SalaDAO().buscarSalaPorId(rs.getInt("sala_id")));          // Acesso ao DAO de Sala
                reserva.setDataReserva(rs.getDate("data_reserva"));
                reserva.setHoraInicio(rs.getTime("hora_inicio"));
                reserva.setHoraFim(rs.getTime("hora_fim"));
                return reserva;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar reserva: ", e);
        }
        return null;
    }

    // Método para atualizar uma reserva
    public void atualizarReserva(Reserva reserva) {
        String sql = "UPDATE reserva SET usuario_id = ?, sala_id = ?, data_reserva = ?, hora_inicio = ?, hora_fim = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, reserva.getUsuario().getId()); // Assumindo que Usuario tem um método getId()
            stmt.setInt(2, reserva.getSala().getId());    // Assumindo que Sala tem um método getId()
            stmt.setDate(3, reserva.getDataReserva());
            stmt.setTime(4, reserva.getHoraInicio());
            stmt.setTime(5, reserva.getHoraFim());
            stmt.setInt(6, reserva.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar reserva: ", e);
        }
    }
    
    // Método para excluir uma reserva
    public void excluirReserva(int id) {
        String sql = "DELETE FROM reserva WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir reserva: ", e);
        }
    }

    
}
