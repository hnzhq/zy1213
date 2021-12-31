<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<base href="${ctx}/">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<c:choose>
	<c:when test="${title != null }">
		<title>${title}</title>
	</c:when>
	<c:otherwise>
		<title>异常或错误信息提示</title>
	</c:otherwise>
</c:choose>

<link rel="stylesheet" type="text/css" href="assets/public/lib/layui/css/layui.css" />
<script type="text/javascript" src="assets/public/lib/layui/layui.js"></script>
<style type="text/css">
.title {
	margin: 15px;
}
</style>
</head>
<body>
	<!-- 显示错误信息 -->
	<c:choose>
		<c:when test="${error != null }">
			<h2 class="title">${error}</h2>
		</c:when>
		<c:otherwise>
			<h2 class="title">请求的操作出现异常，请对操作方式确认后稍候再试，若仍未解决，请联系管理员</h2>
		</c:otherwise>
	</c:choose>

	<!-- 显示具体异常信息 -->
	<c:if test="${exception != null }">
		<div style="display: none;">${exception }</div>
	</c:if>

	<script type="text/javascript">
		var ctx = "${ctx}";
		//是否弹出
		var popup = "${popup}";
		var fallbackUrl = "${fallbackUrl}";

		layui.use([ "layer", "jquery" ], function() {
			var $ = layui.jquery;
			var layer = layui.layer;

			if (popup) {
				//错误信息
				var msg = $("h2.title").text();

				layer.alert(msg, function(idx) {
					//关闭弹出框
					layer.close(idx);
					//如果有跳转url，则跳转
					if (fallbackUrl) {
						location.href = ctx + "/" + fallbackUrl;
					}
				});
			}
		});
	</script>
</body>
</html>