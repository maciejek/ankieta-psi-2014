var QUESTION_INDEX = 1;

$(document).ready(function() {
	init();
	initPoolEvents();
	addQuestion();
	initBeforeSendForm();
});

function init() {
	$('.pool-step').hide();
	$('#step1').show();
	$('.nav-step').on('click', function() {
		goToStep($(this));
	});
}

function initPoolEvents() {
	$('.questions').delegate('.question-radio', 'click', function(event) {
		changeQuestionType($(this));
	});
	
	$('.questions').delegate('.checkbox', 'click', function(event) {
		chooseNumericAnswers($(this));
	});
	
	$('.questions').delegate('.add-variant', 'click', function(event) {
		addAnswerVariant($(this));
	}); 
	
	$('.questions').delegate('.remove-variant', 'click', function(event) {
		removeAnswerVariant($(this));
	}); 
}

function initBeforeSendForm() {
	$('#pool-form').submit(function() {
		$('#new-question').remove();
		saveQuestionsAsJSON();
	});
}

function goToStep(step) {
	var stepId = step.find('a').attr('href');
	$('.nav-step-progress').removeClass('active');
	$(stepId + '-nav').addClass('active');
	$('.pool-step').hide();
	$(stepId).show();
	
	switch (stepId) {
	case "#step1" :
		loadStep1();
		break;
	case "#step2" :
		loadStep2();
		break;
	case "#step3" :
		addStudentsGroupToModel(); 
		break;
	}
}

function preventDefault(e) {
	e.preventDefault();
}

function changeTeacher(selected) {
	$('#teacherId').val(selected.value);
	loadStep1();
}

function chooseClasses(selected) {
	$('#classesId').val(selected.value);
}

function addStudentsGroupToModel() {
	var students = {
			grupa: []
		};
	
	$('.students-list li').each(function() {
		students.grupa.push({
			id : $(this).data("id")
		});
	});

	$('#studentsGroup').val(JSON.stringify(students));
}

function addQuestion() {
	var questionHtml = $('#new-question').html();
	$('.questions').append(questionHtml);
	
	questionHtml = $('.questions > .question:last-child');
	
	questionHtml.attr('data-id', QUESTION_INDEX);
	questionHtml.find('.question-text').attr('name', "pytanie_" + QUESTION_INDEX);
	questionHtml.find('.question-radio').attr('name', "typPytania_" + QUESTION_INDEX);
	questionHtml.find('.checkbox').attr('name', "czyLiczbowe_" + QUESTION_INDEX);
	questionHtml.find('.answer-count').attr('name', "liczbaOdpowiedzi_" + QUESTION_INDEX);
	questionHtml.find('.answer-variant').attr('name', "wariantOdpowiedzi_" + QUESTION_INDEX);
	
	QUESTION_INDEX++;
	
	questionHtml.find('.remove-variant').hide();
}

function changeQuestionType(selected) {
	var question = selected.closest('.question');
	
	if (selected.val() === "1") {
		
		question.find('.answer-count-area').show();
		
		if (question.find('.checkbox').is(':checked')) {
			question.find('.answer-variant-area').hide();
		} else {
			question.find('.answer-variant-area').show();
		}
	} else {
		question.find('.answer-count-area').hide();
		question.find('.answer-variant-area').hide();
	}
}

function chooseNumericAnswers(checkbox) {
	var question = checkbox.closest('.question');
	
	if (checkbox.is(':checked')) {
		question.find('.answer-variant-area').hide();
		question.find('.answer-count').prop('disabled', false);
	} else {
		question.find('.answer-variant-area').show();
		question.find('.answer-count').prop('disabled', true);
	}
}

function addAnswerVariant(button) {
	var question = button.closest('.question'),
		answerVariants = question.find('.answer-variants');
	
	answerVariants.find('.remove-variant').show();
	
	if (answerVariants.find('.answer-variant').size() < 10) {
		answerVariants.append('<p>' + answerVariants.find('p').eq(0).html() + '</p>');
	} else {
		button.prop('disabled', true);
	}
	
	if (answerVariants.find('.answer-variant').size() == 10) {
		button.prop('disabled', true);
	}
}

function removeAnswerVariant(button) {
	var question = button.closest('.question'),
		answerVariants = question.find('.answer-variants'),
		answerVariant = button.parent(),
		addVariantButton = question.find('.add-variant');
	
	if (answerVariants.find('.answer-variant').size() > 2) {
		answerVariant.remove();
	} 
	
	if (answerVariants.find('.answer-variant').size() == 2) {
		answerVariants.find('.remove-variant').hide();
	}
	
	if (addVariantButton.is(':disabled')) {
		addVariantButton.prop('disabled', false);
	}
}

function saveQuestionsAsJSON() {
	var questions = $('.questions > .question'), question, i, j, json,
		questionText, isOpened, numericAnswers, numericAnswersCount, answerVariants;
	
	for (i = 0; i < questions.length; i++) {
		question = questions.eq(i);
		
		questionText = question.find('.question-text').val();
		isOpened = question.find('.question-radio').eq(0).is(':checked') ? false : true;
		numericAnswers = question.find('.checkbox').is(':checked') ? true : false;
		numericAnswersCount = question.find('.answer-count').val();
		answerVariants = question.find('.answer-variant');
		
		var q = {};
		q.tresc = questionText;
		q.czyOtwarte = isOpened;
		
		if (isOpened) {
			
			q.czyLiczbowy = false;
			q.warianty = [];
			
		} else {
			
			q.czyLiczbowy = numericAnswers;
			q.warianty = [];
			
			if (numericAnswers) {
				
				for (j = 0; j < numericAnswersCount; j++) {
				
					q.warianty.push({
						tresc : "" + (j + 1)
					});
				}
			} else {
				
				for (j = 0; j < answerVariants.length; j++) {
					
					q.warianty.push({
						tresc : answerVariants.eq(j).val()
					});
				}
			}
		} 
		
		question.find('.question-hidden').val(JSON.stringify(q));
	}
}