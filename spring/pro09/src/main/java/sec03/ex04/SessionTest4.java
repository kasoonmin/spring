package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sess4")
public class SessionTest4 extends HttpServlet {
	
       
   

	public void init(ServletConfig config) throws ServletException {
	
	}

	public void destroy() {

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		if(session.isNew()) {
			if(user_id !=null) {
				session.setAttribute("user_id", user_id);
				out.println("<a href='login2.html'>로그인 상태 확인</a>");
			}else {
				out.print("<a href='login2.html'>다시 로그인하세요!!</a>");
				session.invalidate();
			}
		}else {
			user_id=(String)session.getAttribute("user_id");
			if(user_id != null && user_id.length()!=0) {
				out.print("안녕하세요" + user_id + "님!!!");
			}else {
				out.print("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}
	}

}
