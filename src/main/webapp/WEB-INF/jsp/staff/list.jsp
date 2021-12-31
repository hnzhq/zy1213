<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--   引入标签库   -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 固定写法,获取应用上下文路径，可用于获取css的位置 -->
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
<!-- 标记，整个页面的所有路径都基于这一个相对路径 -->
<base href="${ctx }/">
<meta charset="UTF-8">
<title>秦山商品批发详情表</title>
<link rel="stylesheet" type="text/css" href="assets/staff/list.css">
<!-- 引入jquery -->
<script type="text/javascript" language="javascript"
	src="assets/public/lib/jquery/jquery-3.6.0.min.js"></script>
<!-- 引入layer 用于弹出框-->
<script type="text/javascript" language="javascript"
	src="assets/public/lib/layer/layer.js"></script>
<script type="text/javascript" language="javascript"
	src="assets/public/lib/laydate/laydate.js"></script>


<script type="text/javascript">
	var ctx = "${ctx}";//客户端可看应用上下文
	var pageNo = "${pi.pageNum}";//当前页
	var pages = "${pi.pages}";//总页数
	var pageSize = "${pi.pageSize}";//页面大小
	var error = "${error}";//页面错误信息
</script>
<script type="text/javascript" language="javascript"
	src="assets/staff/list.js"></script>
</head>
<body>

	<div class="container">
		<h1>员工管理</h1>
		<!-- 创建表单区域，可以向后台提交数据 -->
		<div class="search-form">
			<fieldset>
				<legend>查询条件</legend>
				<form action="staff/list" method="post">
					<div>
						<label for="id">编号：</label><input type="text" name="id" id="id"
							placeholder="请输入编号" value="${gsb.id }">
					</div>
					<div>
						<label for="staffId">员工号：</label><input type="text" name="staffId"
							id="staffId" placeholder="请输入员工号" value="${gsb.staffId }">
					</div>
					<div>
						<label for="name">员工名：</label><input type="text" name="name"
							id="name" placeholder="请输入员工名" value="${gsb.name }">
					</div>
					<div>
						<label for="sex">员工性别：</label><input type="text"
							name="sex" id="sex" placeholder="员工性别">
					</div>

					<div>
						<label for="birthdayRange">出生日期：</label><input type="text"
							name="birthdayRange" id="birthdayRange" placeholder="请输入员工生日范围"
							autocomplete="off">
					</div>
					

					<!-- 页码 -->
					<input type="hidden" id = "pageNo" name="pageNo" />
					<!-- 页面大小 -->
					<input type="hidden" id = "pageSize" name="pageSize" value="${pi.pageSize }" />
				</form>
			</fieldset>
		</div>


		<!-- 删除表单功能 -->
		<div class="delete-form">
			<form action="staff/delete" method="post">
				<!-- 批量删除操作 -->
				<input type="hidden" name="deleteIds" />
			</form>
		</div>




		<!-- 按钮 -->
		<div class="op">
			<ul>
				<li><a href="javascript:void(0)" class="add">添加</a></li>
				<li><a href="javascript:void(0)" class="edit">修改</a></li>
				<li><a href="javascript:void(0)" class="search">查询</a></li>
				<!-- <li><a href="javascript:void(0)" class="del">删除</a></li> -->
				<li><a href="javascript:void(0)" class="ajax-del">删除</a></li>
			</ul>
		</div>
		<div class="data">
			<table class="tab">
				<thead>
					<tr>
						<th><input type="checkbox" id="checkall"></th>
						<th>编号</th>
						<th>员工号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>出生日期</th>
						<th>薪水</th>
						<!-- <th>部门编号</th> -->
						<th>部门名称</th>
						<th>居住地址</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${staffs }" var="sta">
						<tr>
							<td><input type="checkbox"></td>
							<td data-portrait="${sta.picture }">${sta.id }</td>
							<td>${sta.staffId }</td>
							<td>${sta.name }</td>
							<td>${sta.sex }</td>
							<td>${sta.localBirthday }</td>
							<td>${sta.salary }</td>
							<%-- <td>${sta.departId }</td> --%>
							<td>${sta.depart.name }</td>
							<td>${sta.address.name }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 分页 -->
	<div class="paginate">
		<span class="first"><a>首页</a></span> <span class="prev"><a>上一页</a></span>

		<!-- 数字页码 -->
		<ul>
			<c:forEach begin="${pi.navigateFirstPage }" end="${pi.navigateLastPage }"
				var="p">
				<c:choose>
					<c:when test="${p == pageNum }">
						<li class="current"><a href="javascript:void(0)">${p }</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="javascript:void(0)">${p }</a></li>
					</c:otherwise>
				</c:choose>

			</c:forEach>
		</ul>

		<span class="next"><a>下一页</a></span> <span class="last"><a>尾页</a></span>
		<select>
			<option value="8">8</option>
			<option value="12">12</option>
			<option value="17">17</option>
			<option value="20">20</option>
			<option value="30">30</option>

		</select>
	</div>
	</div>



</body>
</html>