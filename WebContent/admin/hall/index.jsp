<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    %>
<div class="panel panel-default">
  <div class="panel-heading">Список залов</div>
  <div class="panel-body" style="padding-top:0; padding-bottom: 0;">
   <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Название</th>
            <th>Количество мест</th>
            <th>Кинотеатр</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%@ page import="java.util.*" import="java.io.*" import="tables.Hall"%>
	<%
		List<Hall> list = (List<Hall>) request.getAttribute("list");
		for(Hall hall : list) {
			%>
			<tr>
				<td><%=hall.getHallId()%></td>
				<td><%=hall.getName()%></td>
				<td><%=hall.getNumberOfSeats()%></td>
				<td><%=hall.getCinema().getName()%></td> 
				<td class="text-right removeItem"><a href="<%=baseURL %>admin/rest/hall/remove/<%=hall.getHallId()%>">Удалить</a></td> 
			</tr> 
			<%
		}
	%>
        </tbody>
    </table>
  </div>
</div>
