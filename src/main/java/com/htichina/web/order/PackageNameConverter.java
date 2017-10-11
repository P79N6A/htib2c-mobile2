package com.htichina.web.order;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by yiming on 2014/8/20.
 */
@FacesConverter(value="PackageNameConverter")
public class PackageNameConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        if(s.equalsIgnoreCase("MB China Monthly Base Service")) {
            return "智能互联体验套餐";
        } else if(s.equalsIgnoreCase("M-B China Advanced Pre-Paid")) {
            return "优享套餐";
        } else if(s.equalsIgnoreCase("M-B China Premium Pre-Paid")) {
            return "尊享套餐";
        } else {
            return s;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o != null) {
            if (o instanceof String) {
                String s = (String) o;
                if(s.equalsIgnoreCase("MB China Monthly Base Service")) {
                    return "智能互联体验套餐";
                } else if(s.equalsIgnoreCase("M-B China Advanced Pre-Paid")) {
                    return "优享套餐";
                } else if(s.equalsIgnoreCase("M-B China Premium Pre-Paid")) {
                    return "尊享套餐";
                } else {
                    return s;
                }
            }
        }
        return "";
    }
}

