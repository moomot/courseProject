$(function () {
	// Form submit
	var form = $(".addForm");
	form.submit(function (e) {
		e.preventDefault();
		var data = $(this).serialize();
		var url = $(this).attr("action");
		$.ajax({
			  type: 'POST',
			  url: url,
			  data: data,
			  success: function(status){
				  var modal = $('.modal');
				  modal.modal(modal.find(".modal-body").text(status));
				  setTimeout(function () {
					  modal.modal("hide");
					  form.find('input[type="text"], textarea').val("");
				  }, 3000);
			  }
			});
	});
	
	// On remove button clicked
	var removeButton = $(".removeItem");
	removeButton.click(function (e) {
		e.preventDefault();
		var url = $(this).find("a").attr("href");
		var documentLocation = document.location.href;
		$.ajax({
			  type: 'GET', 
			  url: url,
			  success: function(status){
				  $.ajax({
						 type: 'GET',
						 url: documentLocation,
						 success: function(status){
							 var data = $(status).find("tbody").html();
							 removeButton.parent().parent().html(data);
						 }
						 });
				  var modal = $('.modal');
				  modal.modal(modal.find(".modal-body").text(status));
				  setTimeout(function () {
					  modal.modal("hide");
				  }, 3000);
			  }
			});
	});
	
	var dropDownList = $(".dropdown-list");
	dropDownList.find("a").click(function (e) {
		e.preventDefault();
		var id = $(this).parent().data('id');
		var text = $(this).text();
		dropDownList.find("input").val(id);
		dropDownList.find(".dropdown-toggle").html(text+' <span class="caret"></span>');
		
	}); 
	
	var dropDownList1 = $(".dropdown-list1");
	var dropDownList2 = $(".dropdown-list2");
	var dropDownList3 = $(".dropdown-list3");
	dropDownList1.find("a").click(function (e) {
		e.preventDefault();
		var id = $(this).parent().data('id');
		var text = $(this).text();
		dropDownList1.find("input").val('');
		dropDownList1.find("input").val(id);
		dropDownList1.find(".dropdown-toggle").html(text+' <span class="caret"></span>');
		// the second
		dropDownList2.find(".dropdown-toggle").html("Выберите зал"+' <span class="caret"></span>');
		dropDownList3.find(".dropdown-toggle").html("Выберите фильм"+' <span class="caret"></span>');
		// ajax request to get data of hall
		var baseUrl = dropDownList1.parents().find("form").data("base");
		var url = baseUrl;
		dropDownList2.find("ul").html('');
		dropDownList3.find("ul").html('');
		url += "admin/rest/hall/getHalls/"+id;
		var dataStatus = true;
		$.ajax({
			  type: 'GET',
			  url: url,
			  success: function(status){
				  
				  if(status.length != 0) {
					  for(var i = 0; i < status.length; i++) {
						  dropDownList2.find("ul").append("<li data-id="+status[i].hallId+"><a href='#'>"+status[i].name+"</a></li>");
					  }
				  } else {
					  dataStatus = false;
					  dropDownList2.find(".dropdown-toggle").html("Нет доступных залов <span class='caret'></span>");
				  }
					dropDownList2.find("a").click(function (e) {
					e.preventDefault();
					var id = $(this).parent().data('id');
					var text = $(this).text();
					dropDownList2.find("input").val(id);
					dropDownList2.find(".dropdown-toggle").html(text+' <span class="caret"></span>');
				}); 
			  }
			});
		// get movies
		if(dataStatus) {
		url = baseUrl;
		url += "admin/rest/movie/getMovies";
		$.ajax({
			  type: 'GET',
			  url: url,
			  success: function(status){
				  
				  if(status.length != 0) {
					  for(var i = 0; i < status.length; i++) {
						  dropDownList3.find("ul").append("<li data-id="+status[i].movieId+"><a href='#'>"+status[i].name+"</a></li>");
					  }
				  } else {
					  dropDownList3.find(".dropdown-toggle").html("Нет доступных фильмов <span class='caret'></span>");
				  }
					dropDownList3.find("a").click(function (e) {
					e.preventDefault();
					var id = $(this).parent().data('id');
					var text = $(this).text();
					dropDownList3.find("input").val(id); 
					dropDownList3.find(".dropdown-toggle").html(text+' <span class="caret"></span>');
				}); 
			  }
			});
		}
	}); 
	
});

$(function () {
	var dropDownList = $(".dropdown-list-table-hall");
	dropDownList.find("a").click(function (e) {
		e.preventDefault();
		var text = $(this).text();
		$(document).find("table tbody").find("td:nth-child(4):contains('"+text+"')").parent().show();
		$(document).find("table tbody").find("td:nth-child(4):not(:contains('"+text+"'))").parent().hide();
	}); 
	dropDownList.find("a").eq(0).click();
});

$(function () {
	var dropDownList = $(".dropdown-list-table-seans");
	dropDownList.find("a").click(function (e) {
		e.preventDefault();
		var text = $(this).text();
		$(document).find("table tbody").find("td:nth-child(2):contains('"+text+"')").parent().show();
		$(document).find("table tbody").find("td:nth-child(2):not(:contains('"+text+"'))").parent().hide();
	}); 
	dropDownList.find("a").eq(0).click();
});