<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    %>
<div class="panel panel-default">
  <div class="panel-heading">Топ 10 по оценкам</div>
  <div class="panel-body" style="padding-top:0; padding-bottom: 0;">
   <table class="table">
        <thead>
        <tr>
            <th>Название</th>
        </tr>
        </thead>
        <tbody>
        <%@ page import="java.util.*" import="java.io.*" import="tables.Movie"%>
	<%
		List<String> list = (List<String>) request.getAttribute("list");
		for(String movie : list) {
			%>
			<tr>
				<td><%=movie%></td>
			</tr> 
			<%
		}
	%>
        </tbody>
    </table>
  </div>
</div>
