package com.alipay.sign;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.owasp.esapi.ESAPI;

import com.alipay.config.AlipayConfig;
import com.htichina.common.web.ConfigureInfo;

/* 2017-11-01;Alex:将RSA的校验方式变成OAEP的，引入了第三方包bouncycastle来支持OAEP模式;CR-代码规范*/
public class RSA {

	public static final String SIGN_ALGORITHMS = ESAPI.encoder().encodeForHTML("SHA1WithRSA");

	public static final String ALGORITHMS = ESAPI.encoder().encodeForHTML("RSA");

	public static final String CIPHER_ALGORITHMS = "RSA/ECB/OAEPWITHSHA1AndMGF1Padding";

	/**
	 * RSA签名
	 * 
	 * @param content
	 *            待签名数据
	 * @param privateKey
	 *            商户私钥
	 * @param input_charset
	 *            编码格式
	 * @return 签名值
	 */
	public static String sign(String content, String privateKey, String input_charset) {
		try {
			Security.addProvider(new BouncyCastleProvider());
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance(ALGORITHMS);
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);
			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
			signature.initSign(priKey);
			signature.update(content.getBytes(input_charset));
			byte[] signed = signature.sign();
			return Base64.encode(signed);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * RSA验签名检查
	 * 
	 * @param content
	 *            待签名数据
	 * @param sign
	 *            签名值
	 * @param ali_public_key
	 *            支付宝公钥
	 * @param input_charset
	 *            编码格式
	 * @return 布尔值
	 */
	public static boolean verify(String content, String sign, String ali_public_key, String input_charset) {
		try {
			Security.addProvider(new BouncyCastleProvider());
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHMS);
			byte[] encodedKey = Base64.decode(ali_public_key);
			PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
			signature.initVerify(pubKey);
			signature.update(content.getBytes(input_charset));
			boolean bverify = signature.verify(Base64.decode(sign));
			return bverify;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            密文
	 * @param private_key
	 *            商户私钥
	 * @param input_charset
	 *            编码格式
	 * @return 解密后的字符串
	 */
	public static String decrypt(String content, String private_key, String input_charset) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		PrivateKey prikey = getPrivateKey(private_key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHMS);
		cipher.init(Cipher.DECRYPT_MODE, prikey);
		InputStream ins = new ByteArrayInputStream(Base64.decode(content));
		ByteArrayOutputStream writer = new ByteArrayOutputStream();
		// rsa解密的字节大小最多是128，将需要解密的内容，按128位拆开解密
		byte[] buf = new byte[128];
		int bufl;
		while ((bufl = ins.read(buf)) != -1) {
			byte[] block = null;

			if (buf.length == bufl) {
				block = buf;
			} else {
				block = new byte[bufl];
				for (int i = 0; i < bufl; i++) {
					block[i] = buf[i];
				}
			}
			writer.write(cipher.doFinal(block));
		}
		return new String(writer.toByteArray(), input_charset);
	}

	/**
	 * 得到私钥
	 * 
	 * @param key
	 *            密钥字符串（经过base64编码）
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey(String key) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		byte[] keyBytes;
		keyBytes = Base64.decode(key);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHMS);
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}
	
	public static void main(String[] args) throws Exception, NoSuchProviderException {
		String data = "111";
		System.out.println("加密前：" + data);
		X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(Base64.decode(ConfigureInfo.getAlipayAppPublicKey()));
		KeyFactory keyf = KeyFactory.getInstance(ALGORITHMS);
		PublicKey pubKey = keyf.generatePublic(pubX509);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHMS);
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		byte[] dataToEncrypt = data.getBytes("utf-8");
		byte[] encryptedData = cipher.doFinal(dataToEncrypt);
		String encryptString = Base64.encode(encryptedData);
		System.out.println("加密后："+encryptString);
		String sign = sign(encryptString, ConfigureInfo.getAlipayAppPrivateKey(), AlipayConfig.input_charset);
		System.out.println("sign："+sign);
		boolean verify = verify(encryptString, sign, ConfigureInfo.getAlipayAppPublicKey(), AlipayConfig.input_charset);
		System.out.println(verify);
		String decrypt = decrypt(encryptString, ConfigureInfo.getAlipayAppPrivateKey(), AlipayConfig.input_charset);
		System.out.println("解密："+decrypt);
	}
}
