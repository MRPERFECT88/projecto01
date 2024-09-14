<%-- 
    Document   : novaSala
    Created on : 14/09/2024, 13:51:47
    Author     : Gamer-DEV
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nova Sala</title>
</head>
<body>
    <h2>Criar Nova Sala</h2>
    <form action="sala?action=create" method="post">
        <label for="nome">Nome:</label>
        <input type="text" name="nome" required><br>

        <label for="capacidade">Capacidade:</label>
        <input type="number" name="capacidade" required><br>

        <button type="submit">Salvar</button>
    </form>
</body>
</html>
