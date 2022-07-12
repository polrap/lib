<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>도서관리</title>
</head>
<body>
	<h3>
		<spring:message code="bookinfo" />
		-
		<spring:message code="list" />
	</h3>

	<form action="search" method="GET">
		<spring:message code="searchkeyword" />
		<select name="searchkey">
			<option value="defaultSearch" selected>상세 검색 설정</option>
			<option value="TITLE"><spring:message code="subject" /></option>
			<option value="author"><spring:message code="author" /></option>
			<option value="publisher"><spring:message code="publisher" /></option>
			<option value="ISBN"><spring:message code="isbn" /></option>
		</select>
		<c:if test="${not empty keyword}">
			<input name="keyword" value="${keyword }" type=text><input type="submit">
		</c:if>
		<c:if test="${empty keyword}">
			<input name="keyword" type=text><input type="submit">
		</c:if>
		
	</form>

	<c:if test="${not empty bookList || bookList ne null}">
		<table border="1">
			<tr>
				<th><spring:message code="booknum" /></th>
				<th><spring:message code="book.image" /></th>
				<th><spring:message code="book" /> <spring:message code="isbn" /></th>
				<th><spring:message code="book.subject" /></th>
				<th><spring:message code="author" /></th>
				<th><spring:message code="publisher" /></th>
				<th><spring:message code="price" /></th>
				<c:forEach var="book" items="${bookList }">

					<tr>
						<td>${book.index }</td>
						<td><a href="<c:url value='/books/read/${book.index}'/>"><img
								style="width: 150px"
								src="<c:url value='http://localhost:80/image/${book.image }'/>"></a></td>
						<td>${book.isbn }</td>
						<td>${book.title }</td>
						<td>${book.author }</td>
						<td>${book.publisher}</td>
						<td>${book.price }</td>
						<%-- <td><a href="<c:url value='/member/detail/${book.id }'/>">
							${mem.email }</a></td>
					<td>${mem.name }</td>
					<td><fmt:formatDate value="${mem.regdate }"
							pattern="yyyy-MM-dd" /></td> --%>
					</tr>
				</c:forEach>
			</tr>
		</table>

	</c:if>
	
		<div style="display: block; text-align: left;">
			<c:if test="${paging.startPage != 1 }">
				<a
					href="/list?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
			</c:if>
			<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
				<c:if test="${empty keyword}">
				<c:choose>
					<c:when test="${p == paging.nowPage }">
						<b>${p }</b>
					</c:when>
					<c:when test="${p != paging.nowPage }">
						<a href="${pageContext.request.contextPath}/list?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
					</c:when>
				</c:choose>
				</c:if>
				<c:if test="${not empty keyword}">
				<c:choose>
					<c:when test="${p == paging.nowPage }">
						<b>${p }</b>
					</c:when>
					<c:when test="${p != paging.nowPage }">
						<a href="${pageContext.request.contextPath}/search?nowPage=${p }&cntPerPage=${paging.cntPerPage}&searchkey=${search}&keyword=${keyword}">${p }</a>
					</c:when>
				</c:choose>
				</c:if>
				
			</c:forEach>

			<c:if test="${paging.endPage != paging.lastPage}">
				<a
					href="/List?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
			</c:if>
			<input type="hidden" name="nowPage"
				value='<c:if test="${empty paging.nowPage || paging.nowPage==0}">
		1
		</c:if>
		<c:if test="${!empty paging.nowPage }">
		${paging.nowPage }
		</c:if>'>
			<input type="hidden" name="cntPerPage"
				value='<c:if test="${empty paging.cntPerPage }">
		3
		</c:if>
		<c:if test="${!empty paging.cntPerPage }">
		${paging.cntPerPage }
		</c:if>
		'>
		</div>
	
</body>
</html>