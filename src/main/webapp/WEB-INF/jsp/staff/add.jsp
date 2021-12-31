<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--   引入标签库   -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 固定写法,获取应用上下文路径，可用于获取css的位置 -->
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
<base href="${ctx }/">
<meta charset="UTF-8">
<title>添加商品数据</title>
<link rel="stylesheet" type="text/css" href="assets/staff/add.css">
<script type="text/javascript">
	var error = "${error }";
	//商品是否到货选中不变
	var sex = "${staff.sex}";
</script>
<!-- 引入jquery -->
<script type="text/javascript" language="javascript"
	src="assets/public/lib/jquery/jquery-3.6.0.min.js"></script>
<!-- 引入layer 用于弹出框-->
<script type="text/javascript" language="javascript"
	src="assets/public/lib/layer/layer.js"></script>
<script type="text/javascript" language="javascript"
	src="assets/public/lib/laydate/laydate.js"></script>


<!-- 引入js -->
<script type="text/javascript" language="javascript"
	src="assets/staff/add.js"></script>
</head>
<body>
	<h1>添加员工信息</h1>
	<div class="container">
		<fieldset>
			<legend>添加一个员工</legend>
			<form action="staff/list" method="post">
				<button type="submit">返回表格</button>
			</form>
			<form class="staff-form" action="staff/add" method="post">
				<div>
					<label for="staffId">员工号：</label> <input type="text" name="staffId"
						id="staffId" placeholder="输入员工工号" value="${staff.staffId}">
				</div>
				<div>
					<label for="name">姓名：</label> <input type="text" name="name"
						id="name" placeholder="姓名" value="${staff.name}">
				</div>
				<div class="sex">
					<label>性别：</label>
					<div>
						<input type="radio" id="no" name="sex" value="男" checked="checked"><label
							for="no">男</label>
					</div>
					<div>
						<input type="radio" id="yes" name="sex" value="女"><label
							for="yes">女</label>
					</div>
				</div>
				<div>
					<%-- <label for=birthday>生日：</label> <input type="text" name="birthday"
						id="birthday" value="${staff.birthday}" autocomplete="off"> --%>
					<label for="birthday">撰稿日期：</label> <input type="text"
						name="birthday" id="birthday" placeholder="请输入撰稿日期"
						value="<fmt:formatDate value="${staff.birthday }" pattern="yyyy-MM-dd" />"
						autocomplete="off">

				</div>
				<div>
					<label for="salary">工资：</label> <input type="text" name="salary"
						id="salary" placeholder="工资数" value="${staff.salary}">
				</div>
				<div>
					<label for="departId">部门号：</label> <input type="text"
						name="departId" id="departId" placeholder="部门号"
						value="${staff.departId}">
				</div>
				<div>
					<label for="addressId">地址编号：</label> <input type="text"
						name="addressId" id="addressId" placeholder="部门号"
						value="${staff.addressId}">
				</div>


				<div>
					<label></label>
					<button type="submit">提交</button>
					<label></label>
					<button type="reset">重置</button>
				</div>

			</form>
		</fieldset>


	</div>
</body>
</html>