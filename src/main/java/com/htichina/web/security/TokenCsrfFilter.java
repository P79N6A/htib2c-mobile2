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

			//logger.info("-------------------------------------uri1:"+uri);
			if(uri!=null && !passWithoutValidation(uri)){							
		 
				
			   // 从 HTTP 头中取得 csrftoken 
			   String xhrToken = req.getHeader(Constant.CSRFTOKEN); 
			  
			   // 从请求参数中取得 csrftoken 
			   String pToken = req.getParameter(Constant.CSRFTOKEN); 
			   if(sToken != null && xhrToken != null && sToken.equals(xhrToken)){ 
			       chain.doFilter(request, response); 
			   //}else if(sToken != null && pToken != null && sToken.equals(pToken)){ 
			  } else if(Constant.TOKENLIST.contains(pToken)){
//				   logger.info("-------------------------------------uri2:"+uri);
			       chain.doFilter(request, response); 
			   } else{ 
//				   logger.info("-------------------------------------uri3:"+uri);
				   logger.info("-------------------------------------session token:"+sToken);
//				   logger.info("-------------------------------------parameter token:"+pToken);				  
				   request.getRequestDispatcher("/views/common/error.xhtml").forward(request,response); 
			   } 
			}else{
				//logger.info("-------------------------------------uri4:"+uri);
				 chain.doFilter(request, response); 
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}
	
	
	private static boolean  passWithoutValidation (String uri){
		if(uri.contains("index.xhtml")||
		   uri.contains("wechatServlet")||
		   uri.contains("notifyServlet")|| 
		   uri.contains("firstLoginDidi.xhtml")||
		   uri.contains("myAccount.xhtml")||
		   uri.contains("myAccount2.xhtml")||
		   uri.contains("invoiceEntry.xhtml")||
		   uri.contains("faq.xhtml")||
		   
		   uri.contains("orderEntry.xhtml")||
		  
		   uri.contains("key.xhtml")||
		   uri.contains("violationInquiry.xhtml")||
		  
		   uri.contains("orderInstruction.xhtml")||
		   uri.contains("termsOfService.xhtml")||
		  
		   uri.contains("loginAuth.html")||
		   uri.contains("alipayCallback.do")||
		   uri.contains("alipayapi.jsp")||
		   
		   uri.contains("faqAlipay.xhtml")||
		   uri.contains("orderAlipayInstruction.xhtml")||
		   uri.contains("termsOfService.pdf")||
		   uri.contains("newFollowDidi.xhtml")||
           
		   uri.contains("WechatLocateServlet")||
		   uri.contains("QuestionnaireDataServlet")||
		   uri.contains("QuestionnaireSaveServlet")||
		   uri.contains("LuckyDraw2Servlet")||
		   uri.contains("LuckyDraw2DataServlet")||
		   uri.contains("orderFailed.xhtml")||
		   uri.contains("luckyDraw.xhtml")||
		   uri.contains("luckyDraw2.xhtml")||
		   uri.contains("luckyDrawLogin.xhtml")||
		   uri.contains("luckyDrawPackage.xhtml")||
		   uri.contains("luckyDrawErrer.xhtml")||
		   uri.contains("luckyDrawContinue.xhtml")||
		   uri.contains("luckyDrawOver.xhtml")||
		   uri.contains("accountLogin.xhtml")||
		   uri.contains("orderSuccess.xhtml")||
		   uri.contains("updateNewCellPhone.xhtml")||
		   uri.contains("variflight.xhtml")||
		   uri.contains("location_help.xhtml")||
		   uri.contains("hornLight_help.xhtml")||
		   uri.contains("lock_help.xhtml")||
		   uri.contains("unlock_help.xhtml")||
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
