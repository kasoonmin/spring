package sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MemberDAO memberDAO;
  
   
	public void init(ServletConfig config) throws ServletException {
		memberDAO=new MemberDAO();
	}


	public void destroy() {
	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
	    String pwd=request.getParameter("pwd");
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");
	    MemberVO m = new MemberVO(id, pwd, name, email);
	    MemberDAO memberDAO = new MemberDAO();
	    memberDAO.addMember(m);	   
		List membersList = memberDAO.listMembers();
		request.setAttribute("membersList",membersList);
		RequestDispatcher dispatch = request.getRequestDispatcher("listMembers.jsp");
		dispatch.forward(request, response);
	}
}
