<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@ include file="/common/linkTop.jsp" %>
    <style>
        .login-wrap {
            margin-top: 5rem;
            position: relative;
            background: #fff;
            border-radius: 10px;
            -webkit-box-shadow: 0 10px 34px -15px rgb(0 0 0 / 24%);
            -moz-box-shadow: 0 10px 34px -15px rgba(0, 0, 0, .24);
            box-shadow: 0 10px 34px -15px rgb(0 0 0 / 24%);
        }

        .login-wrap .icon {
            width: 80px;
            height: 80px;
            background: #1089ff;
            border-radius: 50%;
            font-size: 30px;
            margin: 0 auto;
            margin-bottom: 10px;
            color: #fff;
        }
    </style>
</head>
<body>
<%--<input type="text" id="_username">--%>
<%--<input type="text" id="_password">--%>
<%--<button id="_submit" onclick="submit();">LOGIN</button>--%>

<!-- Page Wrapper -->
<div>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-7 col-lg-5">
                <div class="login-wrap p-4 p-md-5">
                    <div class="icon d-flex align-items-center justify-content-center">
                        <span class="fa fa-user"></span>
                    </div>
                    <h3 class="text-center mb-4">ADMIN</h3>
<%--                    <form action="#" class="login-form">--%>
                        <div class="form-group">
                            <input type="text" id="_username" class="form-control rounded-left" placeholder="Username"
                                   required="">
                        </div>
                        <div class="form-group d-flex">
                            <input type="password" id="_password" class="form-control rounded-left"
                                   placeholder="Password"
                                   required="">
                        </div>
                        <div class="form-group">
                            <button id="_submit" onclick="submit();"
                                    class="form-control btn btn-primary rounded submit px-3">Login
                            </button>
                        </div>
<%--                    </form>--%>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- End of Page Wrapper -->

</body>
<script>

    const submit = () => {
        let username = $("#_username").val();
        let password = $("#_password").val();

        if (username == '' || password == '') {
            alert("Không được bỏ trống");
            return;
        }

        $.ajax({
            type: "POST",
            url: 'login',
            data: JSON.stringify({username: username, password: password}),
            success: () => {
                location.href = "/ADMIN_MNG/dashboard"
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
