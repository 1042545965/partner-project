package com.partner.config.interceptor;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.constant.PartnerUserConstants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * preHandle是请求执行前执行的，
 * postHandler是请求结束执行的，但只有preHandle方法返回true的时候才会执行。
 * afterCompletion是视图渲染完成后才执行，同样需要preHandle返回true，该方法通常用于清理资源等工作
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{
 
	//目标方法执行之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 Object user = request.getSession().getAttribute(PartnerUserConstants.PARAMETER_SESSION_KEY);
	      if(user == null){
	          //未登录
			  response.sendRedirect("/index/login");
	          return false;
	      }else {
	          return true;
	      }
 
	}
 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	
	}
	
	
}