<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Оновити продукти</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .update-form {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
        }
        .update-form input {
            padding: 5px;
            width: 100%;
        }
        .update-form button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
        .update-form button:hover {
            background-color: #218838;
        }
        .delete-form button {
            background-color: #dc3545;
        }
        .delete-form button:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
<p>
    <c:choose>
        <c:when test="${not empty products}">
            Завантажено продуктів: ${fn:length(products)}
        </c:when>
        <c:otherwise>
            Продукти не завантажено.
        </c:otherwise>
    </c:choose>
</p>
<h1>Оновити продукти</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Назва</th>
        <th>Опис</th>
        <th>Ціна</th>
        <th>Категорія</th>
        <th>Кількість на складі</th>
        <th>Дії</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.ID}</td>
            <form action="/update-product" method="post" class="update-form">
                <td><input type="hidden" name="id" value="${product.ID}"></td>
                <td><input type="text" name="name" value="${product.name}" required></td>
                <td><input type="text" name="description" value="${product.description}" required></td>
                <td><input type="number" name="price" value="${product.price}" step="0.01" required></td>
                <td><input type="text" name="category" value="${product.category}" required></td>
                <td><input type="number" name="countInStock" value="${product.countInStock}" step="1" required></td>
                <td>
                    <input type="hidden" name="action" value="update">
                    <button type="submit">Зберегти</button>
                </td>
            </form>
            <td>
                <form action="/update-product" method="post" class="delete-form">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${product.ID}">
                    <button type="submit">Видалити</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/admin/dashboard.jsp">Назад</a>
</body>
</html>