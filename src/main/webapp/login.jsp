<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/25
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UserServlet" method="get">
    <input name="username"><br>
    <input name="action" value="login" type="hidden"><br>
    <input name="pwd" type="password"><br>
    <input type="submit">
</form>
<%--    <form action="findAll">--%>
<%--        <input name="userId" type="text"><br>--%>
<%--        <input name="userName" type="text"><br>--%>
<%--        <input name="userPwd" type="text"><br>--%>
<%--        <input type="submit">--%>
<%--    </form>--%>
</body>
</html>
