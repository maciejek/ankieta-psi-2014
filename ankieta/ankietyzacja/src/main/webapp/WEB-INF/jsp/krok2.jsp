<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<div class="form-group">
	<label for="students" class="col-sm-2 control-label">Ankietyzowani:</label>
	<div class="col-sm-10">
		<ul class="list-group students-list">
		<c:forEach items="${ankietaModel.ankietowaniDlaZajec}" var="ankietowany">
			<li class="list-group-item" data-id="${ankietowany.id}">
				${ankietowany.email}
				<button type="button" class="btn btn-default btn-sm">
					Usuń
				</button>
			</li>
		</c:forEach>
		</ul>
	</div>
</div>
<div class="form-group">
	<label for="student" class="col-sm-2 control-label">Nowy ankietyzowany:</label>
	<div class="col-sm-10">
		<input type="text" class="form-control inline" />
		<button type="button" class="btn btn-default" style="width: 100px;">
			Dodaj
		</button>
	</div>
</div>

