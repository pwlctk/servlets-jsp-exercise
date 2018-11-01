<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pwlctk
  Date: 28.10.18
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie posta</title>
</head>
<body>
<h2>Nowy post:</h2>
<form action="/add" method="post">
    <input type="text" placeholder="Temat" name="subject">
    <br>
    <br>
    <textarea name="content" rows="15" cols="35" placeholder="Treść artykułu"></textarea>
    <br>
    <input type="submit" value="Dodaj">
</form>
</body>
</html>
