/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Reserva;
import dao.ReservaDAO;
import dao.SalaDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reserva")
public class ReservaServlet extends HttpServlet {

    private ReservaDAO reservaDAO;
    private UsuarioDAO usuarioDAO;
    private SalaDAO salaDAO;

    @Override
    public void init() {
        reservaDAO = new ReservaDAO();
        usuarioDAO = new UsuarioDAO();
        salaDAO = new SalaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            listarReservas(request, response);
        } else if ("edit".equals(action)) {
            editarReserva(request, response);
        } else if ("add".equals(action)) {
            prepararAdicionarReserva(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("save".equals(action)) {
            salvarReserva(request, response);
        }
    }

    private void listarReservas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reserva> reservas = reservaDAO.listarReservas();
        request.setAttribute("reservas", reservas);
        request.getRequestDispatcher("listarReservas.jsp").forward(request, response);
    }

    private void editarReserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Reserva reserva = reservaDAO.buscarReservaPorId(id);
        request.setAttribute("reserva", reserva);
        request.setAttribute("usuarios", usuarioDAO.listarUsuarios());
        request.setAttribute("salas", salaDAO.listarSalas());
        request.getRequestDispatcher("editarReserva.jsp").forward(request, response);
    }

    private void prepararAdicionarReserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("usuarios", usuarioDAO.listarUsuarios());
        request.setAttribute("salas", salaDAO.listarSalas());
        request.getRequestDispatcher("adicionarReserva.jsp").forward(request, response);
    }

    private void salvarReserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Reserva reserva = new Reserva();
        reserva.setId(Integer.parseInt(request.getParameter("id")));
        reserva.setUsuario(usuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("usuario_id"))));
        reserva.setSala(salaDAO.buscarSalaPorId(Integer.parseInt(request.getParameter("sala_id"))));
        reserva.setDataReserva(Date.valueOf(request.getParameter("data_reserva")));
        reserva.setHoraInicio(Time.valueOf(request.getParameter("hora_inicio")));
        reserva.setHoraFim(Time.valueOf(request.getParameter("hora_fim")));

        if (reserva.getId() == 0) {
            reservaDAO.inserirReserva(reserva);
        } else {
            reservaDAO.atualizarReserva(reserva);
        }
        response.sendRedirect("reserva?action=list");
    }
}
