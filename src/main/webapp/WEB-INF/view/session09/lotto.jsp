<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Lotto Page</title>
		<style type="text/css">
			<!-- table 表內的文字內容置中 -->
			td, th {
				text-align: center;
			}
		</style>
	</head>
	<body style="padding: 15px">
		<button type="button" 
				onclick="${ pageContext.request.contextPath }/mvc/lotto/get"
				class="pure-button pure-button-primary">
			取得 Lotto 539 電腦選號		
		</button>
		
		Lotto 歷史紀錄: <p />
		${ lottos }
		
	</body>
</html>