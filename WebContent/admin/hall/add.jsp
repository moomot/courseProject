<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="panel panel-default">
  <div class="panel-heading">Добавление зала</div>
  <% String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    %>
  <div class="panel-body" style="padding-bottom: 0;">
   <form action="<%=baseURL %>admin/rest/hall/add" method="post" accept-charset="utf-8" class="addForm">
    <div class="btn-group dropdown-list" style="margin-bottom: 5px">
    <input type="hidden" value="" name="cinemaId" /> 
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Выберите кинотеатр <span class="caret"></span></button>
  <ul class="dropdown-menu" role="menu">
    <%@ page import="java.util.*" import="java.io.*" import="tables.Cinema"%>
	<%
		List<Cinema> list = (List<Cinema>) request.getAttribute("cinemas");
		for(Cinema cinema : list) {
			%>
			<li data-id="<%=cinema.getCinemaId() %>"><a href="#"><%=cinema.getName() %></a></li>
			<% } %>
  </ul>
</div>
    <div>
    	<input type="text" class="form-control" required name="name" value="" placeholder="Название зала">
    </div>
     <div>
    	<input type="text" class="form-control" required name="number_of_seats" value="" placeholder="Количество мест">
    </div>
    <p class="text-right"><input type="submit" class="btn btn-success" name="add" value="Добавить &rarr;"/></p>
</form>

  </div>
</div>
