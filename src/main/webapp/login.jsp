<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Вхід</title>
</head>
<body>
    <h1>Вхід</h1>
    <form action="login" method="post">
        <label for="login">Логін:</label>
        <input type="text" id="login" name="login" required>
        <br>
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <button type="submit">Увійти</button>
    </form>
    <p>Ще не маєте акаунту? <a href="register.jsp">Зареєструватися</a></p>

    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>
</body>
</html>