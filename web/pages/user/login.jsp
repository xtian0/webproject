<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/pages/common/head.jsp"%>

<head>
    <meta charset="UTF-8">
    <title>Login</title>
<%--    <style type="text/css" rel="stylesheet">--%>
<%--        label{--%>
<%--            color: red;--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>
    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="title">
                    <h1>Sign in</h1>
                    <a href="pages/user/register.jsp">Sign up</a>
                    <span class="errorMsg">
<%--                        <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="login"/>
                        <label>Your Name or Email address:</label>
                        <input class="itxt" type="text" placeholder="Please enter your name"
                               autocomplete="off" tabindex="1" name="username" id="loginUsername"
                               value="${requestScope.username}">
                        <br>
                        <br>
                        <label>Password:</label>
                        <input class="itxt" type="password" placeholder="Please enter your password"
                               autocomplete="off" tabindex="1" name="password" id="loginPassword">
                        <br>
                        <br>
                        <input type="submit" value="login" id="login_btn">
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>