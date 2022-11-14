<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, sec01.ex01.*" %>
    
    <%
    request.setCharacterEncoding("utf-8");
    %>
    <% 
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    MemberBean memberBean = new MemberBean(id,pwd,name,email);
    MemberDAO memberDAO = new MemberDAO();
   	memberDAO.addMember(memberBean);
   	List memberslist = memberDAO.listMembers();
    %>
    
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
if(memberslist.size() == 0){
%>
<tr>
<td>
<p>등록된 회원이 없습니다.</p>
</td>
</tr>
<%
}else{
	for(int i=0; i<memberslist.size(); i++){
		MemberBean bean = (MemberBean)memberslist.get(i);
%>
<tr align="center">
<td>
<%=bean.getId() %>
</td>
<td>
<%=bean.getPwd() %>
</td>
</tr>


</body>
</html>