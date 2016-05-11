<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    %>
<div class="panel panel-default">
  <div class="panel-heading">Список сеансов</div>
  <div class="panel-body" style="padding-top:0; padding-bottom: 0;">
   <div class="row" style="margin: 5px 0 0 5px;">
   <p>Кинотеатр: </p>
     <div class="btn-group dropdown-list dropdown-list-table-seans" data-base="<%=baseURL %>" style="margin-bottom: 5px">
    <input type="hidden" value="" name="cinemaId" /> 
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Выберите кинотеатр <span class="caret"></span></button>
  <ul class="dropdown-menu" role="menu">
    <%@ page import="java.util.*" import="java.io.*" import="tables.Cinema"%>
	<%
		List<Cinema> list1 = (List<Cinema>) request.getAttribute("cinemas");
		for(Cinema cinema : list1) {
			%>
			<li data-id="<%=cinema.getCinemaId() %>"><a href="#"><%=cinema.getName() %></a></li>
			<% } %>
  </ul>
</div>
   <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Кинотеатр</th>
            <th>Зал</th>
            <th>Фильм</th>
            <th>Дата</th>
            <th>Цена</th>
            <th>Свободных мест</th>
            <th>Занятых мест</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%@ page import="java.util.*" import="java.io.*" import="tables.Seans"%>
	<%
		List<Seans> list = (List<Seans>) request.getAttribute("list");
		for(Seans seans : list) {
			%>
			<tr>
				<td><%=seans.getSeansId()%></td>
				<td><%=seans.getCinema().getName()%></td>
				<td><%=seans.getHall().getName()%></td>
				<td><%=seans.getMovie().getName()%></td>
				<td><%Date date = new Date ();
				date.setTime((long)unix_time*1000);seans.getDatetime()%></td>
				<td><%=seans.getPrice()%></td>
				<td><%=seans.getFreeSeats()%></td>
				<td><%=seans.getOccupiedSeats()%></td>
				<td class="text-right removeItem"><a href="<%=baseURL %>admin/rest/seans/remove/<%=seans.getSeansId()%>">Удалить</a></td> 
			</tr> 
			<%
		}
	%>
        </tbody>
    </table>
  </div>
</div>
