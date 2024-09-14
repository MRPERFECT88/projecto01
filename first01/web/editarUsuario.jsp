<%-- 
    Document   : editUsuario
    Created on : 14/09/2024, 14:24:34
    Author     : Gamer-DEV
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Usuário</title>
</head>
<body>
    <h2>Editar Usuário</h2>
    <form action="usuario" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= request.getAttribute("usuario").getId() %>">
        Nome: <input type="text" name="nome" value="<%= request.getAttribute("usuario").getNome() %>" required><br>
        Email: <input type="email" name="email" value="<%= request.getAttribute("usuario").getEmail() %>" required><br>
        <button type="submit">Atualizar</button>
    </form>
    <br>
    <a href="usuario?action=list">Voltar à Lista de Usuários</a>
</body>
</html>
