<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑</title>
</head>
<body>
	<h2>编辑</h2>
	<form action="${pageContext.request.contextPath}/student/save" method="post">
		<table>
			<tr>
				<td>学号</td>
				<td>
					<input type="hidden" name="id" value="${model.id}" />
					<input type="text" id="studentNumber" name="studentNumber" value="${model.studentNumber}" />
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" id="studentName" name="studentName" value="${model.studentName}" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" id="gender" name="gender" value="${model.gender}" /></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" id="birthday" name="birthday" value="<fmt:formatDate value="${model.birthday}" pattern="yyyy-MM-dd"/>" /></td>
			</tr>
			<tr>
				<td>省份</td>
				<td><input type="text" id="province" name="province" value="${model.province}" /></td>
			</tr>
			<tr>
				<td>城市</td>
				<td><input type="text" id="city" name="city" value="${model.city}" /></td>
			</tr>
			<tr>
				<td>街道</td>
				<td><input type="text" id="street" name="street" value="${model.street}" /></td>
			</tr>
			<tr>
				<td>头像</td>
				<td>
					<img alt="" src="${pageContext.request.contextPath}/resources/upload/${model.photoUrl}" width="100" height="100"/>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="提交" /> <input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>