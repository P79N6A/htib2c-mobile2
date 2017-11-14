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

import org.apache.log4j.Logger;

import com.htichina.common.web.Constant;




public class TokenCsrfFilter implements Filter {

	
	private static Logger logger = Logger.getLogger(TokenCsrfFilter.class.getName());

	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		if("POST".equalsIgnoreCase(req.getMethod())){
			String token = (String) session.getAttribute("csrftoken");
			if(token==null||!Constant.TOKENLIST.contains(token)){
				logger.info("no csrftoken");
				request.getRequestDispatcher("/views/common/error.xhtml").forward(request,response);
			}}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}
	
	
	
	

}
