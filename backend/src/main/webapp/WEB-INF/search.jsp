<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dash Board</title>
    <%@ include file="/common/linkTop.jsp" %>
    <style>
        .lock {
            color: red;
        }

        .unlock {
            color: green;
        }

    </style>
</head>
<body>
<!-- Page Wrapper -->
<div id="wrapper">

    <%@ include file="/common/sidebar.jsp" %>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
            <%@ include file="/common/navbar.jsp" %>
            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Posts</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Title</th>
                                    <th scope="col">Owner</th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="post" items="${posts}" varStatus="loop">
                                    <tr>
                                        <th scope="row">${post.id}</th>
                                        <td>${post.title}</td>
                                        <td>${post.user.username}</td>
                                        <td>
                                            <i onclick="remove(${post.id})" style="color: red; cursor: pointer;"
                                               class="fa-solid fa-trash-can"></i>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
            <!-- End of Main Content -->

            <%@ include file="/common/footer.jsp" %>

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <%@ include file="/common/linkBottom.jsp" %>
</body>
<script>
    function remove(id) {
        if (window.confirm("Xóa bài đăng  "+id+"?")) {
            $.ajax({
                type: "DELETE",
                url: '/posts/'+id,
                success: () => {
                    location.href = "/ADMIN_MNG/posts"
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
    }
</script>
</html>
