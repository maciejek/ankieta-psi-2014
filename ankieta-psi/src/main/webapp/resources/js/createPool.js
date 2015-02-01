$(document).ready(function() {
	init();
});

function init() {
	$('.pool-step').hide();
	$('#step1').show();
	$('.nav-step').on('click', function() {
		goToStep($(this));
	});
}

function goToStep(step) {
	var stepId = step.find('a').attr('href');
	$('.nav-step').removeClass('active');
	$(stepId + '-nav').addClass('active');
	$('.pool-step').hide();
	$(stepId).show();
}