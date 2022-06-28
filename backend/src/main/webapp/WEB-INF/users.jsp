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
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="user" items="${users}" varStatus="loop">
                                    <tr>
                                        <th scope="row">${user.username}</th>
                                        <td>${user.name}</td>
                                        <td>${user.phone}</td>
                                        <td>
                                            <div id="div-active${loop.index}">
                                                    <span>${user.active}</span>
                                            </div>
                                        </td>
                                        <td>
                                            <div id="div-lock${loop.index}">
                                                <c:if test="${user.active}">
                                                    <i onclick="lock(${loop.index}, '${user.username}')" class="lock fa-solid fa-lock"></i>
                                                </c:if>
                                                <c:if test="${!user.active}">
                                                    <i onclick="unlock(${loop.index}, '${user.username}')" class="unlock fa-solid fa-lock-open"></i>
                                                </c:if>
                                            </div>
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

    <c:url var="rootUrl" value="/users/"/>

    const lock = (index, username) => {
        if (window.confirm("Khóa tài khoản "+username+"?")) {

            $.ajax({
                type: "PUT",
                url: ${rootUrl}+username+'/lock',
                success: () => {
                    let divLock = document.getElementById("div-lock" + index);
                    let divActive = document.getElementById("div-active" + index);

                    const span = document.createElement("span");
                    span.innerHTML = "false";
                    divActive.replaceChildren(span);


                    const iconUnlock = document.createElement("i");
                    iconUnlock.classList.add('unlock', 'fa-solid', 'fa-lock-open');
                    iconUnlock.setAttribute("onclick", "unlock(" + index +", "+ "'"+username+"'" + ")");
                    divLock.replaceChildren(iconUnlock);
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

    const unlock = (index, username) => {
        if (window.confirm("Mở khóa tài khoản "+username+"?")) {

            $.ajax({
                type: "PUT",
                url: ${rootUrl}+username+'/unlock',
                success: () => {
                    let divLock = document.getElementById("div-lock" + index);
                    let divActive = document.getElementById("div-active" + index);

                    const span = document.createElement("span");
                    span.innerHTML = "true";
                    divActive.replaceChildren(span);

                    const iconLock = document.createElement("i");
                    iconLock.classList.add('lock', 'fa-solid', 'fa-lock');
                    iconLock.setAttribute("onclick", "lock(" + index +", "+ "'"+username+"'" + ")");
                    divLock.replaceChildren(iconLock);
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
