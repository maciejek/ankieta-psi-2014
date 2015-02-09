<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<table class="table table-bordered table-hover">
	<thead>
	<tr>
	<th colspan="3">Ankiety dostępne do wypełnienia</th>
	</tr>
	</thead>
	<tbody>
	<c:if test="${success eq true}">
		<div class="alert alert-success alert-dismissible fade in" role="alert">
	     	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
	     	Dziękujemy za wypełnienie ankiety!
	    </div>
	    
	</c:if>
	
		<c:forEach items="${ankiety}" var="ankieta">
			<tr>
				<td>
					${ankieta.tytul}
				</td>
				<td>
					Termin mija: ${ankieta.terminZakonczenia}
				</td>
				<td>
				<form:form action="wypelnianieListaAnkiet.html">
					<input type="hidden" name="idAnkiety" id="idAnkiety" class="form-control" placeholder="Jira server URL"
						required value="${ankieta.id}"> 
						<input class="btn btn-sm" type="submit" value="Wypełnij teraz">
				</form:form>
			</tr>
		</c:forEach>
	</tbody>
</table>