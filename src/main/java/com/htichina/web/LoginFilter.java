package com.htichina.web;

import com.htichina.web.common.ViewPage;
import com.sun.faces.util.Util;
import com.tencent.common.RandomStringGenerator;

import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

@WebFilter(urlPatterns = { "/views/*" }, dispatcherTypes = { DispatcherType.REQUEST,
		DispatcherType.FORWARD, DispatcherType.INCLUDE })
public class LoginFilter implements Filter {

	private static Logger logger = Logger.getLogger(LoginFilter.class.getName());

	public static final String CURRENT_USER = "CURRENT_USER";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*2017-10-25;Alex:优化代码，日志安全加密;CR-代码规范*/
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain fc) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		try{
			String string = httpRequest.getRequestURL().toString();
//			HttpSession session = httpRequest.getSession();
//			if(httpRequest.getMethod().equalsIgnoreCase("GET")){
//				session.setAttribute("csrftoken", RandomStringGenerator.getCSRFToken());
//			}
//			System.out.println(string);
			String uri = httpRequest.getRequestURI();
			StringBuffer Path = httpRequest.getRequestURL();
			logger.info("Path ===>"+ESAPI.encoder().encodeForHTML(Path.toString()));
			if (uri.contains(".xhtml")) {
				String facesServletMapping = getFacesMapping(httpRequest);
				// 只处理facesServletMapping为.xxx后缀的情况，不处理facesServletMapping为/xxx为前缀的情况
				if (!Util.isPrefixMapped(facesServletMapping)) {
					String servletPath = httpRequest.getServletPath();
					String[] strs = servletPath.split("xhtml");
					if(strs.length > 1) {
						String subfix = strs[0] + "xhtml";
						if (!facesServletMapping.equals(subfix)) {
							String url = subfix + (httpRequest.getQueryString() == null ? "" : "?" + httpRequest.getQueryString());
							System.out.println(url);
							request.getRequestDispatcher(url).forward(request, response);
							return;
						}
					}
				}
			}

			if (null == httpRequest.getSession().getAttribute(CURRENT_USER)) {
				if (isinterceptor(httpRequest.getRequestURL().toString(),
						"firstLoginDidi.xhtml","hornLight_help.xhtml","hornLight.xhtml","key.xhtml","location.xhtml","locationMap.xhtml","lock.xhtml","lock_help.xhtml","myAccount.xhtml","myAccount2.xhtml",
						"POCTelCheck.xhtml","unLock.xhtml","unLock_help.xhtml")) {

					StringBuffer Path1 = httpRequest.getRequestURL();
					logger.info("Path ===>>"+ESAPI.encoder().encodeForHTML(Path1.toString()));
					String x = httpRequest.getContextPath();
					logger.info("x ==++"+ESAPI.encoder().encodeForHTML(x));
					request.getRequestDispatcher("/views/accountLogin.xhtml#").forward(request, response);

				} else {
					//test code
					if(httpRequest.getRequestURL().toString().contains("accountLogin.xhtml") && request.getAttribute("orderUpgradePage")!=null){
						logger.info("LoginFilter.java....支付宝访问升级菜单,下一步进入 accountLogin.xhtml, 传递属性 orderUpgradePage="+request.getAttribute("orderUpgradePage").toString());
					}

					fc.doFilter(httpRequest, httpResponse);
				}
				return;
			}
			fc.doFilter(httpRequest, httpResponse);
		}
		catch (Exception e){
			System.out.println("-------------------21132312121231232313212312312121212"+e.getMessage());
	        logger.info("-------------------21132312121231232313212312312121212"+e.getMessage());
			httpResponse.sendRedirect("/views/common/error.xhtml");
		}



	}

	private String getFacesMapping(HttpServletRequest request) {
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		if (servletPath == null) {
			return null;
		}

		if (servletPath.length() == 0) {
			return "/*";
		}

		if (pathInfo != null) {
			return servletPath;
		} else if (servletPath.indexOf('.') < 0) {
			return servletPath;
		} else {
			return servletPath.substring(servletPath.lastIndexOf('.'));
		}
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub

	}

	private boolean isinterceptor(String url, String... segments) {
		for (String segment : segments) {
			if (url.contains(segment)) {
				return true;
			}
		}

		return false;
	}
}
