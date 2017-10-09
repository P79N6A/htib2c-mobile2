package com.htichina.web.order;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by yiming on 2014/8/20.
 */
@FacesConverter(value="UserNameConverter")
public class UserNameConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        String mask = "";
        if(s != null) {
            mask = s;
            if(s.startsWith(".")) {
                mask = s.substring(1);
            }
            mask = mask.trim();
            if(mask.length() > 1) {
                mask = mask.substring(0,1) + "**";
            }
        }
        return mask;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o != null) {
            if (o instanceof String) {
                String s = (String) o;
                String mask = s;
                if(s.startsWith(".")) {
                    mask = s.substring(1);
                }
                mask = mask.trim();
                if(mask.length() > 1) {
                    mask = mask.substring(0,1) + "**";
                }
                return mask;
            }
        }

        return "";
    }
}

