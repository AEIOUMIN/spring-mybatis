<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
</head>
<body>
	<h2>学生列表</h2>
	<a href="${pageContext.request.contextPath}/student/create">新增</a>
	<a href="${pageContext.request.contextPath}/logout">退出</a>
	<table>
		<tr>
			<th>ID</th>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>省份</th>
			<th>城市</th>
			<th>街道</th>
			<th>操作</th>
		</tr>
		<c:forEach var="student" items="${model.pages}" varStatus="s">
			<tr <c:if test="${s.index % 2 == 0}">style="background-color:#D0D0D0"</c:if>>
				<td>${student.id}</td>		
				<td>${student.studentNumber}</td>		
				<td>${student.studentName}</td>		
				<td>${student.gender}</td>		
				<td><fmt:formatDate value="${student.birthday}" pattern="yyyy-MM-dd"/></td>		
				<td>${student.province}</td>		
				<td>${student.city}</td>		
				<td>${student.street}</td>		
				<td>
					<a href="${pageContext.request.contextPath}/student/edit/${student.id}">编辑</a>
					<a href="${pageContext.request.contextPath}/student/delete/${student.id}" onclick="return confirm('确认删除吗？')">删除</a>
				</td>		
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/student/index/${model.first}">首页</a>|
	<a href="${pageContext.request.contextPath}/student/index/${model.prev}">上一页</a>|
	${model.pageIndex} / ${model.pageCount}
	<a href="${pageContext.request.contextPath}/student/index/${model.next}">下一页</a>|
	<a href="${pageContext.request.contextPath}/student/index/${model.last}">尾页</a>
</body>
</html>