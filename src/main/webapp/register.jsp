<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Реєстрація</title>
</head>
<body>
    <h1>Реєстрація</h1>
    <form action="register" method="post">
        <label for="name">Ім'я:</label>
        <input type="text" id="name" name="name" required>
        <br>
        <label for="login">Логін:</label>
        <input type="text" id="login" name="login" required>
        <br>
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br>
        <label for="phone">Телефон:</label>
        <input type="tel" id="phone" name="phone">
        <br>
        <button type="submit">Зареєструватися</button>
    </form>
    <p>Вже маєте акаунт? <a href="login.jsp">Увійти</a></p>

    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>
</body>
</html>