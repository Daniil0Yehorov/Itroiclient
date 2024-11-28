<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Додати продукт</title>
</head>
<body>
    <h1>Додати продукт</h1>
    <form action="/add-product" method="post">
        <label>Назва:</label><br>
        <input type="text" name="name" required><br><br>
        <label>Опис:</label><br>
        <textarea name="description" required></textarea><br><br>
        <label>Ціна:</label><br>
        <input type="number" name="price" step="0.01" required><br><br>
        <label>Категорія:</label><br>
        <input type="text" name="category" required><br><br>
        <label>Кількість товару на складі:</label><br>
        <input type="number" name="countInStock" step="1" required><br><br>
        <button type="submit">Додати</button>
    </form>
    <a href="/admin/dashboard.jsp">Назад</a>
</body>
</html>