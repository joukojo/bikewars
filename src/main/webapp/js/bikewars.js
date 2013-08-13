 $(document).ready(function () {
  console.log("document ready");
  
  $.getJSON('/bikewars/personal/json/user.htm?userid=1', function(data) {
	  console.log(data);
	  
	  
  } );
  
});