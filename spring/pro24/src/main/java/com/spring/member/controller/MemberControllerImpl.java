package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.*;
import com.spring.member.service.MemberServiceImpl;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController{
	private MemberService memberService;
	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}
	
	
	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
		/*
		 * String id= request.getParameter("id");
		 * String pwd= request.getParameter("pwd");
		 * String name= request.getParameter("name");
		 * String email= request.getParameter("email");
		 * memberVO.setId(id);
		 * memberVO.setpwd(pwd);
		 * memberVO.setname(name);
		 * memberVO.setemail(email);
		 */
		bind(request,memberVO);
		int result = 0;
		result = memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	@Override
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception{
		String contextPath = request.getContextPath();
		String uri =(String)request.getAttribute("javax.servlet.include.request_uri");
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		//http://localhost:8090/member/listMember.do로 요청시
		int begin = 0;
		if(!((contextPath==null)||("".equals(contextPath)))){
			begin = contextPath.length(); // 전체 요청명의 길이를 구함			
		}
		int end;
		if(uri.indexOf(",")!=-1) {
			end=uri.indexOf(";");
		}else if(uri.indexOf("?")!=-1) {
			end=uri.indexOf("?");
			
		}else {
			end=uri.length();
		}
		
		//http://localhost:8090/member/listMember.do로 요청시 먼저 '.do'를 제거한다.
		//http://localhost:8090/member/listMember 를 구한 후 ,
		//다시 http://localhost:8090/member/listMember에서 역순으로 첫번째
		// '/'위치를 구한 후, 그 뒤의 listMember를 구한다.
		String fileName=uri.substring(begin,end);
		if(fileName.indexOf(".")!=-1) {
			fileName=fileName.substring(0,fileName.lastIndexOf("."));
			//요청명에서 역순으로 최초 '.'의 위치를 구한 후, '.do'앞에까지의 문자열을 구함
		}
		if(fileName.lastIndexOf("/")!=-1) {
			fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
			//요청명에서 역순으로 최초 '/'의 위치를 구한 후 , '/' 다음부터의 문자열을 구함
		}
		return fileName;
		}						

}
