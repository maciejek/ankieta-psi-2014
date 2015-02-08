<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<select id="template-select" class="form-control" style="width: auto;">
	<c:forEach items="${ankietaModel.szablony}" var="szablon">
		<option value="${szablon.id}">
			${szablon.nazwa}
		</option>
	</c:forEach>
</select>