<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home Page</title>
</head>

<body>
<h3>
    Welcome to the home page!
</h3>
<p>
    User: <security:authentication property="principal.username" />
</p>
<p>
    Role: <security:authentication property="principal.authorities" />
</p>
<p>
    <a href="${pageContext.request.contextPath}/admins">Admins only page</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/managers">Managers only page</a>
</p>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <%--To avoid token error:--%>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <input type="submit" value="logout">
</form:form>
</body>
</html>