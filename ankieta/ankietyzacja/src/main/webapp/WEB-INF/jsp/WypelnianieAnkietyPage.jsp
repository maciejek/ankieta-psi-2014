<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>Ankieta: ${ankieta.tytul}</h1>
<p>Termin wypełniania mija: ${ankieta.terminZakonczenia}</p>
<table class="table table-bordered table-hover">
	<thead>
	<tr>
	<th>user email</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${ankieta.pytania}" var="pytanie">
			<tr>
				<td>
					${pytanie.tresc}
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>