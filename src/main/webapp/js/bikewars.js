
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
		setInterval(function(){updateCurrentUserInfo(1)},5000);

	}
	 
	  
  
});

