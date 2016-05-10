<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Админка</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Script loading -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.1.min.js"></script>
</head>
<body>
   <div class="container">
    <div class="aligner">
        <div class="row">
                <div class="center-block login-form">
                    <div class="well">
                        <form class="form-signin" method="POST" action="" name="do_login">
                        <% if(request.getAttribute("errorMessage") != null) { %>
                          	<h2 class="form-signin-heading">
                                    <p style="color:red"><%=request.getAttribute("errorMessage")%></p>
                            </h2>
                        <% } %>
                            <label for="inputEmail" class="sr-only">Login</label>
                            <input type="text" name="username" class="form-control" placeholder="Логин" required autofocus>
                            <label for="inputPassword" class="sr-only">Password</label>
                            <input type="password" name="password" class="form-control" placeholder="Пароль" required>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Авторизация</button>
                        </form>
                    </div>
                </div>
        </div>

    </div>
</div>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
</body>
</html>