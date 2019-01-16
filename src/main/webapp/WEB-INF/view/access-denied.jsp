<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: radek
  Date: 16.01.2019
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
<h3>
    <p style="color:red;">ACCESS DENIED</p>
</h3>
You Don't Have Access To This Page.
<br>
<form:form action="${pageContext.request.contextPath}/" method="get">
    <%--To avoid token error:--%>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <input type="submit" value="Return home">
</form:form>
</body>
</html>