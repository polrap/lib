<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/static/js/bookjs.js"/>" async></script>
<meta charset="UTF-8">
<title>책등록</title>
</head>
<body>
<div id="image_container"></div>
	<form:form modelAttribute="BookRequest"  method="POST" enctype="multipart/form-data">
		<table border="1" >
			<tr >
				<td align="right" colspan="3" width="100%"><spring:message code="star.required" /></td>
			</tr>
			<tr >
				<td rowspan="6"  width="30%"><img style=width:150px; id="preview-image"></td>
				<td><spring:message code="star" /><spring:message code="book.isbn" /></td>
				<td><form:input path="isbn" type="text"/><form:errors path="isbn" /></td>
				
			</tr>
			<tr>
				<td><spring:message code="star" /><spring:message code="book.name" /></td>
				<td><form:input path="title" type="text"/><form:errors path="title" /></td>
			</tr>
			<tr>
				<td><spring:message code="star" /><spring:message code="author" /></td>
				<td><form:input path="author" type="text"/><form:errors path="author" /></td>
				
			</tr>
			<tr>
				<td><spring:message code="star" /><spring:message code="publisher" /></td>
				<td><form:input path="publisher" type="text"/><form:errors path="publisher" /></td>
			</tr>
			<tr>
				<td><spring:message code="star" /><spring:message code="book.price" /></td>
				<td><form:input path="price" type="text"/><form:errors path="price" /></td>
			</tr>
			
			<tr>
				<td><spring:message code="image" /></td>
				<td><form:input id="input-image" path="image" type="file" class="hidden"/>
				<form:errors path="image" />
				<!-- <label for="inputiamge">책 이미지 추가</label> --></td>
			</tr>
			<tr>
				<td width="30%" align="center"><spring:message code="star" /><spring:message code="book.description"/></td>
				<td colspan="3"><form:input path="description" type="text"/><form:errors path="description" /></td>
			</tr>
		</table>
		<input type="submit" value="<spring:message code="star" /><spring:message code="book.add"/>">
		<a href="/lib/list"><input type="button" value="<spring:message code="book.list"/>"></a>
	</form:form>

</body>
</html>