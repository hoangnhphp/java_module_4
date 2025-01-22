<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/22/2025
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/sandwich/save">
      <input id="spice_1" type="checkbox" name="spices" value="Lettuce" />
      <label for="spice_1">Lettuce</label>
      <input id="spice_2" type="checkbox" name="spices" value="Tomato" />
      <label for="spice_2">Tomato</label>
      <input id="spice_3" type="checkbox" name="spices" value="Mustard" />
      <label for="spice_3">Mustard</label>
      <input id="spice_4" type="checkbox" name="spices" value="Sprouts" />
      <label for="spice_4">Sprouts</label>

        <input type="submit" value="xác nhận">
    </form>
</body>
</html>
