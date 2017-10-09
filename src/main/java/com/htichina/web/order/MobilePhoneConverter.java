package com.htichina.web.order;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by yiming on 2014/8/20.
 */
@FacesConverter(value="MobilePhoneConverter")
public class MobilePhoneConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        String mask = s;
        if(mask != null && mask.length() >= 11) {
            if(mask.startsWith("86")) mask = mask.substring(2);
            mask = mask.substring(0,3) + "****" + mask.substring(s.length() - 4);
        }
        return mask;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o != null) {
            if (o instanceof String) {
                String s = (String) o;
                String mask = s;
                if(mask.length() >= 11) {
                    if(mask.startsWith("86")) mask = mask.substring(2);
                    mask = mask.substring(0,3) + "****" + mask.substring(mask.length() - 4);
                }
                return mask;
            }
        }

        return "";
    }
}

