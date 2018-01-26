<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 24/12/2017
  Time: 7:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<div>HI!</div>

<form name='loginForm'
      action="<c:url value='/login' />" method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username'></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        <tr>
            <td colspan='2'><input name="submit" type="submit"
                                   value="submit" /></td>
        </tr>
        </tr>
    </table>

</form>
</body>
</html>
