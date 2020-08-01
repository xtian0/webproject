<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/pages/common/head.jsp"%>
<html>
<head>
    <title>Cart</title>
    <script type="text/javascript">
        $(function () {
            // 给 【删除】绑定单击事件
            $("a.deleteItem").click(function () {
                return confirm("Are you sure to delete【" + $(this).parent().parent().find("td:first").text() +"】?")
            });
            // 给清空购物车绑定单击事件
            $("#clearCart").click(function () {
                return confirm("Are you sure to clean the cart?");
            });
            // 给输入框绑定 onchange内容发生改变事件
            $(".updateCount").change(function () {
                // 获取商品名称
                var name = $(this).parent().parent().find("td:first").text();
                var id = $(this).attr('itemId');
                // 获取商品数量
                var count = this.value;
                if ( confirm("Are you sure you want to change the【" + name + "】item quantity to:" + count + " ?") ) {
                    //发起请求。给服务器保存修改
                    location.href = "${basePath}cartServlet?action=updateCount&count="+count+"&id="+id;
                } else {
                    // defaultValue属性是表单项Dom对象的属性。它表示默认的value属性值。
                    this.value = this.defaultValue;
                }
            });
        });
    </script>
</head>
<body>
    <%@ include file="/pages/common/login_success_menu.jsp"%>

    <div id="main">
        <c:if test="${empty sessionScope.cart.items}">
            <span>Your cart is empty! <a href="index.jsp">Go to shopping</a> </span>
        </c:if>
        <c:if test="${not empty sessionScope.cart.items}">
            <div id="cart_content">
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Count</th>
                        <th>Price</th>
                        <th>Total Price</th>
                        <th>Operation</th>
                    </tr>
                    <c:forEach items="${sessionScope.cart.items}" var="item">
                        <tr>
                            <td>${item.value.name}</td>
                            <td><input type="text" class="updateCount" itemId = ${item.value.id}
                                    value="${item.value.count}" style="width: 30px"></td>
                            <td>${item.value.price}</td>
                            <td>${item.value.totalPrice}</td>
                            <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${item.value.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="cart_info">
                <span class="cart_span">${sessionScope.cart.totalCount} items in cart</span><br>
                <span class="cart_span">Total: $${sessionScope.cart.totalPrice}</span><br>
                <span class="cart_span"><a id="cleanCart" href="cartServlet?action=clean">Clean Cart</a></span><br>
                <span class="cart_span"><a href="orderServlet?action=createOrder">Checkout</a></span>
            </div>
        </c:if>


    </div>
</body>
</html>
