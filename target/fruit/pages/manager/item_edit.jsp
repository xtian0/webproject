<%--
  Created by IntelliJ IDEA.
  User: pineapple
  Date: 17/7/20
  Time: 7:03 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/pages/common/head.jsp"%>
<%@include file="/pages/common/manager_menu.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="main">
        <form action="manager/itemServlet" method="post">
            <input type="hidden" name="action" value="${empty param.id ? "add" : "update"}">
            <input type="hidden" name="id" value="${requestScope.item.id}">
            <input type="hidden" name="pageNo" value="${param.pageNo}">
            <table>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Place</th>
                    <th>Sales</th>
                    <th>Stock</th>
                </tr>
                <tr>
                    <td><input type="text" name="name" value="${requestScope.item.name}"></td>
                    <td><input type="text" name="price" value="${requestScope.item.price}"></td>
                    <td><input type="text" name="place" value="${requestScope.item.place}"></td>
                    <td><input type="text" name="sales" value="${requestScope.item.sales}"></td>
                    <td><input type="text" name="stock" value="${requestScope.item.stock}"></td>
                    <td><input type="submit" name="submit" value="Save"></td>
                </tr>
            </table>
<%--            Price: $<input type="text" name="price">--%>
<%--                    <select name="type">--%>
<%--                        <option selected="selected">per kg</option>--%>
<%--                        <option>each</option>--%>
<%--                    </select><br>--%>

        </form>
    </div>
</body>
</html>
