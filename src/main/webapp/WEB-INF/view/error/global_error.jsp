<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet"
			href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Error Page</title>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" method="get" action="${ referer }">
			<fieldset>
				<legend>錯誤頁面</legend>
				發生錯誤位置: ${ referer }<p />
				錯誤訊息內容: ${ ex }<p />
				<button type="submit" class="pure-button pure-button-primary">返回</button>
			</fieldset>
		</form>
	</body>
</html>