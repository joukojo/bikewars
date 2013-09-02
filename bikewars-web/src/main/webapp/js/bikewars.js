
function updateCurrentUserInfo(val) {
	

	$.getJSON('/bikewars/json/personal/userinfos/current', function(data) {
		var nickName = data['nickName'];
		var energy = data['energy'];
		var maxEnergy = data['maxEnergy'];
		var health = data['health'];
		var maxHealth = data['maxHealth'];
		// let's find the parent 
		var parentElement = $('#user-status');
		
		parentElement.find('#nickname').html(nickName);
		parentElement.find('#energy').html(energy);
		parentElement.find('#max-energy').html(maxEnergy);
		parentElement.find('#health').html(health);
		parentElement.find('#max-health').html(maxHealth);
	});
	
	return true;
}

$(document).ready(function () {
	
	if($('#user-status').length != 0) {
		updateCurrentUserInfo(1);
		setInterval(function(){updateCurrentUserInfo(1)},30000);
	}
	 
	if( $('button.jobExecute').length != 0 ) {
		$('button.jobExecute').each( function(button) {
			
//			console.log($(this));
			$(this).click( 
					function() {
						$(this).attr('disabled', 'disabled');
						console.log($(this));
						console.log($(this).attr('value'));
						var jobId = $(this).attr("value");
						var url = 'json/jobs/' + jobId + '.json';
						console.log(url);
						$.post(url);
						$(this).removeAttr('disabled');
					}
			
			);
			
			
		});
		
		
		
		
	}
	  
  
});

