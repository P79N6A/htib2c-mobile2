package com.tencent.common.http;



import org.apache.commons.httpclient.NameValuePair;

/* *
 *类名：HttpRequest
 *功能：Http请求对象的封�?
 *详细：封装Http请求
 *版本�?3.3
 *日期�?2011-08-17
 *说明�?
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的�?要，按照�?术文档编�?,并非�?定要使用该代码�??
 *该代码仅供学习和研究支付宝接口使用，只是提供�?个参考�??
 */

public class HttpRequest {

    /** HTTP GET method */
    public static final String METHOD_GET        = "GET";

    /** HTTP POST method */
    public static final String METHOD_POST       = "POST";

    /**
     * �������url
     */
    private String             url               = null;

    /**
     * Ĭ�ϵ�����ʽ
     */
    private String             method            = METHOD_POST;

    private int                timeout           = 0;

    private int                connectionTimeout = 0;

    /**
     * Post��ʽ����ʱ��װ�õĲ���ֵ��
     */
    private NameValuePair[]    parameters        = null;

    /**
     * Get��ʽ����ʱ��Ӧ�Ĳ���
     */
    private String             queryString       = null;

    /**
     * Ĭ�ϵ�������뷽ʽ
     */
    private String             charset           = "GBK";

    /**
     * �����𷽵�ip��ַ
     */
    private String             clientIp;

    /**
     * ���󷵻صķ�ʽ
     */
    private HttpResultType     resultType        = HttpResultType.BYTES;

    public HttpRequest(HttpResultType resultType) {
        super();
        this.resultType = resultType;
    }

    /**
     * @return Returns the clientIp.
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * @param clientIp The clientIp to set.
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public NameValuePair[] getParameters() {
        return parameters;
    }

    public void setParameters(NameValuePair[] parameters) {
        this.parameters = parameters;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * @return Returns the charset.
     */
    public String getCharset() {
        return charset;
    }

    /**
     * @param charset The charset to set.
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    public HttpResultType getResultType() {
        return resultType;
    }

    public void setResultType(HttpResultType resultType) {
        this.resultType = resultType;
    }

}
