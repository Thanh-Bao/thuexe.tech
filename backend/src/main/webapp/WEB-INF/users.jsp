<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dash Board</title>
    <%@ include file="/common/linkTop.jsp" %>
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
                        <h6 class="m-0 font-weight-bold text-primary">Users</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col">Username</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">Active</th>
                                    <th scope="col">Delete</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="user" items="${users}">
                                    <tr>
                                        <th scope="row">${user.username}</th>
                                        <td>${user.name}</td>
                                        <td>${user.phone}</td>
                                        <td>${user.active}</td>
                                        <td>&times;</td>
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
</html>
