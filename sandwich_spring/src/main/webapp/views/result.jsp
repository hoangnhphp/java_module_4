<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/22/2025
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<div>Gia vị đi kèm</div>
<c:forEach items="${spices}" var="spice" varStatus="temp">
  <div>${spice}</div>
</c:forEach>
</body>
</html>
