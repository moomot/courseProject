<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="panel panel-default">
  <div class="panel-heading">Добавление кинотеатра</div>
  <% String url = request.getRequestURL().toString();
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
    %>
  <div class="panel-body" style="padding-top:0; padding-bottom: 0;">
   <form action="<%=baseURL %>admin/rest/cinema/add" method="post" accept-charset="utf-8" class="addForm">
    <h3></h3>
    <div>
    	<input type="text" class="form-control" required name="title" value="" placeholder="Название кинотеатра">
    </div>
     <div>
    	<input type="text" class="form-control" required name="halls" value="" placeholder="Количество залов">
    </div>
    <div>
    	<textarea class="form-control" required name="address" placeholder="Адрес" id="" cols="30" rows="10"></textarea>
    </div>
    <p class="text-right"><input type="submit" class="btn btn-success" name="add" value="Добавить &rarr;"/></p>
</form>

  </div>
</div>
