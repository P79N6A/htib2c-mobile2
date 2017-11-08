package com.htichina.web.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.htichina.web.util.UUIDUtils;

public class TokenCsrfFilter implements Filter {

	public static final String CSRFTOKEN = "csrftoken";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request; 
		HttpSession session = req.getSession(); 
		 
		// 从 session 中得到 csrftoken 属性
		String sToken = (String)session.getAttribute(CSRFTOKEN); 
		if(sToken == null){ 
		 
		   // 产生新的 token 放入 session 中
		   sToken = UUIDUtils.uuid()+UUIDUtils.uuid()+UUIDUtils.uuid();
		   session.setAttribute(CSRFTOKEN,sToken); 
		   chain.doFilter(request, response); 
		} else{ 
		 
		   // 从 HTTP 头中取得 csrftoken 
		   String xhrToken = req.getHeader(CSRFTOKEN); 
		 
		   // 从请求参数中取得 csrftoken 
		   String pToken = req.getParameter(CSRFTOKEN); 
		   if(sToken != null && xhrToken != null && sToken.equals(xhrToken)){ 
		       chain.doFilter(request, response); 
		   }else if(sToken != null && pToken != null && sToken.equals(pToken)){ 
		       chain.doFilter(request, response); 
		   }else{ 
		       request.getRequestDispatcher("/views/common/error.xhtml").forward(request,response); 
		   } 
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
