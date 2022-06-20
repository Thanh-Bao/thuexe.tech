<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/19/2022
  Time: 11:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<input type="text" id="_username">
<input type="text" id="_password">
<button id="_submit" onclick="submit();">LOGIN</button>
</body>
<script>
       /* $("#_submit").click(() => {

            location.replace("/ADMIN_MNG/test");
        })*/

       const submit = () => {
           let username = $("#_username").val();
           let password = $("#_password").val();

           if(username =='' || password==''){
               alert("Không được bỏ trống");
               return;
           }

           $.ajax({
               type: "POST",
               url: 'login',
               data: JSON.stringify({username: username, password: password}),
               success:  () => {
                   location.href = "/ADMIN_MNG/test"
               },
               statusCode: {
                   401: () => {
                       alert("Sai tài khoản hoặc mật khẩu. Mã lỗi 401");
                   },
                   500: () => {
                       alert("Lỗi server. Mã lỗi 500");
                   }
               }
           });
       }

</script>
</html>
