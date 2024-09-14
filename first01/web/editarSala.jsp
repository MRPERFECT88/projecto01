<%-- 
    Document   : editarSala
    Created on : 14/09/2024, 13:52:17
    Author     : Gamer-DEV
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Sala</title>
</head>
<body>
    <h2>Editar Sala</h2>
    <form action="sala?action=update" method="post">
        <input type="hidden" name="id" value="${sala.id}">
        <label for="nome">Nome:</label>
        <input type="text" name="nome" value="${sala.nome}" required><br>

        <label for="capacidade">Capacidade:</label>
        <input type="number" name="capacidade" value="${sala.capacidade}" required><br>

        <button type="submit">Atualizar</button>
    </form>
</body>
</html>
