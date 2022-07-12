<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td rowspan="5" width="30%"><img style="width: 150px"
							src="<c:url value='http://localhost:80/image/${book.image }'/>"></td>
			
			<td><spring:message code="book.isbn" /></td>
			<td><label>${book.isbn }</label></td>

		</tr>
		<tr>
			<td><spring:message code="book.name" /></td>
			<td><label>${book.title }</label></td>
		</tr>
		<tr>
			<td>
				<spring:message code="author" /></td>
		<td><label>${book.author }</label></td>

		</tr>
		<tr>
			<td>
				<spring:message code="publisher" /></td>
			<td><label>${book.publisher }</label></td>
		</tr>
		<tr>
			<td><spring:message code="book.price" /></td>
			<td><label>${book.price }</label></td>
		</tr>

		
		<tr>
			<td align="center"><spring:message
					code="book.description" /></td>
			<td colspan="2"><label>${book.description }</label></td>
		</tr>
	</table>
	<a href="<c:url value='/list'/>"><input type="button"
		value="<spring:message code="book.list"/>"></a>

</body>
</html>