<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
<form method = "post" action="${contextPath }/test/login.do">
<!-- <input type = "hidden" name ="email" value="hong@test.com" />-->
<table width = "400">
<tr>
<td>아이디 <input type = "text" name="userID" size ="10"></td>
</tr>
<tr>
<td>이름 <input type = "text" name="userID" size ="10"></td>
</tr>
<tr>
<td>
<input type = "submit" value = "로그인">
<input type = "reset" value = "다시입력">
</table>
</form>
</body>
</html>