package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JsonServlet3
 */
@WebServlet("/json4")
public class JsonServlet4 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject totalObject = new JSONObject(); // 배열을 최종적으로 저장할 JSONObject 객체를 생성
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = new JSONObject();
		memberInfo.put("name", "박지성");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "두개의 심장");
		membersArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "KB손해보험");
		membersArray.add(memberInfo);
		totalObject.put("members", membersArray); // 회원 정보를 저장한 배열을 배열 이름 members로 totalObject에 저장
		
		JSONArray bookArray = new JSONArray(); // JSONArray 객체를 생성.
		JSONObject bookInfo = new JSONObject();
        // JSONArray 객체를 생성한 후 책정보를 저장.
		bookInfo.put("title", "초보자를 위한 자바 프로그래밍");
		bookInfo.put("writer", "이병승");
		bookInfo.put("price", "30000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "http://localhost:8080/pro16/image/b.jpg");
		bookArray.add(bookInfo); // bookArray에 객체를 저장.
		
		bookInfo = new JSONObject();
		bookInfo.put("title", "모두의 파이썬");
		bookInfo.put("writer", "이승찬");
		bookInfo.put("price", "12000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "http://localhost:8080/pro16/image/a.jpg");
		bookArray.add(bookInfo);
		
		totalObject.put("books", bookArray); // 도서 정보를 저장한 배열을 배열이름 books로 totalObject에 저장.
		String jsonInfo = totalObject.toJSONString(); // String 포맷으로 데이터를 바꿔줌.
		System.out.println(jsonInfo);
		writer.print(jsonInfo);
	}

	
	
}