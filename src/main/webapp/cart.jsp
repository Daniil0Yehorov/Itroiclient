<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Ваш кошик</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
            color: #212529;
        }
        h1 {
            text-align: center;
            color: #28a745;
        }
        h2 {
            text-align: center;
            color: #007bff;
        }
        .cart-table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        .cart-table th, .cart-table td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        .cart-table th {
            background-color: #f1f1f1;
        }
        .cart-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .cart-table tr:hover {
            background-color: #f1f1f1;
        }
        .error-message {
            color: #dc3545;
            text-align: center;
        }
        .checkout-btn {
            display: block;
            width: 200px;
            margin: 20px auto;
            padding: 10px;
            background-color: #28a745;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
        }
        .checkout-btn:hover {
            background-color: #218838;
        }
        .empty-cart-message {
            text-align: center;
            font-size: 18px;
        }
    </style>
</head>
<body>

    <h1>Ваш кошик</h1>
    <h2>${status}</h1>
    <h3> Повна ціна${totalAmount}</h1>

    <c:if test="${not empty cartItems}">
        <table class="cart-table">
            <thead>
                <tr>
                    <th>Товар</th>
                    <th>Ціна</th>
                    <th>Опис</th>
                    <th>Категорія</th>
                    <th>Дія</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cartItems}">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>${item.description}</td>
                        <td>${item.category}</td>
                        <td>
                            <form action="/cart/remove" method="post">
                                <input type="hidden" name="productId" value="${item.ID}">
                                <button type="submit">Видалити</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty cartItems}">
        <p class="empty-cart-message">Ваш кошик порожній.</p>
    </c:if>

   <form action="/checkout" method="post">
       <button type="submit" class="checkout-btn">Оформити замовлення</button>
   </form>

    <c:if test="${not empty error}">
        <p class="error-message">${error}</p>
    </c:if>
<a href="/products">Перейти до каталогу продуктів</a>
</body>
</html>