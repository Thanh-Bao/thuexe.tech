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
                    <div class="card-header d-flex py-3">
                        <h6 style="flex: 1" class="m-0 font-weight-bold text-primary">Posts</h6>
                        <!-- Topbar Search -->
                        <form action='<c:url value ="/ADMIN_MNG/posts/search"/>' method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="input-group">
                                <input name="value" type="text" class="form-control bg-light border-0 small"
                                       placeholder="Search for...">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="submit">
                                        <i class="fas fa-search fa-sm"></i>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="card-body">
                        <form action='<c:url value ="/ADMIN_MNG/posts/asc"/>' id="formSubmit" method="get">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col" style="display: flex; gap: 0 20px">
                                            Title
                                            <i onclick="up()" style="color: blue; cursor: pointer;"
                                               class="fa-solid fa-arrow-up"></i>
                                            <i onclick="down()" style="color: blue; cursor: pointer;"
                                               class="fa-solid fa-arrow-down"></i>
                                        </th>
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
                                <div class="container" style="display: flex; justify-content: center">
                                    <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" id="page" name="page"/>
                                    <input type="hidden" value="" id="limit" name="limit"/>
                                </div>
                            </div>
                        </form>
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

    function down() {
        location.href = "/ADMIN_MNG/posts/desc"
    }

    function up() {
        location.href = "/ADMIN_MNG/posts/asc"
    }

    function remove(id) {
        if (window.confirm("Xóa bài đăng  " + id + "?")) {
            $.ajax({
                type: "DELETE",
                url: '/posts/' + id,
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

    let totalPages = ${paging.totalPage};
    let currentPage = ${paging.page};
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#limit').val(5);
                    $('#page').val(page);
                    $('#formSubmit').submit();
                }

            }
        });
    });


</script>
</html>
