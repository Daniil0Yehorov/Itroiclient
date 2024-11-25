<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Панель управління</title>
</head>
<body>
    <h1>Панель управління користувача</h1>

    <c:if test="${not empty error}">
        <div style="color: red; font-weight: bold;">
            ${error}
        </div>
    </c:if>

    <h2>Вітаємо, ${user.name}!</h2>

    <p><strong>Логін:</strong> ${user.login}</p>
    <p><strong>Email:</strong> ${user.email}</p>
    <p><strong>Телефон:</strong> ${user.phone}</p>

    <li><a href="/cart/view">Перейти до кошика</a></li>
    <li><a href="/products">Перейти до каталогу продуктів</a></li>

    <h3>Змінити дані:</h3>
    <form action="/updateProfile" method="post">
        <label for="name">Ім'я:</label>
        <input type="text" id="name" name="name" value="${user.name}" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required>
        <br>
        <label for="phone">Телефон:</label>
        <input type="tel" id="phone" name="phone" value="${user.phone}">
        <br>
        <button type="submit">Зберегти зміни</button>
    </form>

    <br>
    <a href="logout">Вийти з акаунта</a>
</body>
</html>