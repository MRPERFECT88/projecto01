<%-- 
    Document   : listarSalas
    Created on : 13/09/2024, 17:07:21
    Author     : Gamer-DEV
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Models.Sala" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Salas</title>
    <script>
        // Função JavaScript para confirmar a remoção da sala
        function confirmarRemocao(id) {
            if (confirm('Tem certeza que deseja remover esta sala?')) {
                window.location.href = 'sala?action=delete&id=' + id;
            }
        }
    </script>
</head>
<body>
    <h2>Salas Disponíveis</h2>

    <!-- Botão para adicionar uma nova sala -->
    <form action="sala" method="get">
        <input type="hidden" name="action" value="addForm">
        <button type="submit">Adicionar Sala</button>
    </form>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Capacidade</th>
            <th>Ações</th>
        </tr>

        <%
            List<Sala> salas = (List<Sala>) request.getAttribute("salas");
            
            if (salas != null) {
                for (Sala sala : salas) {
        %>
                    <tr>
                        <td><%= sala.getId() %></td>
                        <td><%= sala.getNome() %></td>
                        <td><%= sala.getCapacidade() %></td>
                        <td>
                            <!-- Botão para editar -->
                            <form action="sala" method="get" style="display:inline;">
                                <input type="hidden" name="action" value="edit">
                                <input type="hidden" name="id" value="<%= sala.getId() %>">
                                <button type="submit">Editar</button>
                            </form>

                            <!-- Link para remover com confirmação -->
                            <a href="javascript:void(0)" onclick="confirmarRemocao(<%= sala.getId() %>)">Remover</a>
                        </td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="4">Nenhuma sala encontrada.</td>
                </tr>
        <%
            }
        %>
    </table>
    <!-- Botão para voltar ao index.jsp -->
    <form action="index.jsp" method="get">
        <button type="submit">Voltar ao Início</button>
    </form>
</body>
</html>
