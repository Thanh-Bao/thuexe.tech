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
<button id="_submit">LOGIN</button>
</body>
<script>
    $(document).ready(()=> {
        $("#_submit").click(() => {
            let username = $("#_username").val();
            let password = $("#_password").val();

            $.ajax({
                type: "POST",
                url: 'login',
                dataType: "application/json",
                data: JSON.stringify({username: username, password: password}),
                success: () => {
                    alert("ahihi123")
                },
            });

            location.replace("/ADMIN_MNG/test");

        })
    });
</script>
</html>
