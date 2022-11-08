<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet"
		href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
	<meta charset="UTF-8">
	<title>Book And Author</title>
	<style type="text/css">
		.error {
			color: #FF0000;
		}
	</style>
</head>
<body style="padding: 15px;">
	<form class="pure-form" 
				 method="post" 
				 action="${ pageContext.request.contextPath }/mvc/session13/book_author/">
		<fieldset>
			<legend>Book And Author</legend>
			書名：<input id="b.name" name="b.name" /><p />
			價格：<input id="b.price" name="b.price" /><p />
			作者：<input id="a.name" name="a.name" /><p />
			年齡：<input id="a.age" name="a.age" /><p />
			<button type="submit" class="pure-button pure-button-primary">新增</button><p />
		</fieldset>
	</form>
</body>
</html>