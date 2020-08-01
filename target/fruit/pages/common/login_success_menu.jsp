
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
