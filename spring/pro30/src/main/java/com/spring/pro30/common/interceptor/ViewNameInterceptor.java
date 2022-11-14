package com.spring.pro30.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewNameInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try {
			String viewName = getViewName(request);
			request.setAttribute("viewName", viewName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
		
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		// http://localhost:8080/member/listMember.do로 요청시
		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length(); // 전체 요청명의 길이를 구함
		}
		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");

		} else {
			end = uri.length();
		}

		// http://localhost:8080/member/listMember.do로 요청시 먼저 '.do'를 제거한다.
		// http://localhost:8080/member/listMember 를 구한 후 ,
		// 다시 http://localhost:8080/member/listMember에서 역순으로 첫번째
		// '/'위치를 구한 후, 그 뒤의 listMember를 구한다.
		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
			// 요청명에서 역순으로 최초 '.'의 위치를 구한 후, '.do'앞에까지의 문자열을 구함
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
			// 요청명에서 역순으로 최초 '/'의 위치를 구한 후 , '/' 다음부터의 문자열을 구함
		}
		return viewName;
	}

}
