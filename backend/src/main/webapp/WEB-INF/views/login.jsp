<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="loginAPI" value="/api/v1/login"/>
<c:url var="board" value="/admin/dashboard"/>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Login</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.1.0-7/css/all.css'/>" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value='/assets/css/sb-admin-2.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/assets/css/custom.css '/>" rel="stylesheet">
</head>

<body class="bg-gradient-primary">

<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

        <div class=" col-xl-10 col-lg-12 col-md-9 d-flex justify-content-center ">

            <div class="card custom-card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row justify-content-center">
                        <div>
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900">Welcome Back!</h1>
                                    <h1 class="h4 text-gray-900 mb-4">Admin</h1>
                                </div>
                                <form id="formSubmit" class="user">
                                    <div class="form-group">
                                        <input name="username" type="text" class="form-control form-control-user"
                                               id="exampleInputEmail" aria-describedby="emailHelp"
                                               placeholder="Enter Email Address...">
                                    </div>
                                    <div class="form-group">
                                        <input name ="password" type="password" class="form-control form-control-user"
                                               id="exampleInputPassword" placeholder="Password">
                                    </div>
                                    <button id="btnAdmminLogin" class="btn btn-primary btn-user btn-block">
                                        Login
                                    </button>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>


<!-- Bootstrap core JavaScript-->
<script src="<c:url value='https://code.jquery.com/jquery-3.6.0.min.js'/>"></script>

<script src="<c:url value='/assets/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value='/assets/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value='/template/admin/js/sb-admin-2.min.js'/>"></script>

<script type="text/javascript" language="javascript">


    $('#btnAdmminLogin').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        login(data);
    });


    function login(data) {
        $.ajax({
            url: '${loginAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                localStorage.setItem('access_token', result.access_token); // write
                console.log(localStorage.getItem('access_token')); // read
                loadDashBoard();
            },
            error: function (error) {
                console.log("errpor");
            }
        });
    }

    function loadDashBoard() {
        $.ajax({
            url: '${board}',
            type: 'GET',
            headers: { 'Authorization': 'Bearer '+ localStorage.getItem('access_token')}
        });
    }


</script>

</body>

</html>