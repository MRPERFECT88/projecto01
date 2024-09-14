<%-- 
    Document   : editarReserva
    Created on : 13/09/2024, 17:10:43
    Author     : Gamer-DEV
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout.jsp" %>


<h2 class="mb-4">${reserva.id == 0 ? 'Adicionar Reserva' : 'Editar Reserva'}</h2>

<form action="reserva" method="post">
    <input type="hidden" name="id" value="${reserva.id}">
    
    <div class="form-group">
        <label for="usuario">Usuário</label>
        <select class="form-control" id="usuario" name="usuario" required>
            <c:forEach var="usuario" items="${usuarios}">
                <option value="${usuario.id}" ${usuario.id == reserva.usuario.id ? 'selected' : ''}>${usuario.nome}</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
        <label for="sala">Sala</label>
        <select class="form-control" id="sala" name="sala" required>
            <c:forEach var="sala" items="${salas}">
                <option value="${sala.id}" ${sala.id == reserva.sala.id ? 'selected' : ''}>${sala.nome}</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
        <label for="dataReserva">Data</label>
        <input type="date" class="form-control" id="dataReserva" name="dataReserva" value="${reserva.dataReserva}" required>
    </div>

    <div class="form-group">
        <label for="horaInicio">Hora Início</label>
        <input type="time" class="form-control" id="horaInicio" name="horaInicio" value="${reserva.horaInicio}" required>
    </div>

    <div class="form-group">
        <label for="horaFim">Hora Fim</label>
        <input type="time" class="form-control" id="horaFim" name="horaFim" value="${reserva.horaFim}" required>
    </div>

    <button type="submit" class="btn btn-primary">Salvar</button>
    <a href="reserva?action=list" class="btn btn-secondary">Cancelar</a>
</form>
