<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Помилка</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
            color: #212529;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        h1 {
            color: #dc3545;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Щось пішло не так</h1>

    <p>
        <c:choose>
            <c:when test="${not empty error}">
                ${error}
            </c:when>
            <c:otherwise>
                Невідома помилка. Зверніться до адміністратора.
            </c:otherwise>
        </c:choose>
    </p>

    <a href="/login.jsp">Повернутися до входу</a>
</body>
</html>