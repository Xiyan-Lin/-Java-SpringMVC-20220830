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
				onclick="window.location.href='${ pageContext.request.contextPath }/mvc/lotto/get';"
				class="pure-button pure-button-primary">
			取得 Lotto 539 電腦選號		
		</button>
		<p />
		最新 lotto 資料: ${ lotto }
		<p />
		
		統計每一個號碼出現的次數:
		<button type="button" 
				onclick="window.location.href='${ pageContext.request.contextPath }/mvc/lotto/stat';"
				class="pure-button pure-button-primary">
			統計運算		
		</button>
		<p />
		${ stat }
		
		<p />
		Lotto 歷史紀錄: <p />
		<table class="pure-table pure-table-bordered">
			<thead>
				<tr>
					<th>#</th><th>號碼 1</th><th>號碼 2</th><th>號碼 3</th><th>號碼 4</th><th>號碼 5</th><th>更新 (Update)</th><th>刪除 (Delete)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="status" var="lotto" items="${ lottos }">
					<tr>
						<td>${ status.index }</td>
						<c:forEach var="num" items="${ lotto }">
							<td>${ num }</td>
						</c:forEach>
						<td>
							<button type="button" 
									onclick="window.location.href='${ pageContext.request.contextPath }/mvc/lotto/update/${ status.index }';"
									class="pure-button pure-button-primary">
								修改		
							</button>
						</td>
						<td>
							<button type="button" 
									onclick="window.location.href='${ pageContext.request.contextPath }/mvc/lotto/delete/${ status.index }';"
									class="pure-button pure-button-primary">
								刪除		
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
	</body>
</html>