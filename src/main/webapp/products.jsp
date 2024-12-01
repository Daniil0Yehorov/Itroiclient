<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Продукти</title>
</head>
<body>
    <h1>Список продуктов</h1>

    <c:if test="${not empty products}">
        <table>
            <thead>
                <tr>
                    <th>Назва корму</th>
                    <th>Ціна</th>
                    <th>Опис</th>
                    <th>Категорія</th>
                    <th>Кількість на складі</th>
                    <th>Дія</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.description}</td>
                        <td>${product.category}</td>
                        <td>${product.countInStock}</td>
                        <td>
                            <form action="/cart/add" method="POST" style="display:inline;">
                                <input type="hidden" name="productId" value="${product.ID}">
                                <button type="submit">Додати до кошику</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty products}">
        <p>Немає продуктів</p>
    </c:if>
</body>
</html>