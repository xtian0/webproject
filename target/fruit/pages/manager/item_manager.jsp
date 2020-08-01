<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/pages/common/manager_menu.jsp"%>
<%@include file="/pages/common/head.jsp"%>
<%@ include file="/pages/common/page_nav.jsp"%>
<html>
<head>
    <title>Item Management</title>
    <script type="text/javascript">
        $(function(){
            $("a.deleteClass").click(function () {
                return confirm("Are you sure to delete [" + $(this).parent().parent().find("td:first").text() + "]?");
            });
        });
    </script>


</head>
<body>
    <div id="main">
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Place</th>
                <th>Sales</th>
                <th>Stock</th>
                <th colspan="2">Operation</th>
            </tr>

        <c:forEach items="${requestScope.page.items}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.place}</td>
                <td>${item.sales}</td>
                <td>${item.stock}</td>
                <td><a href="manager/itemServlet?action=getItem&id=${item.id}&pageNo=${requestScope.page.pageNo}">Update</a></td>
                <td><a class="deleteClass" href="manager/itemServlet?action=delete&id=${item.id}&pageNo=${requestScope.page.pageNo}">Delete</a> </td>
            </tr>
        </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="pages/manager/item_edit.jsp?&pageNo=${requestScope.page.pageTotal}">Add</a></td>
            </tr>


        </table>
    </div>



</body>
</html>
