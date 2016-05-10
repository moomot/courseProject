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
		$.ajax({
			  type: 'GET', 
			  url: url,
			  success: function(status){
				  var modal = $('.modal');
				  modal.modal(modal.find(".modal-body").text(status));
				  setTimeout(function () {
					  modal.modal("hide");
				  }, 3000); 
			  }
			});
	});
});