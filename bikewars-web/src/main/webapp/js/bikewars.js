function updateCurrentUserInfo(val) {

	$.getJSON('/bikewars/json/personal/userinfos/current', function(data) {
		var nickName = data['nickName'];
		var energy = data['energy'];
		var maxEnergy = data['maxEnergy'];
		var health = data['health'];
		var maxHealth = data['maxHealth'];
		var cash = data['cash'];
		// let's find the parent
		var parentElement = $('#user-status');

		parentElement.find('#nickname').html(nickName);
		parentElement.find('#energy').html(energy);
		parentElement.find('#max-energy').html(maxEnergy);
		parentElement.find('#health').html(health);
		parentElement.find('#max-health').html(maxHealth);
		parentElement.find('#cash').html(cash);
	});

	return true;
}

$(document).ready(function() {

	if ($('#user-status').length != 0) {
		updateCurrentUserInfo(1);
		setInterval(function() {
			updateCurrentUserInfo(1)
		}, 30000);
	}

	if ($('button.jobExecute').length != 0) {
		$('button.jobExecute').each(function(button) {

			// console.log($(this));
			$(this).click(function() {
				$(this).attr('disabled', 'disabled');
				// console.log($(this));
				// console.log($(this).attr('value'));
				var jobId = $(this).attr("value");
				var url = 'json/jobs/' + jobId + '.json';
				// console.log(url);
				$.post(url);
				updateCurrentUserInfo(1);
				$(this).removeAttr('disabled');
			}

			);

		});

	}
	
	if( $('.stockEvent').length != 0 ) {
		$('.stockEvent').each( function(button) {
			$(this).click( function () {
					console.log('stock event');
					var stockId = $(this).attr('value');
					var name = $(this).attr('name');
					
					console.log('stock' + stockId);
					console.log('name' + name);
					
					var url = '/bikewars/json/personal/stockevent?stockid=' + stockId + '&event='+name;
					console.log('url' + url);
					$.post(url, function(data) {
						console.log(data);
					    location.reload();
					});
					
					
			});
			
		} );
		
	}

});
