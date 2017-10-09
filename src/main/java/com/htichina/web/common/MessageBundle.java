package com.htichina.web.common;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;

public class MessageBundle {
	public static Logger logger = Logger.getLogger(MessageBundle.class.getName());

	public static String getValue(String key) {
		String msg = "";

		try {
			FacesContext context = FacesContext.getCurrentInstance();

			UIViewRoot viewRoot = context.getViewRoot();
			Locale locale = viewRoot.getLocale();

			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			if (loader == null)
				loader = ClassLoader.getSystemClassLoader();

			ResourceBundle bundle = ResourceBundle.getBundle("/i18n/common/message", locale, loader);

			msg = bundle.getString(key);
		} catch (Exception e) {
			logger.error(ESAPI.encoder().encodeForHTML(e.getMessage().toString()));
		}

		return msg;
	}

    public static String getValue(String key, Object[] params) {
        String msg = "";
        String value = getValue(key);
        msg = MessageFormat.format(value, params);
        return msg;
    }
}
