<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/pages/common/head.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Member Registration page</title>

    <script type="text/javascript">
        $(function () {
            $("#code_img").click(function () {
                this.src = "${basePath}kaptcha.jpg";
            });

            $("#sub_btn").click(function () {
                // Verify username: Consist of letters, Numbers, and underscores
                //                     5-12 digits long
                //1. Access to text
                var usernameText = $("#username").val();
                //2. Reg
                var usernamePatt = /^\w{5,12}$/;
                //3. Test
                if (!usernamePatt.test(usernameText)){
                    $("span.errorMsg").text("This user name is not valid!");
                    return false;
                }

                // Verify password: Consist of letters, Numbers, and underscores
                //                     5-12 digits long
                //1. Access to text
                var passwordText = $("#password").val();
                //2. Reg
                var passwordPatt = /^\w{5,12}$/;
                //3. Test
                if (!passwordPatt.test(passwordText)){
                    $("span.errorMsg").text("This password is not valid!");
                    return false;
                }

                // Confirm password: equal to password
                var repwdText = $("#repwd").val();
                if (passwordText!=repwdText){
                    $("span.errorMsg").text("Password not match!");
                    return false;
                }

                // Verify email address: XXXXX@XXX.com
                var emailText = $("#email").val();
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPatt.test(emailText)){
                    $("span.errorMsg").text("This email address is not valid!");
                    return false;
                }
                // Submit
                $("span.errorMsg").text(" ");
            });
        });
    </script>

</head>
<body>
    <div>

    </div>
    <div id="content">
        <div class="regist_form">
            <div class="regist_box">
                <div class="title">
                    <h1>Create account</h1>
                    <span class="errorMsg">
<%--                        <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
                        ${requestScope.msg?"Please enter your name and password":requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="register"/>
                        <label>Your Name:</label>
                        <input class="itxt" type="text" placeholder="Please enter your name"
                               autocomplete="off" tabindex="1" name="username" id="username"
<%--                            <%=request.getAttribute("username")==null?"":request.getAttribute("username")%>>--%>
                            value = "${requestScope.username}">
                        <br>
                        <br>
                        <label>Password:</label>
                        <input class="itxt" type="password" placeholder="Please enter your password"
                               autocomplete="off" tabindex="1" name="password" id="password">
                        <br>
                        <br>
                        <label>Re-enter Password:</label>
                        <input class="itxt" type="password" placeholder="Please enter your password"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd">
                        <br>
                        <br>
                        <label>Email:</label>
                        <input class="itxt" type="text" placeholder="Please enter your email address"
                               autocomplete="off" tabindex="1" name="email" id="email"
                               value="${requestScope.email}">
                        <br>
                        <br>
                        <label>Verify:</label>
                        <input class="itxt" type="text" name="code" id="code">
                        <img id="code_img" src="kaptcha.jpg" style=" width: 110px; height: 30px">
                        <br>
                        <br>
                        <input type="submit" value="Create your account" id="sub_btn">

                    </form>
                </div>
            </div>
        </div>
    </div>

</body>
</html>