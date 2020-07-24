<%--
  Created by IntelliJ IDEA.
  User: pineapple
  Date: 17/7/20
  Time: 6:39 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div align="right">
    <span>Welcome! </span>&nbsp; ${sessionScope.user.username} <br>
    <a href="pages/order/order.jsp">Order</a>
    <a href="userServlet?action=logout">Logout</a>
    <a href="index.jsp">Back</a>
    <div id="main">
        <a href="index.jsp"></a>
    </div>
</div>
