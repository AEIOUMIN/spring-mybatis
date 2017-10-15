package com.boxy.showcase.web.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthticationInterceptor implements HandlerInterceptor {
	// 进入handler之前
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 需要放行的url
		// 没有登录
		if(request.getSession().getAttribute("username") == null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			
			dispatcher.forward(request, response);
			return false;
		}
		return true;
	}

	// 进入handler之后，返回ModelAndView之前
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandler");
	}

	// 完成handler之后
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterHandler");
	}
}
