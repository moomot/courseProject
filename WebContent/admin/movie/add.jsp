<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="panel panel-default">
  <div class="panel-heading">Добавление фильма</div>
  <% String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    %>
  <div class="panel-body" style="padding-bottom: 0;">
   <form action="<%=baseURL %>admin/rest/movie/add" method="post" accept-charset="utf-8" class="addForm">
   
    <div>
    	<input type="text" class="form-control" required name="name" value="" placeholder="Название фильма">
    </div>
     
    <div>
    	<textarea class="form-control" required name="description" placeholder="Описание" id="" cols="30" rows="10"></textarea>
    </div>
    <div>
    	<input type="text" class="form-control" required name="duration" value="" placeholder="Длительность">
    </div>
    <div>
    	<input type="text" class="form-control" required name="earned_money" value="" placeholder="Кассовый сбор">
    </div>
    <div>
    	<input type="text" class="form-control" required name="producer" value="" placeholder="Продюсеры">
    </div>
    <div>
    	<input type="text" class="form-control" required name="genres" value="" placeholder="Жанры">
    </div>
    <div>
    	<input type="text" class="form-control" required name="rating" value="" placeholder="Рейтинг">
    </div>
    <p class="text-right"><input type="submit" class="btn btn-success" name="add" value="Добавить &rarr;"/></p>
</form>

  </div>
</div>
