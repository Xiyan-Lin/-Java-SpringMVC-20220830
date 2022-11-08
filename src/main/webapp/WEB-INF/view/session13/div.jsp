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
		<title>Div Form</title>
	</head>
	<body style="padding: 15px">
		<spform:form class="pure-form" 
					 method="post" 
					 modelAttribute="div" 
					 action="${ pageContext.request.contextPath }/mvc/session13/div/">
			<fieldset>
				<legend>整數除法計算</legend>
				分子: <spform:input path="x" /><p />
				分母: <spform:input path="y" /><p />
				<button type="submit" class="pure-button pure-button-primary">計算</button><p />
				結果: <spform:input path="result" readonly="true" /><p />
			</fieldset>
		</spform:form>
	</body>
</html>