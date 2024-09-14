<%-- 
    Document   : adicionarUsuarios
    Created on : 14/09/2024, 14:22:19
    Author     : Gamer-DEV
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Adicionar Usuário</title>
</head>
<body>
    <h2>Adicionar Novo Usuário</h2>
    <form action="usuario" method="post">
        <input type="hidden" name="action" value="add">
        Nome: <input type="text" name="nome" required><br>
        Email: <input type="email" name="email" required><br>
        <button type="submit">Adicionar</button>
    </form>
    <br>
    <a href="usuario?action=list">Voltar à Lista de Usuários</a>
</body>
</html>
