<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%
    request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:redirect url="member1-2.jsp">
<c:param name="id" value="${'son' }"/>
<c:param name="pwd" value="${'1234' }"/>
<c:param name="name" value="${'손흥민' }"/>
<c:param name="email" value="${'son@test.com' }"/>
</c:redirect>
</body>
</html>