package com.tencent.common.http;




import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.conn.ssl.SSLSocketFactory;

public class MySSLSocketFactory extends SSLSocketFactory{
	
	static{
		mySSLSocketFactory = new MySSLSocketFactory(createSContext());
	}
	
	private static MySSLSocketFactory mySSLSocketFactory = null;
	
	
	
	private static SSLContext createSContext(){
		SSLContext sslcontext = null;
		try {
			sslcontext = SSLContext.getInstance("SSL");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			/*2017-10-25;Alex:优化代码，代码分开定义，避免错误;CR-代码规范*/
			TrustAnyTrustManager trustManager = new TrustAnyTrustManager();
			TrustManager[] trustManagers = new TrustManager[]{trustManager};
			sslcontext.init(null,trustManagers, null);
		} catch (KeyManagementException e) {
			e.printStackTrace();
			return null;
		}
		return sslcontext;
	}
	
	private MySSLSocketFactory(SSLContext sslContext) {
		super(sslContext);
		this.setHostnameVerifier(ALLOW_ALL_HOSTNAME_VERIFIER);
	}
	
	public static MySSLSocketFactory getInstance(){
		if(mySSLSocketFactory != null){
			return mySSLSocketFactory;
		}else{
			return mySSLSocketFactory = new MySSLSocketFactory(createSContext());
		}
	}
	
}