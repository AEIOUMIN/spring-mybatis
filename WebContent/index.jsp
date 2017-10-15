<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RESTful 风格</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
function detailsStudent(){
	var id = $("#id").val();
	
	$.ajax({
		url:'${pageContext.request.contextPath}/rest/'+id,
		type:'GET',
		success: function(result){
			alert(result.studentName);	
		}
	});
}

function deleteStudent(){
	var id = $("#id").val();
	
	$.ajax({
		url:'${pageContext.request.contextPath}/rest/'+id,
		type:'DELETE',
		success: function(result){
			alert(result.message);	
		}
	});
}
</script>
</head>
<body>
	<input type="text" id="id" name="id" /><br />
	<input type="button" name="btnDetails" value="查询" onclick="detailsStudent()" /><br />
	<input type="button" name="btnDelete" value="删除" onclick="deleteStudent()" />
</body>
</html>