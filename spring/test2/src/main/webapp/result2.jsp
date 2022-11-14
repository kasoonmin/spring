<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>결과창</title>
</head>
<body>
<%
   String userID = request.getParameter("userID" );
   if(userID.length()==0){
  %>
   <jsp:getProperty  page="login.jsp" />
<%	
  }
%>
  <h1>환영합니다   5번 님!! </h1>
</body>
</html>