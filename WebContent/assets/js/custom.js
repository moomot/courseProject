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
});