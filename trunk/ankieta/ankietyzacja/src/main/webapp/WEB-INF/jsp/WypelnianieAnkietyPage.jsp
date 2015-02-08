<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>Ankieta: ${ankieta.tytul}</h1>
<p>Termin wypełniania mija: ${ankieta.terminZakonczenia}</p>

<c:set var="pytanieCount" value="1" scope="page" />
<form:form commandName="wypelniona" method="POST" action="ankietaWypelniona.html">
	<c:forEach items="${ankieta.pytania}" var="pytanie">
				${pytanieCount}. ${pytanie.tresc}
			<div>
				<c:catch var="exception">
			 		<c:set var="wariantCount" value="1" scope="page" />
				    <c:forEach items="${pytanie.wariantyOdpowiedzi}" var="wariant">
					    <c:choose>
						    <c:when test="${wariant.czyLiczbowy}">
						    	<div class="radio-inline">
					    	</c:when>
					    	<c:otherwise>
					        	<div class="radio">
						    </c:otherwise>
						</c:choose>
							<label><input type="radio" name="wariant-${pytanieCount}" onclick="wariantSelected(this)" value="${wariant.tresc}" required>${wariant.tresc}</input></label>
						</div>
					</c:forEach>
					<form:input type="hidden" path="odpowiedziOtwarte" id="wybrane-wariant-${pytanieCount}" ></form:input>
				</c:catch>
				<c:if test="${not empty exception}">
					<textarea name="odpowiedziOtwarte" class="form-control" required ></textarea>
				</c:if>
			</div>
		<c:set var="pytanieCount" value="${pytanieCount + 1}" scope="page"/>
	</c:forEach>
	<textarea type="hidden" id="ankietaId" name="ankietaId" class="form-control">${ankieta.id}</textarea>
	<p class="text-right">
		<input class="btn btn-default" type="submit" value="Zakończ i wyślij ankietę">
	</p>
</form:form>




<script type="text/javascript">
function wariantSelected(selected) {
	var wybraneInput = "#wybrane-"+selected.name;
	$(wybraneInput).val(selected.value);
}
</script>