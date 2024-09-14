/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;



import dao.SalaDAO;
import Models.Sala;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/sala")
public class SalaServlet extends HttpServlet {
        
    private SalaDAO salaDAO;

    @Override
    public void init() {
        salaDAO = new SalaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action) {
            case "list":
                listarSalas(request, response);
                break;
            case "new":
                mostrarFormularioNovaSala(request, response);
                break;
            case "edit":
                editarSala(request, response);
                break;
            case "delete":
                excluirSala(request, response);
                break;
            default:
                listarSalas(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action) {
            case "create":
                criarSala(request, response);
                break;
            case "update":
                atualizarSala(request, response);
                break;
            default:
                listarSalas(request, response);
                break;
        }
    }

    // Função para listar salas
    private void listarSalas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sala> salas = salaDAO.listarSalas();
        request.setAttribute("salas", salas);
        request.getRequestDispatcher("listarSalas.jsp").forward(request, response);
    }

    // Função para mostrar formulário de nova sala
    private void mostrarFormularioNovaSala(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("novaSala.jsp").forward(request, response);
    }

    // Função para criar uma nova sala
    private void criarSala(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        int capacidade = Integer.parseInt(request.getParameter("capacidade"));
        
        Sala sala = new Sala();
        sala.setNome(nome);
        sala.setCapacidade(capacidade);
        
        salaDAO.inserirSala(sala);
        response.sendRedirect("sala?action=list");
    }

    // Função para mostrar o formulário de edição da sala
    private void editarSala(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Sala sala = salaDAO.buscarSalaPorId(id);
        request.setAttribute("sala", sala);
        request.getRequestDispatcher("editarSala.jsp").forward(request, response);
    }

    // Função para atualizar uma sala existente
    private void atualizarSala(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        int capacidade = Integer.parseInt(request.getParameter("capacidade"));
        
        Sala sala = new Sala();
        sala.setId(id);
        sala.setNome(nome);
        sala.setCapacidade(capacidade);
        
        salaDAO.atualizarSala(sala);
        response.sendRedirect("sala?action=list");
    }

    // Função para excluir uma sala
    private void excluirSala(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        salaDAO.excluirSala(id);
        response.sendRedirect("sala?action=list");
    }
}
