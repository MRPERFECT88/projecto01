<%-- 
    Document   : listarReservas
    Created on : 13/09/2024, 21:58:02
    Author     : Gamer-DEV
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Reservas</title>
</head>
<body>
    <h2>Reservas de Salas</h2>
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>ID</th>
                <th>Usuário</th>
                <th>Sala</th>
                <th>Data</th>
                <th>Hora Início</th>
                <th>Hora Fim</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="reserva" items="${reservas}">
                <tr>
                    <td>${reserva.id}</td>
                    <td>${reserva.usuario.nome}</td>
                    <td>${reserva.sala.nome}</td>
                    <td>${reserva.dataReserva}</td>
                    <td>${reserva.horaInicio}</td>
                    <td>${reserva.horaFim}</td>
                    <td>
                        <a href="reserva?action=edit&id=${reserva.id}">Editar</a>
                        <a href="reserva?action=delete&id=${reserva.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
