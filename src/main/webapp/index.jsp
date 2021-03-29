<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--    欢迎, ${sessionScope.user.userName}--- <%=request.getParameter("username")%>--%>
        ${requestScope.list}
    <c:forEach items="${requestScope.list}" var="user">
        ${user.userName} -- ${user.userPwd}
    </c:forEach>

<%--    ${list[0].uerId}<br>--%>
<%--    ${list[1].userName}<br>--%>
<%--    ${list[2].userPwd}<br>--%>
</body>
</html>