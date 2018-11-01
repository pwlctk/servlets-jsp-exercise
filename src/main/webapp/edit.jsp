<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%--
  Created by IntelliJ IDEA.
  User: pwlctk
  Date: 28.10.18
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edycja posta</title>
</head>
<body>
<h2>Edycja:</h2>
<form action="/edit" method="post">
    <input type="text" value='${sessionScope.get('subject')}' name="subject">
    <br>
    <br>
    <textarea name="content" rows="15" cols="35">${sessionScope.get('content')}</textarea>
    <br>
    <input type="submit" value="Zmień">
</form>
</body>
</html>
