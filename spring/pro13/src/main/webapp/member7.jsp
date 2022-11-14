<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*" %>
    
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    
    <jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"/>
    <jsp:setProperty name="m" property="*"/>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<table>
<tr>
<td>
<jsp:getProperty property = "id" name="m" />
</td>
<td>
<jsp:getProperty property = "pwd" name="m" />
</td>
<td>
<jsp:getProperty property = "name" name="m" />
</td>
<td>
<jsp:getProperty property = "email" name="m" />
</td>
</table>

<jsp:usebean id="m" class="sec01.ex01.MemverBean" scope="page"/>
<jsp:setProperty name="m" property="*"/>

<jsp:getProperty property="id" name="m" 