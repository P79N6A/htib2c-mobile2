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

import com.alipay.api.internal.util.StringUtils;
import com.htichina.common.web.Constant;
import com.htichina.web.util.UUIDUtils;
import com.tencent.common.RandomStringGenerator;




public class TokenCsrfFilter implements Filter {

	private static Logger logger = Logger.getLogger(TokenCsrfFilter.class.getName());

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
		String sToken = (String)session.getAttribute(Constant.CSRFTOKEN); 
		String uri =req.getRequestURI();
		
		
		
		if(StringUtils.isEmpty(sToken) ){ 
		 
		   // 产生新的 token 放入 session 中
		   //sToken = UUIDUtils.uuid()+UUIDUtils.uuid()+UUIDUtils.uuid();
			
		   sToken = RandomStringGenerator.getCSRFToken();
		   session.setAttribute(Constant.CSRFTOKEN,sToken); 
		   
		   chain.doFilter(request, response); 
		} else{ 
			
			 logger.info("-------------------------------------uri1:"+uri);
			if(uri!=null && !passWithoutValidation(uri)){
				
			
		       // 从 HTTP 头中取得 csrftoken 
			   String xhrToken = req.getHeader(Constant.CSRFTOKEN); 
			 
			   // 从请求参数中取得 csrftoken 
			   String pToken = req.getParameter(Constant.CSRFTOKEN); 
			   if(sToken != null && xhrToken != null && sToken.equals(xhrToken)){ 
			       chain.doFilter(request, response); 
			   //}else if(sToken != null && pToken != null && sToken.equals(pToken)){ 
			  } else if(Constant.TOKENLIST.contains(pToken)){
				   logger.info("-------------------------------------uri2:"+uri);
			       chain.doFilter(request, response); 
			   } else{ 
				   logger.info("-------------------------------------uri3:"+uri);
				   logger.info("-------------------------------------session token:"+sToken);
				   logger.info("-------------------------------------parameter token:"+pToken);
				  
				   request.getRequestDispatcher("/views/common/error.xhtml").forward(request,response); 
			   } 
			}else{
				logger.info("-------------------------------------uri4:"+uri);
				 chain.doFilter(request, response); 
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}
	
	
	private static boolean  passWithoutValidation (String uri){
		//orderEntry.xhtml   promotion.xhtml invoiceEntry.xhtml key.xhtml violationInquiry.xhtml
		if(uri.contains("index.xhtml")||
		   uri.contains("wechatServlet")||
		   uri.contains("notifyServlet")|| 
		   uri.contains("firstLoginDidi.xhtml")||
		   uri.contains("myAccount.xhtml")||
		   uri.contains("invoiceEntry.xhtml")||
		   uri.contains("faq.xhtml")||
		   
		   uri.contains("orderEntry.xhtml")||
		  
		   uri.contains("key.xhtml")||
		   uri.contains("violationInquiry.xhtml")||
		  
		   uri.contains("orderInstruction.xhtml")||
		   uri.contains("termsOfService.xhtml")||
		  
		   uri.contains("loginAuth.html")||
		   uri.contains("alipayCallback.do")||
		   
		   
		   uri.contains(".css") || 
		   uri.contains(".js") || 
		   uri.contains(".ecss") || 
		   uri.contains(".png")||
		   uri.contains(".ico")||
		   uri.contains(".jpg")||
		   uri.contains(".gif")){
			return true;
		}  
		return false;
		
	}
	
	
	
	

}
