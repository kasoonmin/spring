<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.spring.ex01.*" isELIgnored="false"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.cls1{
font-size: 40px;
text-align: center;
}
</style>
</head>
<body>
<table align="center" width="100%">
<tr align="center" bgcolor="#99ccff">
<td width="7%">아이디</td>
<td width="7%">비밀번호</td>
<td width="5%">이름</td>
<td width="11%">이메일</td>
<td width="5%">가입일</td>
</tr>

<c:forEach var="member" items="${membersList }">
<tr align = "center">
<td>${member.id }</td>
<td>${member.pwd }</td>
<td>${member.name }</td>
<td>${member.email }</td>
<td>${member.joinDate }</td>
</tr>
</c:forEach>


</table>
<a href="${contextPath }/member/memberForm.do"><h1 style="text-align:center">회원가입</h1></a>
</body>
</html>