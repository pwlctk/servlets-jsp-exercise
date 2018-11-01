<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Mały twitter</title>
    <style>
        #post {
            margin: 0 auto;
            width: 500px;
            height: 100px;
            border: 1px solid black;
            border-collapse: collapse;
        }

        #posts {
            text-align: center;
        }
    </style>
</head>
<body>
<c:if test="${!requestScope.containsKey('posts')}">
    <jsp:forward page="/posts"/>
</c:if>

<c:choose>
    <c:when test="${ !sessionScope.containsKey('user') }">
        <h2>Logowanie:</h2>
        <form action="/login" method="post">
            <input type="text" placeholder="Login" name="login">
            <input type="password" placeholder="Password" name="password">
            <input type="submit" value="Sign in!">
        </form>
    </c:when>
    <c:otherwise>
        <h1> Witaj ${sessionScope.user.name}</h1>
        <a href="/add.jsp">Dodaj post</a>
        <c:if test="${sessionScope.user.role == 'ROLE_ADMIN'}">
            <br>
            <a href="/users">Zobacz wszystkich użytkowników</a>
        </c:if>
        <br>
        <br>
        <a href="/logout">Wyloguj się</a>
    </c:otherwise>
</c:choose>

<c:if test="${ requestScope.containsKey('message') }">
    <h3>${ requestScope.message.value }</h3>
</c:if>

<h3 id="posts">Posty: </h3>
<c:forEach items="${posts}" var="post">
    <div>
        <table id="post">
            <tr>
                <td>Autor: <b>${post.creator.name}</b></td>
            </tr>
            <tr>
                <td>Temat: <b>${post.subject}</b></td>
            </tr>
            <tr>
                <td>Data utworzenia: <b>${post.creationDate}</b></td>
            </tr>
            <tr>
                <td>Treść: <b>${post.content}</b></td>
            </tr>
            <c:if test="${sessionScope.user == post.creator}">
                <tr align="right">

                    <c:url var="editId" value="/edit/">
                        <c:param name="id" value="${post.id}"/>
                    </c:url>
                    <c:url var="deleteId" value="/delete/">
                        <c:param name="id" value="${post.id}"/>
                    </c:url>
                    <td><a href=${editId}>Edycja</a>
                        <a href=${deleteId}>Usuń</a></td>
                </tr>
            </c:if>
        </table>
        <br><br>
    </div>
</c:forEach>

</body>
</html>