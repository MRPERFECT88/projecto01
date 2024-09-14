<%-- 
    Document   : layout
    Created on : 13/09/2024, 17:13:00
    Author     : Gamer-DEV
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${pageTitle != null ? pageTitle : "Sistema de Reservas"}</title>
</head>
<body>
    <!-- Cabeçalho simples -->
    <header>
        <h1>Sistema de Reservas de Salas</h1>
        <nav>
            <a href="index.jsp">Início</a> |
            <a href="sala?action=list">Salas</a> |
            <a href="reserva?action=list">Reservas</a> |
            <a href="usuario?action=list">Usuários</a>
        </nav>
        <hr>
    </header>

    <!-- Conteúdo -->
    <div>
        <jsp:include page="${pageContent}" />
    </div>

    <!-- Rodapé simples -->
    <footer>
        <hr>
        <p>&copy; 2024 Sistema de Reservas</p>
    </footer>
</body>
</html>
