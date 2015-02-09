<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<ul class="nav nav-pills nav-justified">

	<li role="presentation" class="nav-step-progress active" id="step1-nav">
		<a onclick="preventDefault(e)">
			<strong>Krok 1</strong><br/>
			<span class="nav-subtitle">Wybór zajęć</span>
		</a>
	</li>
	
	<li role="presentation" class="nav-step-progress" id="step2-nav">
		<a onclick="preventDefault(e)">
			<strong>Krok 2</strong><br/>
			<span class="nav-subtitle">Wybór grupy ankietowanych</span>
		</a>
	</li>
	
	<li role="presentation" class="nav-step-progress" id="step3-nav">
		<a onclick="preventDefault(e)">
			<strong>Krok 3</strong><br/>
			<span class="nav-subtitle">Definicja pytań</span>
		</a>
	</li>
	
</ul>

<div class="tab-content">

	<form:form id="pool-form" commandName="model" method="POST" action="${pageContext.request.contextPath}/ankieta/zapisz.html">
	
		<div class="pool-step col-md-12" id="step1">
		
			<div class="row step-content"></div>
			
			<div class="row">
				<nav>
					<ul class="pager">
						<li class="next nav-step"><a href="#step2">Dalej</a></li>
					</ul>
				</nav>
			</div>
			
			<form:input type="hidden" path="idNauczyciela" id="teacherId"/>
			<form:input type="hidden" path="idZajec" id="classesId"/>
			
		</div>
		
		<div class="pool-step col-md-12" id="step2">
		
			<div class="row step-content"></div>
			
			<div class="row">
				<nav>
					<ul class="pager">
						<li class="previous nav-step"><a href="#step1">Wstecz</a></li>
						<li class="next nav-step"><a href="#step3">Dalej</a></li>
					</ul>
				</nav>
			</div>
			
			<form:input type="hidden" path="grupaAnkietowanych" id="studentsGroup"/>
			
		</div>
		
		<div class="pool-step col-md-12" id="step3">
		
			<div class="row step-content">
			
				<div class="form-group">
					<label for="teacher" class="col-sm-2 control-label">Tytuł ankiety:</label>
					<div class="col-sm-10">
						<form:input type="text" path="tytul" class="form-control"/> 
					</div>
				</div>
				
				<div class="form-group">
					<label for="teacher" class="col-sm-2 control-label">Szablon:</label>
					<div class="col-sm-10 templates-area"></div>
				</div>
				
				<div class="questions"></div>
				
				<div id="new-question" style="display: none">
				
					<div class="question-area question" data-id="[id]">
								
						<div class="form-group">
							<label for="pytanie" class="col-sm-2 control-label">Treść pytania:</label>
							<div class="col-sm-10">
								<textarea name="pytanie_[id]" class="form-control question-text" style="resize: none"></textarea>
							</div>
						</div>
						
						<div class="form-group">
						
							<label for="typPytania" class="col-sm-2 control-label">Rodzaj pytania:</label>
							<div class="col-sm-5">
								<label class="radio-label control-label"><input type="radio" value="1" checked="checked"
									name="typPytania_[id]" class="question-radio">Zamknięte</label>
								<label class="control-label" ><input type="radio" value="2" name="typPytania_[id]" 
									class="question-radio">Otwarte</label>
							</div>
							
							<div class="col-sm-5 answer-count-area">
								<div style="float: right">
									<label class="checkbox-label control-label"><input type="checkbox"
										name="czyLiczbowe_[id]" class="checkbox">Liczbowe warianty odpowiedzi</label>
									<input type="text" value="0" name="liczbaOdpowiedzi_[id]" class="form-control answer-count" disabled="disabled"></input>
								</div>
							</div>
						</div>
						
						<div class="form-group answer-variant-area">
						
							<label for="pytanie" class="col-sm-2 control-label">Warianty odpowiedzi:</label>
							<div class="col-sm-10">
							
								<div class="answer-variants">
									<p>
										<input type="text" name="wariantOdpowiedzi_[id]" class="form-control answer-variant"></input>
										<span class="glyphicon glyphicon-remove-circle remove-variant"></span>
									</p>
									
									<p>
										<input type="text" name="wariantOdpowiedzi_[id]" class="form-control answer-variant"></input>
										<span class="glyphicon glyphicon-remove-circle remove-variant"></span>
									</p>
								</div>
								
								<input type="button" value="Dodaj kolejny wariant odpowiedzi" class="btn btn-default add-variant" />
								
							</div>
						</div>
						
						<form:input type="hidden" path="pytania" class="question-hidden"/>
					</div>
				</div>
				
			</div>
			
			<div class="row">
				<nav>
					<ul class="pager">
					
						<li class="previous nav-step"><a href="#step2">Wstecz</a></li>
						
						<li style="float:right">
							<form:input type="hidden" path="pytania" class="question-hidden" value="{}"/>
							<input type="button" id="add-question" value="Dodaj kolejne pytanie" class="btn btn-default" onclick="addQuestion()"/>
							<input type="submit" id="save-pool" value="Gotowe" class="btn btn-primary" />
						</li>
						
					</ul>
				</nav>
			</div>
		</div>
		
	</form:form>
	
</div>

<script type="text/javascript">
$(document).ready(function() {
	loadStep1();
	loadStep3();
});

function loadStep1() {
	var teacherId = $('#teacherId').val();
	$.ajax({
		 url : "<spring:url value='/ankieta/krok1.html' />",
		 type : "post",
		 data : {
			 idNauczyciela: function() {
				 return teacherId;
			 }
		 },
		 success : function(data) {
			 $('#step1 > .step-content').html(data);
		 }
	});
}

function loadStep2() {
	var classesId = $('#classesId').val();
	$.ajax({
		 url : "<spring:url value='/ankieta/krok2.html' />",
		 type : "post",
		 data : {
			 idZajec: function() {
				 return classesId;
			 }
		 },
		 success : function(data) {
			 $('#step2 > .step-content').html(data);
		 }
	});
}

function loadStep3() {
	$.ajax({
		 url : "<spring:url value='/ankieta/krok3.html' />",
		 type : "post",
		 success : function(data) {
			 $('.templates-area').html(data);
		 }
	});
}
</script>
