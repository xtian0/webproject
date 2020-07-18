<%--
  Created by IntelliJ IDEA.
  User: pineapple
  Date: 17/7/20
  Time: 6:39 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            +"://"
            +request.getServerName()
            +":"
            +request.getServerPort()
            +request.getContextPath()
            +"/";
%>
<base href="<%=basePath%>">
<div align="right">
    <span>Welcome! </span>
    <a href="pages/order/order.jsp">Order</a>
    <a href="index.jsp">Logout</a>
    <a href="index.jsp">Back</a>
</div>
