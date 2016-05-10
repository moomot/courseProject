<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    %>
<div class="panel panel-default">
  <div class="panel-heading">Список кинотеатров</div>
  <div class="panel-body" style="padding-top:0; padding-bottom: 0;">
   <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Название</th>
            <th>Адрес</th>
            <th>Количество залов</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%@ page import="java.util.*" import="java.io.*" import="tables.Cinema"%>
	<%
		List<Cinema> list = (List<Cinema>) request.getAttribute("list");
		for(Cinema cinema : list) {
			%>
			<tr>
				<td><%=cinema.getCinemaId()%></td>
				<td><%=cinema.getName()%></td>
				<td><%=cinema.getAddress()%></td>
				<td><%=cinema.getHalls()%></td> 
				<td class="text-right removeItem"><a href="<%=baseURL %>admin/rest/cinema/remove/<%=cinema.getCinemaId()%>">Удалить</a></td> 
			</tr> 
			<%
		}
	%>
        </tbody>
    </table>
  </div>
</div>
