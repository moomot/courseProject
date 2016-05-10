<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Админка</title>
    <link rel="stylesheet" href="<%=baseURL %>assets/css/style.css"/>
    <link rel="stylesheet" href="<%=baseURL %>assets/css/bootstrap.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Script loading -->
    <script src="<%=baseURL %>assets/js/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
    	<div class="modal-body">
    	
    	</div>
    </div>
  </div>
</div>
<jsp:include page="sections/nav.jsp" />
   <div class="container">
    <div class="row">
    	<% String viewName = request.getAttribute("viewName").toString(); %>
		<jsp:include page="<%=viewName %>" />
    </div>
</div>
    <script src="<%=baseURL %>assets/js/bootstrap.min.js"></script>
    <script src="<%=baseURL %>assets/js/custom.js"></script>
</body>
</html>