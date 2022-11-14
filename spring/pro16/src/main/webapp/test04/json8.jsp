<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value = "${pageContext.request.contextPath }"/>
    <%
    request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 테스트3</title>
	<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script>
		$(function (){
			$("#checkJson").click(function(){
				$.ajax({
					type: "post",
					async: false, 
		            url: "${contextPath}/json4",
					success: function (data, textStatus){
						var jsonInfo = JSON.parse(data);
						var memberInfo = "회원정보<br>";
						memberInfo += "======<br>"
						for(var i in jsonInfo.members){ // 배열이름 members로 회원 정보를 출력.
							memberInfo += "이름 : " + jsonInfo.members[i].name + "<br>";
							memberInfo += "나이 : " + jsonInfo.members[i].age + "<br>";
							memberInfo += "성별 : " + jsonInfo.members[i].gender + "<br>";
							memberInfo += "별명 : " + jsonInfo.members[i].nickname + "<br><br><br>";
						}
						var booksInfo = "<br><br><br>도서 정보";
						booksInfo += "==========<br>";
						for(var i in jsonInfo.books){
							memberInfo += "제목 : " + jsonInfo.books[i].title + "<br>";
							memberInfo += "저자 : " + jsonInfo.books[i].writer + "<br>";
							memberInfo += "가격 : " + jsonInfo.books[i].price + "원 <br>";
							memberInfo += "장르 : " + jsonInfo.books[i].genre + "<br>";
                            // 이미지 URL을 구해 <img> 태그의 src속성에 설정.
							imageURL = jsonInfo.books[i].image;
							booksInfo += "<img src=" + imageURL + "/>" +"<br><br><br>";
						}
						$("#output").html(memberInfo + "<br>" + booksInfo);
					},
					error: function(data, textStatus){
						alert("에러가 발생했습니다.");
					}
				});
			});
		});
	</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">데이터 수신하기</a><br><br>
    <div id="output"></div>
</body>
</html>