<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/22/2025
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Calculator</title>
</head>
<body>
  <form method="post" action="${pageContext.request.contextPath}/calculator/result" >
    <input name="num1" type="text" />

    <input name="num2" type="text">

    <button type="submit" name="operation" value="add">Addition (+)</button>
    <button type="submit" name="operation" value="subtract">Subtraction (-)</button>
    <button type="submit" name="operation" value="multiply">Multiplication (×)</button>
    <button type="submit" name="operation" value="divide">Division (÷)</button>
  </form>
    <c:if test="${result != null}">
      <div>Kết quả: ${result}</div>
      <p th:if="${error != null}" style="color: red;" th:text="${error}"></p>
    </c:if>
<div>

</div>
</body>
</html>
