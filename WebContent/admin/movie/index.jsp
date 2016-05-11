<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    %>
<div class="panel panel-default">
  <div class="panel-heading">Список фильмов</div>
  <div class="panel-body" style="padding-top:0; padding-bottom: 0;">
   <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Название</th>
            <th>Описание</th>
            <th>Длительность</th>
            <th>Кассовый сбор</th>
            <th>Продюсер</th>
            <th>Жанры</th>
            <th>Рейтинг</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%@ page import="java.util.*" import="java.io.*" import="tables.Movie"%>
	<%
		List<Movie> list = (List<Movie>) request.getAttribute("list");
		for(Movie movie : list) {
			%>
			<tr>
				<td><%=movie.getMovieId()%></td>
				<td><%=movie.getName()%></td>
				<td><%=movie.getDescription()%></td>
				<td><%=movie.getDuration()%></td>
				<td><%=movie.getEarned_money()%></td>
				<td><%=movie.getProducer()%></td>
				<td><%=movie.getGenres()%></td>
				<td><%=movie.getRating()%></td>
				<td class="text-right removeItem"><a href="<%=baseURL %>admin/rest/movie/remove/<%=movie.getMovieId()%>">Удалить</a></td> 
			</tr> 
			<%
		}
	%>
        </tbody>
    </table>
  </div>
</div>
