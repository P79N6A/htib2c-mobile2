package com.htichina.web.order;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by yiming on 2014/8/20.
 */
@FacesConverter(value="VinConverter")
public class VinConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        String mask = "";
        if(s != null && s.length() >= 7) {
            mask = "***********" + s.substring(s.length() - 6);
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
                if(s.length() >= 7) {
                    mask = "***********" + s.substring(s.length() - 6);
                } else {
                    mask = s;
                }
                return mask;
            }
        }

        return "";
    }
}

