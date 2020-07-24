<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/pages/common/head.jsp"%>
<html>
  <head>
    <title>index</title>

    <script type="text/javascript">
        $(function () {
            // 给加入购物车按钮绑定单击事件
            $("button.addToCart").click(function () {
                /**
                 * 在事件响应的function函数 中，有一个this对象，这个this对象，是当前正在响应事件的dom对象
                 * @type {jQuery}
                 */
                var itemId = $(this).attr("itemId");
                location.href = "${basePath}cartServlet?action=addItem&id=" + itemId;

            });
        });
    </script>
  </head>
  <body>

  <div id="header" align="right">
<%--    如果用户还没登录，显示登录和注册菜单--%>
    <c:if test="${empty sessionScope.user}">
      <a href="pages/user/login.jsp">Sign in</a> |
      <a href="pages/user/register.jsp" target="_blank">Sign up</a><br>
    </c:if>
<%--  登录后，显示用户登录信息--%>
    <c:if test="${not empty sessionScope.user}">
      <span>Welcome! </span>&nbsp; ${sessionScope.user.username} <br>
      <a href="pages/order/order.jsp">Order</a>
      <a href="userServlet?action=logout">Logout</a>
    </c:if>

    <a href="pages/cart/cart.jsp">Cart ${sessionScope.cart.totalCount}</a>
<%--    <a href="pages/manager/manager.jsp">Manager login</a>--%>
  </div>

  <div id="price" align="center">
    <form action="client/itemServlet"method="get">
      <input type="hidden" name="action" value="pageByPrice">
      Price: $<input id="min" type="text" name="min" value="${param.min}" style="width: 50px"> -
              $<input id="max" type="text" name="max" value="${param.max}" style="width: 50px">
              <input type="submit" value="Apply">
<%--      Price:--%>
<%--      <select> --%>
<%--        <option id="op1">$0 - $10</option>--%>
<%--        <option id="op2">$10 - $20</option>--%>
<%--        <option id="op3">$20 and above</option>--%>
<%--      </select>--%>
    </form>
  </div>

  <div id="main">
    <table>
      <tr>
        <c:forEach items="${requestScope.page.items}" var="item">
        <td>
          <div class="item_list">
              <div class="img_div">
                <img class="item_img" alt="" src=${item.img_path}
              </div>
              <div class="item_info">
                <div class="item_name">
                  <span class="sp1">Name:</span>
                  <span class="sp2">${item.name}</span>
                </div>
                <div class="item_place">
                  <span class="sp1">Place:</span>
                  <span class="sp2">${item.place}</span>
                </div>
                <div class="item_price">
                  <span class="sp1">Price:</span>
                  <span class="sp2">${item.price}</span>
                </div>
                <div class="item_sales">
                  <span class="sp1">Sales:</span>
                  <span class="sp2">${item.sales}</span>
                </div>
                <div class="item_stock">
                  <span class="sp1">Stock:</span>
                  <span class="sp2">${item.stock}</span>
                </div>
                <div class="item_add">
                  <button ItemId="${item.id}" class="addToCart">Add to cart</button>
                </div>
              </div>
              </div>
            </div>
        </td>
        </c:forEach>

      </tr>
    </table>
  </div>
  <%@ include file="/pages/common/page_nav.jsp"%>
  </body>
</html>
