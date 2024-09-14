<%-- 
    Document   : adicionarReserva
    Created on : 13/09/2024, 17:09:53
    Author     : Gamer-DEV
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Reserva</title>
</head>
<body>
    <h1>Adicionar Nova Reserva</h1>
    <form action="reserva" method="post">
        <input type="hidden" name="action" value="save">
        <label for="usuario_id">Usuário:</label>
        <select id="usuario_id" name="usuario_id">
            <c:forEach var="usuario" items="${usuarios}">
                <option value="${usuario.id}">${usuario.nome}</option>
            </c:forEach>
        </select><br>
        <label for="sala_id">Sala:</label>
        <select id="sala_id" name="sala_id">
            <c:forEach var="sala" items="${salas}">
                <option value="${sala.id}">${sala.nome}</option>
            </c:forEach>
        </select><br>
        <label for="data_reserva">Data:</label>
        <input type="date" id="data_reserva" name="data_reserva"><br>
        <label for="hora_inicio">Hora Início:</label>
        <input type="time" id="hora_inicio" name="hora_inicio"><br>
        <label for="hora_fim">Hora Fim:</label>
        <input type="time" id="hora_fim" name="hora_fim"><br>
        <button type="submit">Salvar</button>
    </form>
    <a href="reserva?action=list">Cancelar</a>
</body>
</html>
