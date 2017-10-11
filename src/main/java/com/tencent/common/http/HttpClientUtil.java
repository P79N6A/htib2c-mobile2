package com.tencent.common.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.owasp.esapi.ESAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtil {
	private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

	public static HttpResponse doSSLPost(String url, Map<String, String> headers, String body, String charset, StringBuffer responseStr) {
		HttpResponse httpResponse = null;
			try {
				TrustManager[] tm = {truseAllManager};
				SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
				sslContext.init(null, tm, new java.security.SecureRandom());
				// 创建HttpClientBuildern
				HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
				httpClientBuilder.setSslcontext(sslContext);
				httpClientBuilder.setHostnameVerifier(hostnameVerifier);
				
				CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

			HttpPost httpPost = new HttpPost(url);
			if (headers != null) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
					httpPost.addHeader(header.getKey(), header.getValue());
				}
			}
			httpPost.setEntity(new StringEntity(body, charset));
			log.debug(" >> \"Post "+ "\"");
			log.debug(" >> \"Accept : "+ ESAPI.encoder().encodeForHTML(headers.get("Accept"))+"\"");
			log.debug(" >> \"Content-Type : " + ESAPI.encoder().encodeForHTML(headers.get("Content-Type"))+"\"");
			log.debug(" >> \"Authorization : " + ESAPI.encoder().encodeForHTML(headers.get("Authorization"))+"\"");
			log.debug(" >> \"" + ESAPI.encoder().encodeForHTML(body)+"\"");
			log.debug(" >> \"Host : " + ESAPI.encoder().encodeForHTML(url)+"\"");
			httpResponse = closeableHttpClient.execute(httpPost);
			if(httpResponse.getStatusLine() != null){
				log.debug(" << \"status:" + ESAPI.encoder().encodeForHTML(httpResponse.getStatusLine().toString())+"\"");
			}
			HeaderIterator iterator = httpResponse.headerIterator();
			while (iterator.hasNext()) {
				log.debug(" << \t\"" + ESAPI.encoder().encodeForHTML(iterator.next().toString())+" \"");
			}
			HttpEntity httpEntity = httpResponse.getEntity();
			if (responseStr != null && httpEntity != null) {
				// 响应内容
				responseStr.append(EntityUtils.toString(httpEntity));
			}
			log.debug(" << \"response:" + ESAPI.encoder().encodeForHTML(responseStr.toString())+" \"");
			closeableHttpClient.close();
		} catch (Exception e) {
			log.error(" << \"doSSLPost error:", ESAPI.encoder().encodeForHTML(e.toString())+" \"");
		}
		return httpResponse;
	}
	
	public static String doSSLPost(String url, Map<String, String> headers, String body, String charset) {
		StringBuffer responseStr = new StringBuffer();
		HttpClientUtil.doSSLPost(url, headers, body, charset, responseStr);
		return responseStr.toString();
	}
	
	public static HttpResponse doSSLPut(String url, Map<String, String> headers, String body, String charset, StringBuffer responseStr) {
		HttpResponse httpResponse = null;
		try {
			TrustManager[] tm = {truseAllManager};
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 创建HttpClientBuilder
			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
			httpClientBuilder.setSslcontext(sslContext);
			httpClientBuilder.setHostnameVerifier(hostnameVerifier);
			
			CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
			
			HttpPut httpPut = new HttpPut(url);
			if (headers != null) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
					httpPut.addHeader(header.getKey(), header.getValue());
				}
			}
			httpPut.setEntity(new StringEntity(body, charset));
			log.debug(" >> \"Put "+ "\"");
			log.debug(" >> \"Accept : "+ ESAPI.encoder().encodeForHTML(headers.get("Accept"))+"\"");
			log.debug(" >> \"Content-Type : " + ESAPI.encoder().encodeForHTML(headers.get("Content-Type"))+"\"");
			log.debug(" >> \"Authorization : " + ESAPI.encoder().encodeForHTML(headers.get("Authorization"))+"\"");
			log.debug(" >> \"" + ESAPI.encoder().encodeForHTML(body)+"\"");
			log.debug(" >> \"Host : " + ESAPI.encoder().encodeForHTML(url)+"\"");
			
			httpResponse = closeableHttpClient.execute(httpPut);
			if(httpResponse.getStatusLine() != null){
				log.debug(" << \"status:" + ESAPI.encoder().encodeForHTML(httpResponse.getStatusLine().toString())+"\"");
			}

			HeaderIterator iterator = httpResponse.headerIterator();
			while (iterator.hasNext()) {
				log.debug(" << \t\"" + ESAPI.encoder().encodeForHTML(iterator.next().toString())+"\"");
			}
			HttpEntity httpEntity = httpResponse.getEntity();
			if (responseStr != null && httpEntity != null) {
				// 响应内容
				responseStr.append(EntityUtils.toString(httpEntity));
			}
			log.debug("<< \"response:" + ESAPI.encoder().encodeForHTML(responseStr.toString())+"\"");
			closeableHttpClient.close();
		} catch (Exception e) {
			log.error("<< \"doSSLPost error:", ESAPI.encoder().encodeForHTML(e.toString())+"\"");
		}
		return httpResponse;
	}
	
	public static String doSSLPut(String url, Map<String, String> headers, String body, String charset) {
		StringBuffer responseStr = new StringBuffer();
		HttpClientUtil.doSSLPut(url, headers, body, charset, responseStr);
		return responseStr.toString();
	}

	public static String doSSLGet(String url, Map<String, String> headers, String charset) {
		String response = "";
		try {
			TrustManager[] tm = {truseAllManager};
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 创建HttpClientBuilder
			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
			httpClientBuilder.setSslcontext(sslContext);
			httpClientBuilder.setHostnameVerifier(hostnameVerifier);
			
			CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

			HttpGet httpGet = new HttpGet(url);
			if (headers != null) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
					httpGet.addHeader(header.getKey(), header.getValue());
				}
			}
			log.debug(" >> \"Get "+ "\"");
			log.debug(" >> \"Accept : "+ ESAPI.encoder().encodeForHTML(headers.get("Accept"))+"\"");
			log.debug(" >> \"Content-Type : " + ESAPI.encoder().encodeForHTML(headers.get("Content-Type"))+"\"");
			log.debug(" >> \"Authorization : " + ESAPI.encoder().encodeForHTML(headers.get("Authorization"))+"\"");
			log.debug(" >> \"Host : " + ESAPI.encoder().encodeForHTML(url)+"\"");
			HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
			if(httpResponse.getStatusLine() != null){
				log.debug(" << \"status:" + ESAPI.encoder().encodeForHTML(httpResponse.getStatusLine().toString())+"\"");
			}

			HeaderIterator iterator = httpResponse.headerIterator();
			while (iterator.hasNext()) {
				log.debug("\t << \"" + ESAPI.encoder().encodeForHTML(iterator.next().toString()) + " \"");
			}

			HttpEntity httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				// 响应内容
				response = EntityUtils.toString(httpEntity, charset);
			}
			log.debug(" << \" response:" + ESAPI.encoder().encodeForHTML(response) +" \"");
			closeableHttpClient.close();
		} catch (Exception e) {
			log.error(" << \" doSSLGet error:", ESAPI.encoder().encodeForHTML(e.toString()) +" \"");
		}
		return response;
	}

	public static boolean doDownloadFile(String url, String toFile) {
		boolean result = false;
		try {
			// 创建HttpClientBuilder
			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
			CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

			HttpGet httpGet = new HttpGet(url);
			log.debug("url:" + ESAPI.encoder().encodeForHTML(url.toString()));
			HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
			log.debug("status:" + ESAPI.encoder().encodeForHTML(httpResponse.getStatusLine().toString()));
			log.debug("headers:");
			HeaderIterator iterator = httpResponse.headerIterator();
			while (iterator.hasNext()) {
				log.debug("\t" + ESAPI.encoder().encodeForHTML(iterator.next().toString()));
			}

			if (HttpStatus.SC_OK == httpResponse.getStatusLine().getStatusCode()) {
				HttpEntity httpEntity = httpResponse.getEntity();
				if (httpEntity != null) {
					// 响应内容
					File targetFile = new File(toFile);
					FileOutputStream output = new FileOutputStream(targetFile);
					output.write(EntityUtils.toByteArray(httpEntity));
					output.flush();
					output.close();
				}
			}
			closeableHttpClient.close();
			result = true;
		} catch (Exception e) {
			log.error("doSSLGet error:", ESAPI.encoder().encodeForHTML(e.toString()));
		}
		return result;
	}

	public static String doFormPost(String url, Map<String, String> headers, Map<String, String> paras, String charset) {
		String response = "";
		try {
			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
			CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

			HttpPost httpPost = new HttpPost(url);
			if (headers != null) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
					httpPost.addHeader(header.getKey(), header.getValue());
				}
			}

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			if (paras != null) {
				for (Map.Entry<String, String> para : paras.entrySet()) {
					nvps.add(new BasicNameValuePair(para.getKey(), para.getValue()));
				}
			}
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, charset));

			log.debug("url:" + ESAPI.encoder().encodeForHTML(url));
			HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
			if(httpResponse.getStatusLine() != null){
				log.debug("status:" + ESAPI.encoder().encodeForHTML(httpResponse.getStatusLine().toString()));
			}

			log.debug("headers:");
			HeaderIterator iterator = httpResponse.headerIterator();
			while (iterator.hasNext()) {
				log.debug("\t" + ESAPI.encoder().encodeForHTML(iterator.next().toString()));
			}

			HttpEntity httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				// 响应内容
				response = EntityUtils.toString(httpEntity, charset);
			}
			closeableHttpClient.close();
		} catch (Exception e) {
			log.error("doSSLPost error:", ESAPI.encoder().encodeForHTML(e.toString()));
		}
		return response;
	}

	public static String doFileUpload(String url, Map<String, String> headers, String fileName, String charset) {
		String response = "";
		try {
			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
			CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

			HttpPost httpPost = new HttpPost(url);
			if (headers != null) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
					httpPost.addHeader(header.getKey(), header.getValue());
				}
			}
			MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
			multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			multipartEntityBuilder.setCharset(Charset.forName(charset));
			multipartEntityBuilder.addBinaryBody("filename", new File(fileName));
			// 生成 HTTP 实体
			HttpEntity reqEntity = multipartEntityBuilder.build();
			httpPost.setEntity(reqEntity);

			log.debug("url:" + ESAPI.encoder().encodeForHTML(url));
			HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
			if(httpResponse.getStatusLine() != null){
				log.debug("status:" + ESAPI.encoder().encodeForHTML(httpResponse.getStatusLine().toString()));
			}

			log.debug("headers:");
			HeaderIterator iterator = httpResponse.headerIterator();
			while (iterator.hasNext()) {
				log.debug("\t" + ESAPI.encoder().encodeForHTML(iterator.next().toString()));
			}

			HttpEntity httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				// 响应内容
				response = EntityUtils.toString(httpEntity, charset);
			}
			closeableHttpClient.close();

		} catch (Exception e) {
			log.error("doFileUpload error:", ESAPI.encoder().encodeForHTML(e.toString()));
		}
		return response;
	}

	private static TrustManager truseAllManager = new X509TrustManager() {
		public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

	};

	// 这个是HOST验证
	private static X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier() {
		public boolean verify(String arg0, SSLSession arg1) {
			return true;
		}
		public void verify(String arg0, SSLSocket arg1) throws IOException {
		}
		public void verify(String arg0, String[] arg1, String[] arg2) throws SSLException {
		}
		public void verify(String arg0, X509Certificate arg1) throws SSLException {
		}
	};
	
	
	
	
	public static void main(String[] args) {

		System.out.println(doSSLGet("https://tui2-mbbcallcc04.audi-connect.com/ccc/callcenter/v1/PorscheCN/Porsche/cn/routing/+861089729390/data", new HashMap() {
			{
				put("Authorization", "Basic Y2FsbENlbnRlcjpQb3JzY2hlQ2hpbmE=");
			}
		}, "utf-8"));
	}
}