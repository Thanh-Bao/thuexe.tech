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
                        <form action='<c:url value ="/ADMIN_MNG/posts"/>' id="formSubmit" method="get">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Title</th>
                                        <th scope="col">Owner</th>
                                        <th scope="col">Hide</th>
                                        <th scope="col"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="post" items="${posts}" varStatus="loop">
                                        <tr>
                                            <th scope="row">${post.id}</th>
                                            <td>${post.title}</td>
                                            <td>${post.user.username}</td>
                                            <td>${post.rented}</td>
                                            <td>
                                                <div id="div-lock${loop.index}">
                                                    <c:if test="${!post.rented}">
                                                        <i onclick="lock(${loop.index}, '${post.id}')"
                                                           class="lock fa-solid fa-lock"></i>
                                                    </c:if>
                                                    <c:if test="${post.rented}">
                                                        <i onclick="unlock(${loop.index}, '${post.id}')"
                                                           class="unlock fa-solid fa-lock-open"></i>
                                                    </c:if>
                                                </div>
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

    const lock = (index, username) => {
        if (window.confirm("Ẩn bài đăng " + username + "?")) {

        }

    }

    const unlock = (index, username) => {
        if (window.confirm("Ẩn bài đăng " + username + "?")) {


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
