<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Панель адміністратора</title>
</head>
<body>
     <h2>Вітаємо, ${user.name}!</h2>
     <ul>
            <li><a href="/add-product">Додати продукт</a></li>
            <li><a href="/update-product">Оновити або видалити продукт</a></li>
        </ul>
        <a href="/logout.jsp">Вийти</a>
</body>
</html>