package com.htichina.web.security;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;

public class CsrfFilter implements Filter {
		private static final Logger logger = LogManager.getLogger(CsrfFilter.class);

		// 白名单
		private List<String> whiteUrls;

		private int size = 0;

		public void init(FilterConfig filterConfig) {
			// 读取文件
			String path = CsrfFilter.class.getResource("/").getFile();
			whiteUrls = readFile(path + "csrfWhite.txt");
			size = null == whiteUrls ? 0 : whiteUrls.size();
		}

		/*2017-10-25;Alex:优化代码，日志安全加密;CR-代码规范*/
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			
			try {
				HttpServletRequest req = (HttpServletRequest) request;
				HttpServletResponse res = (HttpServletResponse) response;
				//res.setHeader("Server", "verizon");
				
				//req.setCharacterEncoding("UTF-8");
				//res.setCharacterEncoding("UTF-8");
				// 获取请求url地址
				String url = req.getRequestURL().toString();
				String referurl = req.getHeader("Referer");
			    
//				logger.info("referurl----->" + ESAPI.encoder().encodeForHTML(referurl));
				String serverAddr = isWhiteReq(referurl);
//				logger.info("mod referurl----->" + ESAPI.encoder().encodeForHTML(serverAddr));
				if (serverAddr!=null) {
					//res.setHeader("Referer","http://"+serverAddr);
					chain.doFilter(request, response);
				} else {
					//res.setStatus(403);
					

					// 记录跨站请求日志
					String log = "";
					String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
					String clientIp = getRemoteHost(req);

					log = clientIp + "||" + date + "||" + referurl + "||" + url;
					//logger.warn(ESAPI.encoder().encodeForHTML(log));
					System.out.println("error------log:"+log);
					System.out.println("error------uri:"+req.getRequestURI());
					
					logger.info("error------log:"+log);
					logger.info("error------uri:"+req.getRequestURI());
					req.getRequestDispatcher("views/common/error.xhtml").forward(req, res);
					return;
				}

			} catch (Exception e) {
				logger.error("doFilter eception", e);
			}

		}

		/*
		 * 判断是否是白名单
		 */
		private String isWhiteReq(String referUrl) {
			if (referUrl == null || "".equals(referUrl) || size == 0) {
				return "";
			} else {
				String refHost = "";
				referUrl = referUrl.toLowerCase();
				if (referUrl.startsWith("http://")) {
					refHost = referUrl.substring(7);
				} else if (referUrl.startsWith("https://")) {
					refHost = referUrl.substring(8);
				}

				for (String urlTemp : whiteUrls) {
					if (refHost.indexOf(urlTemp.toLowerCase()) > -1) {
						return urlTemp;
					}
				}
			}

			return null;
		}

		public void destroy() {
		}

		/*2017-10-25;Alex:优化代码，关闭IO等流;CR-代码规范*/
		private List<String> readFile(String fileName) {
			List<String> list = new ArrayList<String>();
			BufferedReader reader = null;
			FileInputStream fis = null;
			InputStreamReader ip_reader = null;
			try {
				File f = new File(fileName);
				if (f.isFile() && f.exists()) {
					fis = new FileInputStream(f);
					ip_reader = new InputStreamReader(fis, "UTF-8");
					reader = new BufferedReader(ip_reader);
					String line;
					while ((line = reader.readLine()) != null) {
						if (!"".equals(line)) {
							list.add(line);
						}
					}
				}
			} catch (Exception e) {
				logger.error("readFile", e);
			} finally {
				try {
					if (reader != null) {
						reader.close();
					}
				} catch (IOException e) {
					logger.error("InputStream关闭异常", e);
				}
				try {
					if (ip_reader != null) {
						ip_reader.close();
					}
				} catch (IOException e) {
					logger.error("InputStreamReader关闭异常", e);
				}
				try {
					if (fis != null) {
						fis.close();
					}
				} catch (IOException e) {
					logger.error("FileInputStream关闭异常", e);
				}
			}
			return list;
		}

		
		public String getRemoteHost(javax.servlet.http.HttpServletRequest request){
		    String ip = request.getHeader("x-forwarded-for");
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
		        ip = request.getHeader("Proxy-Client-IP");
		    }
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
		        ip = request.getHeader("WL-Proxy-Client-IP");
		    }
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
		        ip = request.getRemoteAddr();
		    }
		    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
		}
	

	
	}


