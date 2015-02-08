<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<div class="form-group">
	<label for="teacher" class="col-sm-2 control-label">Nauczyciel:</label>
	<div class="col-sm-10">
		<select id="teacher-select" class="form-control" onchange="changeTeacher(this)">
			<c:forEach items="${ankietaModel.nauczyciele}" var="nauczyciel">
				<option value="${nauczyciel.id}" ${nauczyciel.id == ankietaModel.nauczyciel.id ? 'selected' : ''}>
					${nauczyciel.tytulNaukowy} ${nauczyciel.imie} ${nauczyciel.nazwisko}
				</option>
			</c:forEach>
		</select>
	</div>
</div>
<div class="form-group">
	<label for="classes" class="col-sm-2 control-label">Zajęcia:</label>
	<div class="col-sm-10">
		<select id="classes-listbox" class="form-control" size="8" onchange="chooseClasses(this)">
			<c:forEach items="${ankietaModel.zajeciaDlaNauczyciela}" var="zajecia">
				<option value="${zajecia.id}">${zajecia} ${zajecia.kurs.nazwa}</option>
			</c:forEach>
		</select>
	</div>
</div>