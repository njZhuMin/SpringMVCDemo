<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
        + request.getServerPort() + "/";
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>Login</title>
    </head>

    <body>
        <form name="form" action="viewAll.form" method="post">
            Username: <input type="text" name="name"><br/>
            Password: <input type="password" name="password"><br/>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
