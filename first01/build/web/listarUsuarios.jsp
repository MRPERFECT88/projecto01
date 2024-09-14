<%-- 
    Document   : listarUsuarios
    Created on : 14/09/2024, 13:47:55
    Author     : Gamer-DEV
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Usuários</title>
</head>
<body>
    <h2>Lista de Usuários</h2>

    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.email}</td>
                    <td>
                        <a href="usuario?action=edit&id=${usuario.id}">Editar</a>
                        <a href="usuario?action=delete&id=${usuario.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="usuario?action=new">Adicionar Novo Usuário</a>
</body>
</html>
