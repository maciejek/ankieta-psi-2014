<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>Ankieta: ${ankieta.tytul}</h1>
<p>Termin wypełniania mija: ${ankieta.terminZakonczenia}</p>

	<c:set var="pytanieCount" value="1" scope="page" />
		<c:forEach items="${ankieta.pytania}" var="pytanie">
					${pytanieCount}. ${pytanie.tresc}
				<c:catch var="exception">
			 		<c:set var="wariantCount" value="1" scope="page" />
				    <c:forEach items="${pytanie.wariantyOdpowiedzi}" var="wariant">
					    <div class="radio">
							<label><input type="radio" name="wariant-${pytanieCount}"> ${wariant.tresc}</label>
						</div>
						<c:set var="wariantCount" value="${wariantCount + 1}" scope="page"/>
					</c:forEach>
				</c:catch>
				<c:if test="${not empty exception}">
					<textarea name="odpowiedz-${pytanieCount}" class="form-control"></textarea>
				</c:if>
			<c:set var="pytanieCount" value="${pytanieCount + 1}" scope="page"/>
		</c:forEach>

