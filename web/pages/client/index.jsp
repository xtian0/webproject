<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/pages/common/head.jsp"%>
<%@ include file="/pages/common/page_nav.jsp"%>
<html>
  <head>
    <title>index</title>

  </head>
  <body>
  <h1 align="center">Welcome!</h1><br>

  <div id="header">
    <a href="pages/user/register.jsp" target="_blank">Sign up</a><br>
    <a href="pages/user/login.jsp" target="_blank">Sign in</a><br>
    <a href="pages/manager/manager.jsp" target="_blank">Manager login</a><br>
  </div>

  <div id="price">
    <form action="client/itemServlet"method="get">
      <input type="hidden" name="action" value="pageByPrice">
      Price: $<input id="min" type="text" name="min" value="${param.min}"> -
              $<input id="max" type="text" name="max" value="${param.max}">
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
    <c:forEach items="${requestScope.page.items}" var="item">
      <div class="item_list"  style="display: inline-block">
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
              <button>Add to cart</button>
            </div>
          </div>
      </div>
    </c:forEach>
  </div>

  </body>
</html>
