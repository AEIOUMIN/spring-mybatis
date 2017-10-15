<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Json 示例</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
function test1(){
	$.ajax({
		url:'${pageContext.request.contextPath}/json/requestKeyValue',
		data:'id=28',
		type:'post',
		success: function(result){
			alert(result.studentName);
		}
	});
}

function test2(){
	$.ajax({
		url:'${pageContext.request.contextPath}/json/requestJson',
		data:'{"id":28}',
		contentType:'application/json; charset=utf-8',
		type:'post',
		success: function(result){
			alert(result.studentName);
		}
	});
}
</script>
</head>
<body>
	<input type="button" name="btnTest" value="测试1" onclick="test1()" /><br />
	<input type="button" name="btnTest" value="测试2" onclick="test2()" />
</body>
</html>