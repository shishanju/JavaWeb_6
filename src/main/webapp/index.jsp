<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    欢迎, <%=request.getParameter("username")%>


    ${list[0].uerId}<br>
    ${list[1].userName}<br>
    ${list[2].userPwd}<br>
</body>
</html>