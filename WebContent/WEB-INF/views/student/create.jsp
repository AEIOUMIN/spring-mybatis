<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
</head>
<body>
	<h2>新增</h2>
	<form:form modelAttribute="student" action="${pageContext.request.contextPath}/student/save" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>学号</td>
				<td>
					<form:input path="studentNumber"/>
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>
					<form:input path="studentName"/>
					<form:errors path="studentName"></form:errors>
				</td>
			</tr>			
			<tr>
				<td>性别</td>
				<td>
					<form:input path="gender" />
					<form:errors path="gender"></form:errors>
				</td>
			</tr>			
			<tr>
				<td>生日</td>
				<td>
					<form:input path="birthday" />
				</td> 
			</tr>			
			<tr>
				<td>省份</td>
				<td>
					<form:select path="province" items="${provinces}"></form:select>
				</td>
			</tr>			
			<tr>
				<td>城市</td>
				<td>
					<form:input path="city" />
				</td>
			</tr>			
			<tr>
				<td>街道</td>
				<td>
					<form:input path="street" />
				</td>
			</tr>	
			<tr>
				<td>头像</td>
				<td>
					<input type="file" name="photo" />
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value="提交" />
					<input type="reset" value="重置" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<form:errors path="*"></form:errors>
				</td>
			</tr>			
		</table>
	</form:form>
</body>
</html>