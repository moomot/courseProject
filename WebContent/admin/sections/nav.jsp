<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    %>
<div class="navbar navbar-default navbar-inverse navbar-static-top">
    <div class="container">
            <ul class="nav navbar-nav">
                <li><a href="<%=baseURL%>admin">На главную</a></li>
                <li><a href="#" class="dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Кинотеатры<span class="caret"></span></a>
    
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a href="<%=baseURL%>admin/cinema/add">Добавить кинотеатр</a></li>
    <li><a href="<%=baseURL%>admin/cinema/list">Список кинотеатров</a></li>
  </ul>
                
                </li>
                
                <li><a href="#" class="dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Залы<span class="caret"></span></a>
    
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
    <li><a href="<%=baseURL%>admin/hall/add">Добавить зал</a></li>
    <li><a href="<%=baseURL%>admin/hall/list">Список залов</a></li>
  </ul>
                
                </li>
                <li><a href="#" class="dropdown-toggle" type="button" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Сеансы<span class="caret"></span></a>
    
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
    <li><a href="<%=baseURL%>admin/seans/add">Добавить сеанс</a></li>
    <li><a href="<%=baseURL%>admin/seans/list">Список сеансов</a></li>
  </ul>
                
                </li>
                <li><a href="#" class="dropdown-toggle" type="button" id="dropdownMenu4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Фильмы<span class="caret"></span></a>
    
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu4">
    <li><a href="<%=baseURL%>admin/movie/add">Добавить фильм</a></li>
    <li><a href="<%=baseURL%>admin/movie/list">Список фильмов</a></li>
  </ul>
                
                </li>
               
            </ul>
    </div>
</div>