<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<base href="${ctx }/">
<meta charset="UTF-8">
<title>登录页</title>
<link rel="stylesheet" type="text/css" href="assets/user/login.css">
<link rel="stylesheet" type="text/css"
	href="assets/user/bootstrap.min.css">
<!-- 引入jquery -->
<script type="text/javascript" language="javascript"
	src="assets/public/lib/jquery/jquery-3.6.0.min.js"></script>
<!-- 引入layer 用于弹出框-->
<script type="text/javascript" language="javascript"
	src="assets/public/lib/layer/layer.js"></script>
<script type="text/javascript">
	var ctx ="${ctx}";
	var error = "${error}";//页面错误信息
</script>
<script type="text/javascript" language="javascript"
	src="assets/user/login.js"></script>

</head>
<body>
	<div style="height: 1px;"></div>
	<div class="login">
		<header>
			<h1>登陆</h1>
		</header>
		<div class="sr">
			<form action="login" method="post">
				<div class="name">
					<label> <i class="sublist-icon glyphicon glyphicon-user"></i>
					</label> <input type="text" name="username" placeholder="这里输入登录名"
						class="name_inp" value=${user.username }>
				</div>
				<div class="name">
					<label> <i class="sublist-icon glyphicon glyphicon-pencil"></i>
					</label> <input type="text" name="password" placeholder="这里输入登录密码"
						class="name_inp" value=${user.password }>
				</div>
				<div class="item clearfix">
                <label>验证码：</label>
                <input type="text" name="captcha" id="captcha" class="f-s-14" placeholder="请输入验证码" style="width: 150px;">
                <a href="" style="height: 36px;width: 50px;float: right;">
                    <img id="captcha" src="captcha" style="width: 92px; height: 36px">
                    
                    <!-- <img src="" alt="" id="captcha_img"> -->
                </a>
                <span class="err-tip" id="tipCaptcha" ng-class="m-l-15"></span>
            </div>
				<button class="dl" type="submit">登陆</button>
			</form>
		</div>
	</div>

	<div
		style="text-align: center; margin: -150px 0; font: normal 14px/24px 'MicroSoft YaHei'; color: #ffffff">
		<p>适用浏览器：360、FireFox、Chrome、Opera、傲游、搜狗、世界之窗. 不支持Safari、IE8及以下浏览器。</p>
		<p>
			来源：<a href="http://sc.chinaz.com/" target="_blank">站长素材</a>
		</p>
	</div>
</body>
<script type="text/javascript">
	var img = document.querySelector("#captcha");
	img.addEventListener("click", function() {
		
		img.src = ctx + "/captcha?id" + new Date().getTime(); 
	});
</script>
</html>