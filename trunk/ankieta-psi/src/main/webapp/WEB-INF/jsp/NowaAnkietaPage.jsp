<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<ul class="nav nav-pills nav-justified">
	<li role="presentation" class="nav-step active" id="step1-nav">
		<a>
			<strong>Krok 1</strong><br/>
			<span class="nav-subtitle">Wybór zajęć</span>
		</a>
	</li>
	<li role="presentation" class="nav-step" id="step2-nav">
		<a>
			<strong>Krok 2</strong><br/>
			<span class="nav-subtitle">Wybór grupy ankietowanych</span>
		</a>
	</li>
	<li role="presentation" class="nav-step" id="step3-nav">
		<a>
			<strong>Krok 3</strong><br/>
			<span class="nav-subtitle">Definicja pytań</span>
		</a>
	</li>
</ul>

<div class="tab-content">
	
	<div class="pool-step col-md-12" id="step1">
		<div class="row">
			<p>step1</p>
		</div>
		<div class="row">
			<nav>
				<ul class="pager">
					<li class="next nav-step"><a href="#step2">Dalej</a></li>
				</ul>
			</nav>
		</div>
	</div>
	
	<div class="pool-step col-md-12" id="step2">
		<div class="row">
			<p>step2</p>
		</div>
		<div class="row">
			<nav>
				<ul class="pager">
					<li class="previous nav-step"><a href="#step1">Wstecz</a></li>
					<li class="next nav-step"><a href="#step3">Dalej</a></li>
				</ul>
			</nav>
		</div>
	</div>
	
	<div class="pool-step col-md-12" id="step3">
		<div class="row">
			<p>step3</p>
		</div>
		<div class="row">
			<nav>
				<ul class="pager">
					<li class="previous nav-step"><a href="#step2">Wstecz</a></li>
				</ul>
			</nav>
		</div>
	</div>
	
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/createPool.js"></script>