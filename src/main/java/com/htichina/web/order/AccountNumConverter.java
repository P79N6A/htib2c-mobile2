package com.htichina.web.order;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by yiming on 2014/8/20.
 */
@FacesConverter(value="AccountNumConverter")
public class AccountNumConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        String mask = "";
        if(s != null && s.length() >5) {
            mask = s.substring(0,2) + "****" + s.substring(s.length() - 2);
        } else {
            mask = s;
        }
        return mask;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o != null) {
            if (o instanceof String) {
                String s = (String) o;
                String mask = "";
                if(s.length() >= 5) {
                    mask = s.substring(0,2) + "****" + s.substring(s.length() - 2);
                } else {
                    mask = s;
                }
                return mask;
            }
            if (o instanceof Integer) {
                String s = String.valueOf((Integer) o);
                String mask = "";
                if(s.length() >= 5) {
                    mask = s.substring(0,2) + "****" + s.substring(s.length() - 2);
                } else {
                    mask = s;
                }
                return mask;
            }
        }

        return "";
    }
}

