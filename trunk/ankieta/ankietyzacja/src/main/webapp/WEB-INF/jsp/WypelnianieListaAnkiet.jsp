<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<table class="table table-bordered table-hover">
	<thead>
	<tr>
	<th>ankieta</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${ankiety}" var="ankieta">
			<tr>
				<td>
					<a href="<spring:url value="/wypelnianieListaAnkiet/${ankieta.id}.html"/>">
						${ankieta.tytul}
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>