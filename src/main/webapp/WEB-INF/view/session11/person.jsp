<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spform" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Person Form</title>
		<style type="text/css">
			.error { 
				color: #FF0000
			}
		</style>
	</head>
	<body style="padding: 15px">
		<spform:form class="pure-form" method="post" modelAttribute="person" action="${ pageContext.request.contextPath }/mvc/person/">
			<fieldset>
				<legend>Person Form</legend>
				姓名: <spform:input path="name" />
					  <spform:errors path="name" cssClass="error" /><p />
				年齡: <spform:input path="age" type="number" />
					  <spform:errors path="age" cssClass="error" /><p />
				會員: <spform:radiobutton path="member" value="true" />會員
				      <spform:radiobutton path="member" value="false" />非會員
				      <spform:errors path="member" cssClass="error" /><p />
				生日: <spform:input path="birth" type="date" />
					  <spform:errors path="birth" cssClass="error" /><p />
				<button type="submit" class="pure-button pure-button-primary">新增</button><p />
				<spform:errors path="*" cssClass="error" /><p />	  	      	
			</fieldset>
		</spform:form>
		<table class="pure-table pure-table-bordered">
			<thead>
				<tr>
					<th>姓名</th><th>年齡</th><th>會員</th><th>生日</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="person" items="${ people }">
					<tr>
						<td>${ person.name }</td>
						<td>${ person.age }</td>
						<td>${ person.member }</td>
						<td>
							<fmt:formatDate value="${ person.birth }" pattern="yyyy-MM-dd"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
		
	</body>
</html>