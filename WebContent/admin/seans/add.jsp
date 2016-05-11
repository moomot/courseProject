<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="panel panel-default">
  <div class="panel-heading">Добавление сеанса</div>
  <% String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    %>
  <div class="panel-body" style="padding-bottom: 0;">
   <form action="<%=baseURL %>admin/rest/seans/add" data-base="<%=baseURL %>" method="post" accept-charset="utf-8" class="addForm">
    <div class="btn-group dropdown-list1" style="margin-bottom: 5px"> 
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
<div class="btn-group dropdown-list2" style="margin-bottom: 5px">
    <input type="hidden" value="" name="hallId" /> 
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Выберите зал <span class="caret"></span></button>
  <ul class="dropdown-menu" role="menu">
    
  </ul>
</div>
<div class="btn-group dropdown-list3" style="margin-bottom: 5px">
    <input type="hidden" value="" name="movieId" /> 
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Выберите фильм <span class="caret"></span></button>
  <ul class="dropdown-menu" role="menu">
    
  </ul>
</div>
    <div>
    	<input type="text" class="form-control" required name="datetime" value="" placeholder="Дата">
    </div>
    <div>
    	<input type="text" class="form-control" required name="price" value="" placeholder="Цена">
    </div>
    <div>
    	<input type="text" class="form-control" required name="free_seats" value="" placeholder="Свободных мест">
    </div>
    <div>
    	<input type="text" class="form-control" required name="occupied_seats" value="" placeholder="Занятых мест">
    </div>
    <p class="text-right"><input type="submit" class="btn btn-success" name="add" value="Добавить &rarr;"/></p>
</form>

  </div>
</div>
